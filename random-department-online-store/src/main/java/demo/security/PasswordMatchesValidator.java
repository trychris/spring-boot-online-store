package demo.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
//https://stackoverflow.com/questions/46878259/displaying-passwords-dont-match-custom-annotation-message

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
	
	private String message;
	
	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}


	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		RegistrationForm form = (RegistrationForm) obj;
		boolean isValid = form.getPassword().equals(form.getConfirmPassword());
		if (!isValid) {
            context.disableDefaultConstraintViolation();
            context
                    .buildConstraintViolationWithTemplate( message )
                    .addPropertyNode( "noMatch" ).addConstraintViolation();
        }

        return isValid;
	}
}
