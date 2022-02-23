package demo.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderForm {
	@NotNull
	@NotEmpty(message="Please choose a country")
	private String country;
	@NotNull
	@NotEmpty(message="Please enter your name")
	private String fullName;
	@NotNull
	@NotEmpty(message="Please enter your address")
	private String address;
	@NotNull
	@NotEmpty(message="Please enter your postal code")
	private String postalCode;
	@NotNull
	@NotEmpty(message="Please enter your email")
	private String email;
	@NotNull
	@NotEmpty(message="Please enter your phonenumber")
	private String phoneNumber;
	@NotNull
	@NotEmpty(message="Please choose your payment method")
	private String paymentMethod;

}
