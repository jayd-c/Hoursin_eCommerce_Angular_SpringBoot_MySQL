package com.gitrepos.housing_eCommerce.service;

import com.gitrepos.housing_eCommerce.entity.House;
import com.gitrepos.housing_eCommerce.exception.HouseNotFoundException;
import com.gitrepos.housing_eCommerce.repository.HousingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HousingService {

    private final HousingRepository repository;

    @Autowired
    public HousingService(HousingRepository repository) {
        this.repository = repository;
    }

    public House findHouseById (Integer id) {
        return repository.findHouseById(id).
                orElseThrow(()-> new HouseNotFoundException("House by id number " + id + " was not found in the system!"));
    }

    public void addListOfHouses (List<House> houseList) {
        houseList.forEach(house -> {
            repository.save(house);
        });
    }



    public House addHouse(House house) {
       return repository.save(house);
    }

    public List<House> findAllHouses() {
        return repository.findAll();
    }

    String baseUrl = "https://angular.io/assets/images/tutorials/faa/";
    House house1 = new House("Acme Fresh Start Housing", "Chicago","IL", baseUrl+"bernard-hermant-CLKGGwIBTaY-unsplash.jpg",4,true,true);
    House house2 = new House("A113 Transitional Housing","Alberto","CA", baseUrl+"brandon-griggs-wR11KBaB86U-unsplash.jpg",0,false,true);
    House house3 = new House("Warm Beds housing support","Junew","AK",baseUrl+"i-do-nothing-but-love-lAyXdl1-Wmc-unsplash.jpg",1,false,true);
    House house4 = new House("Homestay Housing","Chicago","IL",baseUrl+"ian-macdonald-W8z6aiwfi1E-unsplash.jpg",2,true,false);
    House house5 = new House("Happy Homes Group","Gary","IN",baseUrl+"krzysztof-hepner-978RAXoXnH4-unsplash.jpg",1,true,false);
    House house6 = new House("Hopeful Apartment Group","Oakland","GA",baseUrl+"r-architecture-JvQ0Q5IkeMM-unsplash.jpg",2,true,false);
    House house7 = new House("Seriously Safe Towns","Oakland","CA",baseUrl+"phil-hearing-IYfp2Ixe9nM-unsplash.jpg",5,true,true);
    House house8 = new House("Hopeful Housing Solutions","Oakland","CA",baseUrl+"r-architecture-GGupkreKwxA-unsplash.jpg",2,true,true);
    House house9 = new House("Royal Oak Parts","South Brunswick","NJ",baseUrl+"saru-robert-9rP3mxf8qWI-unsplash.jpg",10,false,false);
    House house10 = new House("Capital Safe House","Portland","OR",baseUrl+"webaliser-_TPTXZd9mOo-unsplash.jpg",6,true,true);

    House[] arr = {house1,house2,house3,house4,house5,house6,house8,house9,house10};
    public List<House> giveList(){
        return new ArrayList<>(List.of(arr));
    }

}
