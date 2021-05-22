package com.emanuel.controladores;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



/**
 * Servlet implementation class Controllerfiles
 */

@MultipartConfig
public class Controllerfiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controllerfiles() {
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
	
				Part archivo = request.getPart("c");
		
				String nombredelaimagen = archivo.getSubmittedFileName();
		
				String ruta = "C:\\Users\\andre\\Documents\\GitHub\\Andres_Eduardo_Cordova_Orellana\\CEjercicio2\\src\\main\\webapp\\Archivos\\" + nombredelaimagen;
				
				try {
					
					FileOutputStream fileoutput = new FileOutputStream(ruta);
					//Obteniendo y recreando los bytes
					InputStream stream = archivo.getInputStream();
					
					byte[] datos = new byte[stream.available()];
					stream.read(datos);
					fileoutput.write(datos);
					fileoutput.close();
				} catch (Exception e) {
					System.out.println("Ocurrio un error en ControllerFiles " + e);
				}
				
				CLsArchivos clsArchivo = new CLsArchivos();
				clsArchivo.GuardarArchivos(nombredelaimagen);
				
				String nombre = clsArchivo.MostrarArchivo(nombredelaimagen);
				HttpSession session = request.getSession(true);
				session.setAttribute("nombre", nombre);
				System.out.println(nombre);	
	

}
