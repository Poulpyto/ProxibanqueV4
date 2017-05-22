package com.huios.mbeans;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.huios.metier.Client;
import com.huios.service.IServiceConseiller;
import com.huios.service.ServiceImpl;




@ManagedBean
@SessionScoped
public class ClientBean {
	
	private IServiceConseiller service = new ServiceImpl(); 
	
	private Collection<Client> clients = new ArrayList<Client>();
	
	private Client client = new Client();
	
	@ManagedProperty(value="#{conseillerBean}")
	private ConseillerBean conseillerBean;
	
	

	public IServiceConseiller getService() {
		return service;
	}

	public void setService(IServiceConseiller service) {
		this.service = service;
	}

	public Collection<Client> getClients() {
		clients = service.listerClientsParConseiller(conseillerBean.getConseiller());
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ConseillerBean getConseillerBean() {
		return conseillerBean;
	}

	public void setConseillerBean(ConseillerBean conseillerBean) {
		this.conseillerBean = conseillerBean;
	}
	
	public String afficherDetails(){
		return "detailsClient";
	}
	
	public String modifierClient(){
		service.modifierClient(client);
		return "detailsClient";
	}
	
	

}
