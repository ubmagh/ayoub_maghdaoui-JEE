package me.ubmagh.ecom.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.ubmagh.ecom.dtos.ProductDTO;
import me.ubmagh.ecom.entities.Product;
import me.ubmagh.ecom.mappers.CatalogMapper;
import me.ubmagh.ecom.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;



@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    // why AllArgsConstructor annotation not injecting it !!!!!!!!!!!
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public ProductDTO save( ProductDTO productDTO) {

        Product product = catalogMapper.fromProductDTO( productDTO);
        product.setId(UUID.randomUUID().toString());

        return catalogMapper.fromProduct( productRepository.save( product) );
    }

    @Override
    public List<ProductDTO> productDTOList(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        productDTOList.addAll( products.stream().map(product -> catalogMapper.fromProduct(product)).collect(Collectors.toList()) );
        return productDTOList;
    }
}
