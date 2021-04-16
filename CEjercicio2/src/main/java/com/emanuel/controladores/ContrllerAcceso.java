package com.emanuel.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emanuel.DAO.ClsUsuario;
import com.emanuel.entidades.Loguin;
import com.emanuel.entidades.usuario;
import com.emanuel.negocio.clsLoguin;

/**
 * Servlet implementation class ControllerAcceso
 */
@WebServlet("/ContrllerAcceso")
public class ContrllerAcceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContrllerAcceso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		usuario log = new usuario();
		clsLoguin clsL = new clsLoguin();
		
		log.setUsuario(user);
		log.setPass(pass);
		
		int valoracceso = clsL.acceso(log);
		
		if(valoracceso==1) {
			ClsUsuario clsUsuario = new ClsUsuario();
			var Usuario = clsUsuario.ListadoUSUARIOS();
			response.sendRedirect("SALUDO.jsp");
			for(var iterar : Usuario)
			{
				System.out.println(iterar.getUsuario());
			}
		}else if(valoracceso==2){
			System.out.println("Usuario Normal");
			response.sendRedirect("loguin.jsp");
		}else{
			response.sendRedirect("Error.jsp");
		}
	}

}
