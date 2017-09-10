package org.practice.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<IsValidCountry, String> {

	private String listOfCountries;
	
	@Override
	public void initialize(IsValidCountry ant) {
		this.listOfCountries = ant.listOfCountries();
	}

	@Override
	public boolean isValid(String countryName, ConstraintValidatorContext ctx) {
		System.out.println("Country name : " + countryName);
		if (countryName == null) {
			return false;
		}
		if (countryName.matches(listOfCountries)) {
			return true;
		}
		return false;
	}

}
