package com.example.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.delegate.SendingServiceDelegate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@RestController
public class SendingServiceController {
    Scanner sc=new Scanner(System.in);
    SendingServiceDelegate sendingServiceDelegate;
    @Autowired
    public SendingServiceController(SendingServiceDelegate sendingServiceDelegate) {
        super();
        this.sendingServiceDelegate = sendingServiceDelegate;
    }

    @RequestMapping(value = "/getPetrolDetailsForCity", method = RequestMethod.GET)
    public String getDetails() {
        String mercedes_data = null;
        Boolean fuelLidStatus;
        System.out.println("Want To Refill,Open Fuel Lid ?true/false");
        fuelLidStatus=sc.nextBoolean();
        if(fuelLidStatus==false)
        {
           return "Keep Driving.Tank is Filled.";
        }
        else
        {

            Random rand = new Random();
            List<String> cityList = Arrays.asList("Delhi", "Hyderabad","Haridwar","Dheradun", "Roorkee", "Kota","Manali","Shimla");
            int size=cityList.size();
            int randomIndex=rand.nextInt(cityList.size());
            String cityname;
            while(size!=0)
            {

                cityname = cityList.get(randomIndex);
                mercedes_data=sendingServiceDelegate.callPetrolPriceAPIServiceAndGetData(cityname);
                size--;
            }

            return mercedes_data;

        }



    }


}
