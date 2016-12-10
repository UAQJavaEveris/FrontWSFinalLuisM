package mx.com.everis.javaweb.servlet;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.everis.javaweb.model.Personaje;
import mx.com.everis.javaweb.ws.services.Crud;
import mx.com.everis.javaweb.ws.services.CrudProxy;

@WebServlet("/ServletUpdate")
public class Servlet5 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4151358697354888626L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Personaje personaje = new Personaje();
		boolean status=false;
		String stts="Error!";
		personaje.setClave(Long.parseLong(req.getParameter("listU")));
		personaje.setNombre(req.getParameter("nombreU"));
		personaje.setEmpresa(req.getParameter("empresaU"));
		
		Crud crud = new CrudProxy("http://localhost:8082/CrudR/services/Crud");
		
		
		try {
			status = crud.updatePerson(personaje);			
			System.out.println("Listo!");
			stts="Listo";
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		req.setAttribute("stts", stts);
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		view.forward(req, resp);
		
	}
	

}
