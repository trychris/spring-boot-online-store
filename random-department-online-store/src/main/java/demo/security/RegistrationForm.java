package demo.security;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.crypto.password.PasswordEncoder;

import demo.entity.CustomerAccount;
import lombok.Data;

@Data
@PasswordMatches
public class RegistrationForm {
	@NotNull
	@NotEmpty(message="Please choose a username")
	private String username;
	@NotNull
	@NotEmpty(message="Please choose a password")
	private String password;
	@NotNull
	@NotEmpty(message="Please provide a name")
	private String fullName;
	@NotNull
	private String address;
	@NotNull
	private String phoneNumber;
	@NotNull
	@NotEmpty(message="Please provide an email")
	private String email;
	@NotNull
	@NotEmpty(message="Please confirm your password")
	private String confirmPassword;
	private boolean noMatch;

	public CustomerAccount toCustomerAccount(PasswordEncoder passwordEncoder) {
		return new CustomerAccount(username, passwordEncoder.encode(password), fullName, address, phoneNumber, email);
	}

}
