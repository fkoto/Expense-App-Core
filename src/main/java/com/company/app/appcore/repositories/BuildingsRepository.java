package com.company.app.appcore.repositories;

import com.company.app.appcore.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingsRepository extends JpaRepository<Building, String> {
}
