package com.huios.mbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import com.huios.metier.Conseiller;
import com.huios.service.IServiceConseiller;


@Controller
@SessionScope
public class ConseillerBean {

	@Autowired
	private IServiceConseiller service;
	@Autowired
	private Conseiller conseiller;

	
	
	
	public IServiceConseiller getService() {
		return service;
	}

	public void setService(IServiceConseiller service) {
		this.service = service;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public String connexion() {
		conseiller = service.verificationLogin(conseiller.getLogin(), conseiller.getPwd());
		if (conseiller == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Connexion échouée, mot de passe/login invalides", null));
			conseiller = new Conseiller();
			return "index";
		} else {
			return "listeClients";
		}
	}
	
	public String deconnexion(){
		conseiller = new Conseiller();
		return "index";
		
	}
	
}
