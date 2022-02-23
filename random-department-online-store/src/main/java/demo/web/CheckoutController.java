package demo.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.entity.CartItem;
import demo.entity.CustomerAccount;
import demo.entity.CustomerOrder;
import demo.entity.OrderForm;
import demo.entity.OrderItem;
import demo.repository.CartItemRepository;
import demo.repository.CustomerAccountRepository;
import demo.repository.CustomerOrderRepository;
import demo.repository.OrderItemRepository;
import demo.security.RegistrationForm;
import demo.service.ShoppingCartServices;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
	
	@Autowired
	private CustomerOrderRepository orderRepo;
	@Autowired
	private OrderItemRepository orderItemRepo;
	@Autowired
	private CustomerAccountRepository customerRepo;
	@Autowired
	private CartItemRepository cartItemRepo;
	@Autowired
	private ShoppingCartServices shoppingCartServices;

	@ModelAttribute("currentUser")
	public CustomerAccount getCurrentAccount(Authentication authentication) {
		return (authentication == null) ? null : (CustomerAccount) authentication.getPrincipal();
	}

	@GetMapping
	public String orderForm(Model model, @AuthenticationPrincipal CustomerAccount customer) {
		if(customer==null) {
			return "redirect:/login";
		}
		model.addAttribute("orderForm", new OrderForm());
		List<CartItem> cartItems = shoppingCartServices.listCartItems(customer);
		model.addAttribute("customerItems", cartItems);
		return "checkout";
	}

	@PostMapping
	  public String processOrder(@ModelAttribute("orderForm") @Valid OrderForm form, 
			  BindingResult bindingResult, Authentication authentication) {
		  if(bindingResult.hasErrors()) {
			  System.out.println(bindingResult);
			  return "checkout";
		  }
		  if(authentication == null) {
			  return "login";
		  }
		  CustomerAccount customer = (CustomerAccount) authentication.getPrincipal();
		  //First stage - Calculate total cost of order
		  List<CartItem> cart = cartItemRepo.findByCustomerAccount(customer);
		  Double totalCost = (double) 0;
		  for(CartItem cartItem: cart) {
			  totalCost += cartItem.getProduct().getUnitPrice() * cartItem.getQuantity();  
		  }
		  //Second stage - built an order
		  CustomerOrder latestOrder = new CustomerOrder(totalCost, customer, form.getFullName(), form.getAddress());
		  orderRepo.save(latestOrder);
		  //Third stage - Convert each cartItem to OrderItem and save
		  for(CartItem cartItem: cart) {
			  OrderItem newOrderItem = cartItem.toOrderItem(latestOrder);
			  orderItemRepo.save(newOrderItem);
			  cartItemRepo.deleteById(cartItem.getId());
		  }
		  latestOrder = orderRepo.save(latestOrder);

		  return "redirect:/index";
	  }
}