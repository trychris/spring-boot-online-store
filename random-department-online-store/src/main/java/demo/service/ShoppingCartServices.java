package demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.CartItem;
import demo.entity.CustomerAccount;
import demo.entity.Product;
import demo.repository.CartItemRepository;

@Service
public class ShoppingCartServices {
	@Autowired
	private CartItemRepository cartRepo;
	
	public List<CartItem> listCartItems(CustomerAccount customer){
		return cartRepo.findByCustomerAccount(customer);
	}
	
	public Integer addProduct(CustomerAccount customerAccount, Product product, Integer quantity) {
		CartItem cartItem = cartRepo.findByCustomerAccountAndProduct(customerAccount, product);
		Integer addedQuantity = quantity;
		if(cartItem!=null) {
			addedQuantity += cartItem.getQuantity();
			cartItem.setQuantity(addedQuantity);
			System.out.println("Items added");
		}
		else {
			cartItem = new CartItem(customerAccount, product, quantity);
			System.out.println("New Items added");
		}
		cartRepo.save(cartItem);
		return quantity;
	}
	
	public void updateQuantity(CustomerAccount customerAccount, Product product, Integer quantity) {
		cartRepo.updateQuantity(quantity, product, customerAccount);
		 
	}
	
	public void deleteCartItem(CustomerAccount customerAccount, Product product) {
		cartRepo.deleteByCustomerAccountAndProduct(customerAccount, product);
	}
}
