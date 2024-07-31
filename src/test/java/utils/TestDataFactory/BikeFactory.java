package utils.TestDataFactory;

import com.github.javafaker.Faker;
import enums.BikeBrand;
import models.Bike;


public class BikeFactory {
    static Faker faker = new Faker();

    public static Bike addNewBike() {
        return Bike.builder()
                .bikeName(faker.name().title())
                .bikeBrand(BikeBrand.CUBE)
                .model(faker.name().firstName())
                .cost("599.99")
                .datePurchased("9/25/2022")
                .distance("20.6")
                .notes(faker.esports().event())
                .build();

    }

}

