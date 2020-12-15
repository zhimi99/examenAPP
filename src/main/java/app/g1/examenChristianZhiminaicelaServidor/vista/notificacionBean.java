package app.g1.examenChristianZhiminaicelaServidor.vista;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import app.g1.examenChristianZhiminaicelaServidor.entidades.Notificacion;
import app.g1.examenChristianZhiminaicelaServidor.negocio.gestionNotificacionON;

@Named
@RequestScoped
public class notificacionBean {
	
	private Notificacion newNotificacion;
	
	@Inject
	private gestionNotificacionON on;
	
	
	public notificacionBean() {
		init();
	}
	
	
	public void init() {
		newNotificacion  = new Notificacion();
	}


	public Notificacion getNewNotificacion() {
		return newNotificacion;
	}


	public void setNewNotificacion(Notificacion newNotificacion) {
		this.newNotificacion = newNotificacion;
	}


	public gestionNotificacionON getOn() {
		return on;
	}


	public void setOn(gestionNotificacionON on) {
		this.on = on;
	}
	
	
	public String doGuardar() {
		
		System.out.println(newNotificacion);
		try {
			on.guardarNotificacion(newNotificacion);
			System.out.println("guardado ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error al guardar Notificacion" + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	

}
