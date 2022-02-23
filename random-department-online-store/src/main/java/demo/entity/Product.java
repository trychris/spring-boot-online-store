package demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import demo.entity.ProductCategory.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue
	private Long id;
	private String productId;//different from Primary key ... Follows international standard for product ID
	private String name;
	private String brand;
	@Column(length = 400) //Increase length since description might be too long,
	private String description;
	private Double unitPrice;
	@Enumerated(EnumType.STRING)
	private Category category;
	private Boolean isRecommended;
	private String imageFileName;

}
