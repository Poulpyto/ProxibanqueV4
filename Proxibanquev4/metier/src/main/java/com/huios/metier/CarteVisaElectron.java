package com.huios.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VISAELECTRON")
public class CarteVisaElectron extends CarteBancaire {

	@Override
	public String toString() {
		return "VisaElectron []";
	}

}
