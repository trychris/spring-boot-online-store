package demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import demo.entity.CartItem;
import demo.entity.CustomerAccount;
import demo.entity.Product;

@Transactional //https://www.programmersought.com/article/5471445388/
@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Long>{
	public List<CartItem> findByCustomerAccount(CustomerAccount customer);
	public CartItem findByCustomerAccountAndProduct(CustomerAccount customer, Product product);
//	prevent SQL injection vulnerabilities,
//	get automatically converted to the correct SQL type and
//	enable your persistence provider and database to optimize your query.
	@Query("UPDATE CartItem c SET c.quantity = :quantity WHERE c.product = :product AND c.customerAccount = :customer")
	@Modifying
	public void updateQuantity(Integer quantity, @Param("product")Product product, 
			@Param("customer") CustomerAccount customer);
	
	public void deleteByCustomerAccountAndProduct(CustomerAccount customer, Product product);
}
