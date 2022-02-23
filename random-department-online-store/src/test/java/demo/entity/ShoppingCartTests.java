package demo.entity;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import demo.repository.CartItemRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)//Run this against a real database
@Rollback(false)
public class ShoppingCartTests {
	@Autowired
	private CartItemRepository cartRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
//	@Test
//	public void testAddOneCartItem() {
//		Product product = entityManager.find(Product.class, 20); //20 is the primary key of one the Products
//		CustomerAccount customerAccount = entityManager.find(CustomerAccount.class, 2);
//		CartItem newItem = new CartItem(customerAccount, product, 1);
//		CartItem savedCartItem = cartRepo.save(newItem);
//		assertTrue(savedCartItem.getId()> 0);
//		
//	}
//	@Test
//	public void testGetCartItemsByCustomer() {
//		CustomerAccount customer = new CustomerAccount();
//		customer.setId(3L);
//		List<CartItem> cartItems = cartRepo.findByCustomerAccount(customer);
//		
//		assertEquals(2, cartItems.size());
//	}

}
