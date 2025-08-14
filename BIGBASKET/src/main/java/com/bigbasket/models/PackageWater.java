package com.bigbasket.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "PackageWater")
public class PackageWater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PackageWater_id")
    private List<PackSize> packSize;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AboutProduct_id")
    private AboutProduct aboutProduct;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProductInfo_id")
    private ProductInfo productInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Manufactured_id")
    private Manufactured manufactured;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ContactDetails_id")
    private ContactDetails contactDetails;
}