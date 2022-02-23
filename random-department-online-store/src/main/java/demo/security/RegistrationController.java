package demo.security;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.repository.CustomerAccountRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {
  
  private CustomerAccountRepository userRepo;
  private PasswordEncoder passwordEncoder;

  public RegistrationController(CustomerAccountRepository userRepo, PasswordEncoder passwordEncoder) {
    this.userRepo = userRepo;
    this.passwordEncoder = passwordEncoder;
  }
  
  @GetMapping
  public String registerForm(Model model) {
	model.addAttribute("registrationForm", new RegistrationForm());
    return "registration";
  }
  
  @PostMapping
  //Note that to get errors, you can use either BindingResults interface or Errors interface
  //BindingResults interface extends Errors interface
  //BindingResult: https://spring.io/guides/gs/validating-form-input/
  //BindingResult: https://www.baeldung.com/spring-mvc-custom-validator
  //Errors:Spring in Action
  //Errors: https://www.baeldung.com/registration-with-spring-mvc-and-spring-security
  public String processRegistration(@ModelAttribute("registrationForm") @Valid RegistrationForm form, BindingResult bindingResult) {
	  if(bindingResult.hasErrors()) {
		  System.out.println("Has errors");
		  System.out.println(bindingResult.getAllErrors());
		  return "registration";
	  }
	userRepo.save(form.toCustomerAccount(passwordEncoder));
    return "redirect:/index";
  }

}
