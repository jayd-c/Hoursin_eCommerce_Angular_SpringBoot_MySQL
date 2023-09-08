package com.gitrepos.housing_eCommerce.repository;

import com.gitrepos.housing_eCommerce.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HousingRepository extends JpaRepository<House,Integer> {

    Optional<House> findHouseById (int id);
}
