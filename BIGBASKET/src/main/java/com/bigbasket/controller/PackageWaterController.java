package com.bigbasket.controller;

    import com.bigbasket.models.PackageWater;
    import com.bigbasket.service.PackageWaterService;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/package-water")
    public class PackageWaterController {
        @Autowired
        private PackageWaterService packageWaterService;

        @GetMapping
        public ResponseEntity<List<PackageWater>> getAllPackageWater() {
            List<PackageWater> packageWaterList = packageWaterService.getAllPackageWater();
            if (packageWaterList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(packageWaterList);
        }

        @GetMapping("/{id}")
        public ResponseEntity<PackageWater> getPackageWaterById(@PathVariable Long id) {
            PackageWater packageWater = packageWaterService.getPackageWaterById(id);
            return ResponseEntity.ok(packageWater);
        }

        @PostMapping
        public ResponseEntity<PackageWater> createPackageWater( @RequestBody PackageWater packageWater) {
            PackageWater createdPackageWater = packageWaterService.createPackageWater(packageWater);
            return ResponseEntity.status(201).body(createdPackageWater);
        }

        // In PackageWaterController.java
        @PutMapping("/{id}")
        public ResponseEntity<PackageWater> updatePackageWater(@PathVariable Long id, @RequestBody PackageWater packageWater) {
            // Ensure the ID from the path is used
            PackageWater existingPackageWater = packageWaterService.getPackageWaterById(id);
            existingPackageWater.setPackSize(packageWater.getPackSize());
            existingPackageWater.setAboutProduct(packageWater.getAboutProduct());
            existingPackageWater.setProductInfo(packageWater.getProductInfo());
            existingPackageWater.setContactDetails(packageWater.getContactDetails());
            // The service layer handles the actual update (which is a save operation)
            PackageWater updatedPackageWater = packageWaterService.createPackageWater(existingPackageWater);
            return ResponseEntity.ok(updatedPackageWater);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePackageWater(@PathVariable Long id) {
            packageWaterService.getPackageWaterById(id);
            packageWaterService.deletePackageWater(id);
            return ResponseEntity.noContent().build();
        }
    }