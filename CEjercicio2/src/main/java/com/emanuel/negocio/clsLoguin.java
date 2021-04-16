package com.emanuel.negocio;

import com.emanuel.DAO.ClsLoguinDao;
import com.emanuel.entidades.usuario;

public class clsLoguin {

	public int acceso(usuario log) {
		int acceso = 0;
		//if (log.getUsuario().equals("emanuel") && log.getPass().equals("123")) {
			//acceso = 1;
		//} else {

		//}
		
		ClsLoguinDao logindao = new ClsLoguinDao();
		usuario usu = new usuario();
		
		usu=logindao.Loguin(log);
		if (usu != null) {
			if (usu.getTipoUsuario()==1) {
				acceso=1;
			}else if(usu.getTipoUsuario()==2){
				acceso=2;
			}
			System.out.println("Usuario Encontrado"+usu.getIdTipoUsuario());
			
		}else {
			System.out.println("Usuario Vacio");
		}
			
		return acceso;
	}
}