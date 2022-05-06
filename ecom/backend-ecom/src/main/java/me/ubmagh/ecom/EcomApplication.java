package me.ubmagh.ecom;

import me.ubmagh.ecom.entities.Category;
import me.ubmagh.ecom.entities.Product;
import me.ubmagh.ecom.repositories.CategoryRepository;
import me.ubmagh.ecom.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EcomApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomApplication.class, args);
    }

    @Bean
    CommandLineRunner generateCategoriesProducts(CategoryRepository categoryRepository, ProductRepository productRepository ){
        return args -> {
            Stream.of( "Computers", "Printers", "SmartPhones").forEach(s ->
                    categoryRepository.save(
                            new Category(
                                    null,
                                    s,
                                    null
                            )
                    )
            );

            categoryRepository.findAll().forEach(category -> {
                int i=5;
                while( i-->0){
                    Product product = new Product();
                    product.setName("Product-"+(i+1)+"-"+category.getName());
                    product.setQuantity( Math.random()*23 );
                    product.setPrice( Math.random()*93 );
                    product.setCategory( category );
                    product.setId( UUID.randomUUID().toString() );
                    productRepository.save( product );
                }
            });

        };
    }

    CommandLineRunner generateProducts(ProductRepository productRepository){
        return args -> {
            Stream.of( "Computer", "Printer", "SmartPhone").forEach(s ->
                    productRepository.save(
                            new Product(
                                    UUID.randomUUID().toString(),
                                    s,
                                    Math.random()*973,
                                    Math.random()*77,
                                    null
                            )
                    )
            );
        };
    }

}
