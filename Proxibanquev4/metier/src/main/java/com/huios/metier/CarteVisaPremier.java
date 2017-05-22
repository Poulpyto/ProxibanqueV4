package com.huios.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VISAPREMIER")
public class CarteVisaPremier extends CarteBancaire {

	@Override
	public String toString() {
		return "VisaPremier []";
	}

}
