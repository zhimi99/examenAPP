package app.g1.examenChristianZhiminaicelaServidor.vista;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import app.g1.examenChristianZhiminaicelaServidor.entidades.Destinario;
import app.g1.examenChristianZhiminaicelaServidor.entidades.Notificacion;
import app.g1.examenChristianZhiminaicelaServidor.negocio.gestionNotificacionON;

@Named
@RequestScoped
public class destinarioBean {
	
	private Destinario newDestinario;
	
	@Inject
	private gestionNotificacionON on;
	
	
	public destinarioBean() {
		init();
	}
	
	
	public void init() {
		newDestinario  = new Destinario();
	}


	public Destinario getnewDestinario() {
		return newDestinario;
	}


	public void setNewDestinario(Destinario newDestinario) {
		this.newDestinario = newDestinario;
	}


	public gestionNotificacionON getOn() {
		return on;
	}


	public void setOn(gestionNotificacionON on) {
		this.on = on;
	}
	
	
	public String doGuardar() {
		
		System.out.println(newDestinario);
		try {
			on.guardarDestinatario(newDestinario);
			System.out.println("guardado ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error al guardar Destinario" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	

}
