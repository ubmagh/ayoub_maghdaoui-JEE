package me.ubmagh.ecom.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.ubmagh.ecom.entities.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CategoryDTO {

    private Long id;
    private String name;


}
