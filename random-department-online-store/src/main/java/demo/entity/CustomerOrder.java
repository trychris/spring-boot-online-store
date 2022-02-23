package demo.entity;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CustomerOrder{
	
	@Id
	@GeneratedValue
	private Long id;
	private Double totalCost;
	@ManyToOne
	private CustomerAccount customerAccount;
	private String customerName;
	@CreationTimestamp
	private LocalDateTime orderDateTime;
	private String deliveryAddress;
	private OrderStatus orderStatus;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="order")
	private List<OrderItem> orderItems;
	public static enum OrderStatus{CREATED, ACKNOWLEDGED, FULFULLING, SHIPPING, DELIVERED}
	public CustomerOrder(Double totalCost, CustomerAccount customerAccount, String customerName, String deliveryAddress) {
		this.totalCost = totalCost;
		this.customerAccount = customerAccount;
		this.customerName = customerName;
		this.deliveryAddress = deliveryAddress;
		this.orderStatus = OrderStatus.CREATED;
	}
	
}
