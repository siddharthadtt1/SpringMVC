package or.practice.customvalidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy=CountryValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidCountry {
	
	String message() default "Please enter valid SAARC country - India, SriLanka, Bhutan, Nepal";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default {}; 

}
