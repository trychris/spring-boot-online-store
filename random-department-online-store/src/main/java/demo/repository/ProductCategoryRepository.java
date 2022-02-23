package demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demo.entity.ProductCategory;
import demo.entity.ProductCategory.Category;

//CrudRepository declares about a dozen methods for CRUD (create, read, update, delete) operations.
//there’s no need to write an implementation. When the application starts, Spring Data JPA automatically
//generates an implementation on the fly. This means the repositories are ready to use from
//the get-go. Just inject them into the controllers like you did for the JDBC-based implementations, 
//and you’re done. - Spring in Action

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
	Optional<ProductCategory> findByCategoryName(Category cat);
  
}
