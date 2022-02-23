package demo.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import demo.entity.Product;
import demo.entity.ProductCategory.Category;


public interface ProductRepository extends CrudRepository<Product, Long> {
//Spring generates CRUD methods based on the method name
	List<Product> findProductsByCategory(Category category);
//Also comes with other declared methods
  
}
