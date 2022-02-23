package demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data 
public class OrderItem{
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private CustomerOrder order;
	@ManyToOne
	private Product product; 
	private Integer quantity;
	private Double totalCostPerOrderItem; //= product price x quantity, unless discounts are applied
	public OrderItem(CustomerOrder order, Product product, Integer quantity, Double totalCostPerOrderItem) {
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.totalCostPerOrderItem = totalCostPerOrderItem;
	}
	
	
}
