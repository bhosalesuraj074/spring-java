package com.spring.security.utility;

    import io.jsonwebtoken.Claims;
    import io.jsonwebtoken.Jwts;
    import io.jsonwebtoken.io.Decoders;
    import io.jsonwebtoken.security.Keys;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.stereotype.Service;

    import javax.crypto.SecretKey;
    import java.util.Date;
    import java.util.HashMap;
    import java.util.Map;
    import java.util.function.Function;

    /**
     * Utility class for handling JWT operations such as creation, validation, and parsing.
     */
    @Service
    public class JWTUtil {
        /** Token validity period in seconds (5 hours). */
        public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

        /** Secret key for signing JWT tokens (Base64 encoded). */
        private String secret = "afafasfafafasfasfasfafacasdasfasxASFACASDFACASDFASFASFDAFASFASDAADSCSDFADCVSGCFVADXCcadwavfsfarvf";

        /**
         * Generates a SecretKey from the Base64-encoded secret.
         * @return SecretKey for signing JWTs
         */
        private SecretKey getSignKey() {
            byte[] keyBytes = Decoders.BASE64.decode(secret);
            return Keys.hmacShaKeyFor(keyBytes);
        }

        /**
         * Extracts the username (subject) from the JWT token.
         * @param token JWT token
         * @return Username from token
         */
        public String getUsernameFromToken(String token) {
            return getClaimFromToken(token, Claims::getSubject);
        }

        /**
         * Extracts the expiration date from the JWT token.
         * @param token JWT token
         * @return Expiration date
         */
        public Date getExpirationDateFromToken(String token) {
            return getClaimFromToken(token, Claims::getExpiration);
        }

        /**
         * Extracts a specific claim from the JWT token using a resolver function.
         * @param token JWT token
         * @param claimsResolver Function to extract claim
         * @param <T> Type of the claim
         * @return Extracted claim
         */
        public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
            final Claims claims = getAllClaimsFromToken(token);
            return claimsResolver.apply(claims);
        }

        /**
         * Parses the JWT token and retrieves all claims.
         * @param token JWT token
         * @return Claims object
         */
        private Claims getAllClaimsFromToken(String token) {
            return Jwts.parser()
                    .verifyWith(getSignKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        }

        /**
         * Checks if the JWT token is expired.
         * @param token JWT token
         * @return true if expired, false otherwise
         */
        private Boolean isTokenExpired(String token) {
            final Date expiration = getExpirationDateFromToken(token);
            return expiration.before(new Date());
        }

        /**
         * Generates a JWT token for the given user details.
         * @param userDetails User details
         * @return JWT token
         */
        public String generateToken(UserDetails userDetails) {
            Map<String, Object> claims = new HashMap<>();
            return doGenerateToken(claims, userDetails.getUsername());
        }

        /**
         * Builds the JWT token with claims and subject.
         * @param claims Claims to include
         * @param subject Subject (username)
         * @return JWT token
         */
        private String doGenerateToken(Map<String, Object> claims, String subject) {
            return Jwts.builder()
                    .claims(claims)
                    .subject(subject)
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                    .signWith(getSignKey(), Jwts.SIG.HS512)
                    .compact();
        }

        /**
         * Validates the JWT token against the user details.
         * @param token JWT token
         * @param userDetails User details
         * @return true if valid, false otherwise
         */
        public Boolean validateToken(String token, UserDetails userDetails) {
            final String username = getUsernameFromToken(token);
            return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
        }

    }