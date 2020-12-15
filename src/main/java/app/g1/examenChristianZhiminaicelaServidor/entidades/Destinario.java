package app.g1.examenChristianZhiminaicelaServidor.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Destinario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "id")
	private int id;
	
	@Column(length  = 20)
	private String nombreDestinario;
	
	@Column(length  = 10)
	private String telefono;
	
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombreDestinario() {
		return nombreDestinario;
	}


	public void setNombreDestinario(String nombreDestinario) {
		this.nombreDestinario = nombreDestinario;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
