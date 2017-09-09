package or.practice.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<IsValidCountry, String> {

	@Override
	public void initialize(IsValidCountry arg0) {}

	@Override
	public boolean isValid(String countryName, ConstraintValidatorContext ctx) {
		System.out.println("Country name : " + countryName);
		if (countryName == null) {
			return false;
		}
		if (countryName.matches("India|SriLanka|Bhutan|Nepal")) {
			return true;
		}
		return false;
	}

}
