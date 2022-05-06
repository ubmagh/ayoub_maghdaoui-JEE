package me.ubmagh.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String id;
    private String name;
    private double price;
    private double quantity;
    private CategoryDTO categoryDTO;

}
