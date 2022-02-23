package demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class CartItem{
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private CustomerAccount customerAccount;
	@ManyToOne
	@JoinColumn
	private Product product;
	private Integer quantity;
	
	public CartItem(CustomerAccount customerAccount, Product product, Integer quantity) {
		this.customerAccount = customerAccount;
		this.product = product;
		this.quantity = quantity;
	}
	
	@Transient
	public Double getSubtotal() {
		return this.product.getUnitPrice() * this.quantity;
	}
	
	public OrderItem toOrderItem(CustomerOrder order) {
		return new OrderItem(order, product, quantity, quantity * product.getUnitPrice());
	}
	
}