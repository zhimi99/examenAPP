package app.g1.examenChristianZhiminaicelaServidor.negocio;

import java.util.List;

import javax.ejb.Remote;

import app.g1.examenChristianZhiminaicelaServidor.entidades.Notificacion;

@Remote
public interface gestionNotificacionRemoto {
	
	public List<Notificacion> getNotificaciones()throws Exception;
	

}
