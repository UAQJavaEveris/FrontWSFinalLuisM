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


@WebServlet("/ServletInsert")
public class Servlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7261916440745743585L;
	
	

	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Personaje personaje = new Personaje();
		boolean status=false;
		String stts="Error!";
		personaje.setNombre(req.getParameter("nombreI"));
		personaje.setEmpresa(req.getParameter("empresaI"));
		
		Crud crud = new CrudProxy("http://localhost:8082/CrudR/services/Crud");
		
		
		try {
			status = crud.insertPerson(personaje);			
			System.out.println("Listo!");
			stts="Listo";
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		req.setAttribute("status", stts);
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		view.forward(req, resp);			
		
	}

	
	
}
