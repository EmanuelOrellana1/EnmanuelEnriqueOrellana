package com.emanuel.DAO;

import java.sql.Connection;
import java.sql.ResultSet;

import com.emanuel.Conexion.ConexionBd;
import com.emanuel.entidades.usuario;
import java.sql.*;
;

public class ClsLoguinDao {
	ConexionBd conexion = new ConexionBd();
	Connection con = conexion.RetornarConexion();
	
	public usuario Loguin(usuario user) {
		usuario usu = new usuario();
		try {
			CallableStatement statement = con.prepareCall("call SP_S_LOGIN(?,?);");
			statement.setString("PUsuario", user.getUsuario());
			statement.setString("PPass",user.getPass());
			ResultSet res = statement.executeQuery();
			System.out.println("Paso 1>" + user.getUsuario());
			while (res.next()) {
				System.out.println("Paso 2");
				usu.setIdUsuario(res.getInt("idUsuario"));
				usu.setUsuario(res.getString("Usuario"));
				usu.setPass(res.getString("PassWord"));
				usu.setTipoUsuario(res.getInt("tipoUsuario"));
			}
			System.out.println("Paso 3");
		} catch (Exception e) {
			System.out.println("Usuario no Encontrado" + e);
		}
		return usu;
		
		
	}
}
