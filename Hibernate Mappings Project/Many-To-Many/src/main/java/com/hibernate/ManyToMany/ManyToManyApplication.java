package com.hibernate.ManyToMany;

import com.hibernate.ManyToMany.entity.Category;
import com.hibernate.ManyToMany.entity.Product;
import com.hibernate.ManyToMany.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;

@SpringBootApplication
public class ManyToManyApplication  implements CommandLineRunner {

	@Autowired
	CategoryRepository categoryRepository;



	//when we check from both the end and found the one to many relationship on each end than we consider it as a many to many relationship.
	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		//create the products
		Product product1 = new Product();
		product1.setProductId(1);
		product1.setProductName("Iphone");
		product1.setPrice(70000);

		Product product2 = new Product();
		product2.setProductId(2);
		product2.setProductName("Dell");
		product2.setPrice(60000);

		Product product3 = new Product();
		product3.setProductId(3);
		product3.setProductName("Lenovo");
		product3.setPrice(35000);

		//create multiple category
		Category category1 = new Category();
		category1.setCategoryId(1);
		category1.setCategoryType("Electronics Item");

		Category category2 = new Category();
		category2.setCategoryId(2);
		category2.setCategoryType("Mobiles");

		Category category3 = new Category();
		category3.setCategoryId(3);
		category3.setCategoryType("Laptop");


		//create list of category1 products
		List<Product> category1Products = category1.getProductList();
		category1Products.add(product1);
		category1Products.add(product2);
		category1Products.add(product3);

		//create list of category1 products
		List<Product> category2Products = category2.getProductList();
		category2Products.add(product1);
		category2Products.add(product3);

		//create list of category1 products
		List<Product> category3Products = category3.getProductList();
		category3Products.add(product2);
		category3Products.add(product3);

		//save our categories
        categoryRepository.save(category1);
		categoryRepository.save(category2);
		categoryRepository.save(category3);



	}
}
