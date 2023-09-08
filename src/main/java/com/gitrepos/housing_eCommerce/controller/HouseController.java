package com.gitrepos.housing_eCommerce.controller;

import com.gitrepos.housing_eCommerce.entity.House;
import com.gitrepos.housing_eCommerce.service.HousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("housing")
public class HouseController {

    private final HousingService housingService;
    @Autowired
    public HouseController(HousingService housingService) {
        this.housingService = housingService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<House> getHouseById (@PathVariable("id") Integer id){
        House house = housingService.findHouseById(id);
        return new ResponseEntity<>(house, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<House>> findAllHouses () {
        List<House> houseList = housingService.findAllHouses();
        return new ResponseEntity<>(houseList,HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addHouse (@RequestBody House house){
        House newHouse = housingService.addHouse(house);
        new ResponseEntity<>(newHouse, HttpStatus.CREATED);
    }

    @PostMapping("/addAll")
    public void addListOfHouses () {
        List<House> houseList = housingService.giveList();
        houseList.forEach(this::addHouse);
    }

}
