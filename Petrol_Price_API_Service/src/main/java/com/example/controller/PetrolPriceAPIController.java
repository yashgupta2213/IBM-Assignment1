package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import com.example.model.Price;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PetrolPriceAPIController {
    public PetrolPriceAPIController() {
    }

    private static Map<String, Price> mercedesDB;

    static {
        mercedesDB = new HashMap<>();
        Price petrolprice=new Price(82);
        mercedesDB.put("Delhi", petrolprice);
        petrolprice=new Price(90);
        mercedesDB.put("Hyderabad", petrolprice);
        petrolprice=new Price(80);
        mercedesDB.put("Roorkee", petrolprice);
        petrolprice=new Price(76);
        mercedesDB.put("Dheradun", petrolprice);
        petrolprice=new Price(78);
        mercedesDB.put("Kota", petrolprice);

    }




    @RequestMapping(value = "/getPetrolDetailsForCity/{cityname}", method = RequestMethod.GET)
    public int getDetails(@PathVariable String cityname) {


        Price priceList = mercedesDB.get(cityname);  //checking city
        try{
            if (!mercedesDB.containsKey(cityname)) {
                return 0;   //if no city is found
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return priceList.getPetrol_price();    //sending price coresponding to the city found

    }
}
