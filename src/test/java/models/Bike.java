package models;

import enums.BikeBrand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bike {
    private String bikeName;
    private String model;
    private String cost;
    private String datePurchased;
    private String distance;
    private String notes;
    BikeBrand bikeBrand;

}

