package me.ubmagh.ecom.services;


import me.ubmagh.ecom.dtos.ProductDTO;

import java.util.List;

public interface IProductService {

    public ProductDTO save(ProductDTO productDTO);
    public List<ProductDTO> productDTOList();

}
