package com.codingdojo.prodCat.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.prodCat.models.CategoryProduct;

@Repository
public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {
	
	List<CategoryProduct> findAll();

	List<CategoryProduct> findAllByProduct_id(Long id);
	List<CategoryProduct> findAllByCategory_id(Long id);

	List<CategoryProduct> findAllByProduct_IdNot(Long id);
	
}
