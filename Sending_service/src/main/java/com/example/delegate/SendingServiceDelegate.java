package com.example.delegate;

import com.example.entity.Mercedes_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class SendingServiceDelegate {

    RestTemplate restTemplate;

    @Autowired
    public SendingServiceDelegate(RestTemplate restTemplate) {
        super();
        this.restTemplate = restTemplate;
    }
    public SendingServiceDelegate() {
    }
    public Mercedes_data getDetails(int price,String cityname)
    {

            Mercedes_data mercedes_data=new Mercedes_data();
            mercedes_data.setCity(cityname);
            mercedes_data.setBill_amount(price*80);
            mercedes_data.setTime_required((30*80)/60);
            mercedes_data.setPetrol_price(price);
            mercedes_data.setFuel_lid_status(true);
            return mercedes_data;


    }


    public String callPetrolPriceAPIServiceAndGetData(String cityname) {
        Mercedes_data mercedes_data;
        String response = restTemplate.exchange("http://localhost:8010/getPetrolDetailsForCity/{cityname}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        },cityname).getBody();

        Pattern p = Pattern.compile("[0-9]+");//using regular expression
        Matcher m = p.matcher(response);
        int updatedprice=0;
        while (m.find()) {
            updatedprice = Integer.parseInt(m.group());
            // append n to list
        }
        if(updatedprice==0)
        {
            return "City not Found.Petrol Price Not Available.";

        }
        else
        {
            mercedes_data= getDetails(updatedprice,cityname);
            return mercedes_data.toString();
        }



    }


}
