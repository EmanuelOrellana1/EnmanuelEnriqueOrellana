package com.emanuel.DAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.emanuel.Conexion.ConexionBd;
import com.emanuel.entidades.usuario;

public class ClsUsuario {

    ConexionBd conexion = new ConexionBd();
    Connection con = conexion.RetornarConexion();
    
	public ArrayList<usuario> ListadoUSUARIOS() {
        ArrayList<usuario> Lista = new ArrayList<>();

        try {

            CallableStatement consulta = con.prepareCall("call SP_S_SOLOUSUARIOS()");
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                usuario user = new usuario();
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setUsuario(rs.getString("Usuario"));
                user.setPass(rs.getString("PassWord"));
                user.setIdTipoUsuario(rs.getInt("tipoUsuario"));
                Lista.add(user);
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Ha ocurrido un error en: \n\n\n\n" + e);
        }

        return Lista;
    }
	public void Eliminar (usuario user) {
		
		try {
			CallableStatement consulta = con.prepareCall("call SP_D_USER(?)");
			consulta.setInt("pIdUsuario", user.getIdUsuario());
			consulta.executeQuery();
			System.out.println("Exito");
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
