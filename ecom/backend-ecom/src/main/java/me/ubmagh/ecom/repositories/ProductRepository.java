package me.ubmagh.ecom.repositories;

import me.ubmagh.ecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @RepositoryRestResource // when there's no custom traitement on the request, it passes  directly to DB
                           // here, when creating a product, the id must be set
@Repository
public interface ProductRepository extends JpaRepository< Product, String> {



}
