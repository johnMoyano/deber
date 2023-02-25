package com.jm.crud.models;
import java.time.LocalDate;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ProductDTO {

	@Id
	private String _id;

	private String name;

	private Double price;

	private LocalDate expiry_date;

}