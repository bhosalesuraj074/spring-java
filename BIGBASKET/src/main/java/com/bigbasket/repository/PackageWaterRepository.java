package com.bigbasket.repository;

import com.bigbasket.models.PackageWater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageWaterRepository extends JpaRepository<PackageWater, Long> {

}
