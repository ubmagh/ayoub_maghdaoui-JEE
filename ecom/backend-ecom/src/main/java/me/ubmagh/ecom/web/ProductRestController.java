package me.ubmagh.ecom.web;

import lombok.AllArgsConstructor;
import me.ubmagh.ecom.dtos.ProductDTO;
import me.ubmagh.ecom.entities.Product;
import me.ubmagh.ecom.repositories.ProductRepository;
import me.ubmagh.ecom.services.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@AllArgsConstructor
public class ProductRestController {

    private ProductRepository productRepository;
    private ProductServiceImpl productService;

    @GetMapping("/products")
    public List<ProductDTO> productList(){
        return productService.productDTOList();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(  @PathVariable(name="id") String id ){
        return productRepository.findById(id).get();
    }

    @PostMapping("/products")
    public ProductDTO newProduct( @RequestBody ProductDTO product){ // look for product attributes in the request body
        return productService.save(product);
    }

    @PutMapping("/products/{id}")
    public ProductDTO updateProduct( @RequestBody ProductDTO product, @PathVariable(name = "id") String id){
        product.setId( id );
        return  productService.save( product );
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct( @PathVariable(name = "id") String id){
        productRepository.deleteById( id);
    }
}
