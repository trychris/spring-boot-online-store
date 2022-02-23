package demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory{
	
	public static enum Category{TOYS_AND_HOBBIES, CARS, PROPERTIES, FASHION, COMPUTERS,
		FURNITURES, MOTORCYCLES, MOBILE_PHONES_AND_GADGETS, LUXURY, MUSIC, BABIES, FOOD_AND_DRINKS,
		EDUCATION, PET_SUPPLIES}
	@Id
	@GeneratedValue
	private Integer id;
	@Column(unique=true)
	@Enumerated(EnumType.STRING)
	private Category categoryName;
	private String imageURL;
	private String description;
	public ProductCategory(Category categoryName, String imageURL, String description) {
		this.categoryName = categoryName;
		this.imageURL = imageURL;
		this.description = description;
	}
	
	
}