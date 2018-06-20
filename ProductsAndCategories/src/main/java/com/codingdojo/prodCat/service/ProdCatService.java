package com.codingdojo.prodCat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.prodCat.models.Category;
import com.codingdojo.prodCat.models.CategoryProduct;
import com.codingdojo.prodCat.models.Product;
import com.codingdojo.prodCat.repository.CategoryProductRepository;
import com.codingdojo.prodCat.repository.CategoryRepository;
import com.codingdojo.prodCat.repository.ProductRepository;

@Service
public class ProdCatService {
	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;
	private final CategoryProductRepository categoryProductRepo;
	
	public ProdCatService(ProductRepository productRepo, CategoryRepository categoryRepo, CategoryProductRepository categoryProductRepo
	) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
		this.categoryProductRepo = categoryProductRepo;
	}
	
	public List<Product> allProduct(){
		return productRepo.findAll();
	}
	
	public List<Category> allCategory(){
		return categoryRepo.findAll();
	}
	
	public List<CategoryProduct> allCatProd(){
		return categoryProductRepo.findAll();
	}
	
	public Product createProduct(Product p) {
		return productRepo.save(p);
	}
	
	public Category createCategory(Category c) {
		return categoryRepo.save(c);
	}
	
	public CategoryProduct createCatProd(CategoryProduct cp) {
		return categoryProductRepo.save(cp);
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public List<CategoryProduct> findProdCat(Long id) {
		return categoryProductRepo.findAllByProduct_id(id);
	}
	
	public List<CategoryProduct> findProdCatNot(Long id) {
		return categoryProductRepo.findAllByProduct_IdNot(id);
	}
	
	public List<CategoryProduct> findCatProd(Long id){
		return categoryProductRepo.findAllByCategory_id(id);
	}

	public List<Category> findAllCat() {
		return categoryRepo.findAll();
	}
	
	public List<Product> findAllProd(){
		return productRepo.findAll();
	}
}
