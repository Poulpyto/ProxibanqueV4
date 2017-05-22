package com.huios.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huios.dao.IDao;
import com.huios.metier.Client;
import com.huios.metier.Compte;
import com.huios.metier.CompteCourant;
import com.huios.metier.CompteEpargne;
import com.huios.metier.Conseiller;

@Service
public class ServiceImpl implements IServiceConseiller {

	@Autowired
	private IDao dao;

	@Override
	public Conseiller verificationLogin(String login, String pwd) {
		return dao.verificationLogin(login, pwd);
	}

	@Override
	public Collection<Client> listerClientsParConseiller(Conseiller conseiller) {

		return dao.listerClientsParConseiller(conseiller);
	}

	@Override
	public void modifierClient(Client client) {
		dao.modifierClient(client);
	}

	@Override
	public Collection<Compte> listerComptesClient(Client client) {

		return dao.listerComptesClient(client);
	}

	@Override
	public Client retourneClientParId(long idClient) {

		return dao.retourneClientParId(idClient);
	}

	@Override
	public Compte getCompteParId(long idCompte) {

		return dao.getCompteParId(idCompte);
	}

	@Override
	public Collection<Compte> listerAutresComptes(long idCompte) {

		return dao.listerAutresComptes(idCompte);
	}

	@Override
	public boolean virementComptes(Compte compteDebiteur, Compte compteCrediteur, double montant) {
		if (montant >= 0) {
			if (compteDebiteur instanceof CompteEpargne) {
				if (montant > compteDebiteur.getSolde()) {
					return false;
				}
			}
			if (compteDebiteur instanceof CompteCourant) {
				double decouvert = ((CompteCourant) compteDebiteur).getDecouvert();
				if (montant > compteDebiteur.getSolde() + decouvert) {
					return false;
				}
			}
			dao.virementComptes(compteDebiteur, compteCrediteur, montant);
			return true;
		}
		return false;
	}

	@Override
	public Conseiller afficherConseiller(long idConseiller) {

		return dao.afficherConseiller(idConseiller);
	}

}
