package app.g1.examenChristianZhiminaicelaServidor.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import app.g1.examenChristianZhiminaicelaServidor.DAOS.destinarioDAO;
import app.g1.examenChristianZhiminaicelaServidor.DAOS.notificacionDAO;
import app.g1.examenChristianZhiminaicelaServidor.entidades.Destinario;
import app.g1.examenChristianZhiminaicelaServidor.entidades.Notificacion;


@Stateless
public class gestionNotificacionON implements gestionNotificacionRemoto{
	
	@Inject
	private destinarioDAO daoDestinario;
	
	@Inject
	private notificacionDAO daoNotificacion;
	
	
	public boolean guardarDestinatario(Destinario destinario) throws Exception {
		
		try {
			daoDestinario.insert(destinario);
		} catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al guardar el destinatario ");
		}
		return true;
	}
	
		
	
	public boolean guardarNotificacion(Notificacion notificacion) throws Exception {
		
		try  {
			Destinario dest = notificacion.getDestinario();
			
			if(daoDestinario.read(dest.getId()) != null) {//pregunta si existe un destinatario
				daoDestinario.update(dest);
			}else {
				daoDestinario.insert(dest);
			}
			
			daoNotificacion.insert(notificacion);
			
		} catch(Exception e){
			e.printStackTrace();
		}
			return true;
			
	}
	
	
	
	public List<Notificacion> getNotificaciones(){
		
		try {
		
			List<Notificacion> notificaciones = daoNotificacion.getList();
		
		}catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
		
		return daoNotificacion.getList();
		
	}

	
	
}
