package com.huios.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COURANT")
public class CompteCourant extends Compte {

	private double decouvert = 1000;;

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public CompteCourant(int numeroCompte, double solde, String dateOuverture, Client client, CarteBancaire carteBancaire,
			double decouvert) {
		super(numeroCompte, solde, dateOuverture, client, carteBancaire);
		this.decouvert = decouvert;
	}

	public CompteCourant(double solde, String dateOuverture) {
		super(solde, dateOuverture);
	}

	public CompteCourant() {
		super();
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + ", toString()=" + super.toString() + "]";
	}

}
