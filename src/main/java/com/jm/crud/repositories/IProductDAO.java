package com.jm.crud.repositories;

import com.jm.crud.models.ProductDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProductDAO extends MongoRepository<ProductDTO, String> {
	
	
}
