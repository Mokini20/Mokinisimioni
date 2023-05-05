package com.benezeth.MockinApp.repository;

import com.benezeth.MockinApp.entity.VillageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("ALL")
public interface VillageRepository extends JpaRepository<VillageEntity,Long> {
    //all crud code for database
}
