package com.jm.crud.controllers;

import java.util.List;

import com.jm.crud.models.ProductDTO;
import com.jm.crud.repositories.IProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private IProductDAO repository;

	@PostMapping("/product")
	public ProductDTO create(@RequestBody ProductDTO p) {
		return repository.insert(p);
	}

	@GetMapping("/list")
	public List<ProductDTO> readAll() {
		return repository.findAll();
	}

	@PutMapping("/product/{id}")
	public ProductDTO update(@PathVariable String id, @Validated @RequestBody ProductDTO p) {
		ProductDTO pro = repository.findById(id).orElseThrow(RuntimeException::new);
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setExpiry_date(p.getExpiry_date());
		return repository.save(pro);
	}

	@DeleteMapping("/product/{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(id);
	}

}
