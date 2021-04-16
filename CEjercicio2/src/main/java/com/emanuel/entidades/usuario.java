package com.emanuel.entidades;

public class usuario extends tipoUsuarios{

    protected int idUsuario;
    protected String Usuario;
    protected String Pass;
    protected int TipoUsuario;
    
	public int getTipoUsuario() {
		return TipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		TipoUsuario = tipoUsuario;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
}
