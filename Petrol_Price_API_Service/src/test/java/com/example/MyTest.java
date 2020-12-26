package com.example;
import com.example.controller.PetrolPriceAPIController;
import org.junit.Assert;
import org.junit.Test;

public class MyTest {
    @Test
    public void CityFound()
    {
        PetrolPriceAPIController petrolPriceAPIController=new PetrolPriceAPIController();

        int result=petrolPriceAPIController.getDetails("Hyderabad");

        Assert.assertEquals(90,result);

    }
    @Test
    public void CityNotFound()
    {
        PetrolPriceAPIController petrolPriceAPIController=new PetrolPriceAPIController();

        int result=petrolPriceAPIController.getDetails("Kerela");

        Assert.assertEquals(0,result);

    }
}
