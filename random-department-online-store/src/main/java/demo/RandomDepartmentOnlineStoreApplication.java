package demo;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.entity.CustomerAccount;
import demo.entity.Product;
import demo.entity.ProductCategory;
import demo.entity.ProductCategory.Category;
import demo.repository.CustomerAccountRepository;
import demo.repository.ProductCategoryRepository;
import demo.repository.ProductRepository;

@SpringBootApplication
public class RandomDepartmentOnlineStoreApplication implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication.run(RandomDepartmentOnlineStoreApplication.class, args);
	}
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerAccountRepository accountRepository;
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Override
	public void run(String... args) throws Exception {
//		for(Category categoryValue:Category.values()) {
//			//Solution provided by https://zetcode.com/springboot/findbyid/
//			//https://stackoverflow.com/questions/51747549/crudrepository-findbyid-dont-return-java-util-optional
//			Optional<ProductCategory> existingCategory = productCategoryRepository.findByCategoryName(categoryValue);
//			if(existingCategory.isPresent()) {
//				ProductCategory cat = existingCategory.get();
//				System.out.println(cat);
//				cat.setImageURL("default_category_picture.jpg");
//				cat.setDescription("Placeholder");
//			}else {
//				ProductCategory cat = new ProductCategory(categoryValue, "default_category_picture.jpg", "Placeholder");
//				productCategoryRepository.save(cat);
//			}			
//		}
//        final Resource fileResource = resourceLoader.getResource("classpath:static/json/productData.json");
//		ObjectMapper mapper = new ObjectMapper();
//		TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>(){};
//		InputStream inputStream = fileResource.getInputStream();
//		try {
//			List<Product> products = mapper.readValue(inputStream,typeReference);
//			productRepository.saveAll(products);
//		} catch (IOException e){
//			System.out.println("Unable to save initialise intitial product data: " + e.getMessage());
//		}
//        final Resource fileResource2 = resourceLoader.getResource("classpath:static/json/CustomerAccountData.json");
//		TypeReference<List<CustomerAccount>> accountReference = new TypeReference<List<CustomerAccount>>(){};
//		inputStream = fileResource2.getInputStream();
//		try {
//			List<CustomerAccount> accounts = mapper.readValue(inputStream,accountReference);
//			for(CustomerAccount account:accounts) {
//				String password = account.getPassword();
//				account.setPassword(passwordEncoder.encode(password));				
//			}
//			accountRepository.saveAll(accounts);
//		} catch (IOException e){
//			System.out.println("Unable to save initialise intitial customer account repository: " + e.getMessage());
//		}
	}

}
