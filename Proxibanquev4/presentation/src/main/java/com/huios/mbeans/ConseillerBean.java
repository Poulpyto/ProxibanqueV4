package com.huios.mbeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.huios.metier.Conseiller;
import com.huios.service.IServiceConseiller;
import com.huios.service.ServiceImpl;


//@Named
@ManagedBean(eager=true)
@SessionScoped
public class ConseillerBean {

	
	private IServiceConseiller service = new ServiceImpl();
	private Conseiller conseiller = new Conseiller();

	
	
	
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
