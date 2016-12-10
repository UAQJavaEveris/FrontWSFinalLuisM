package mx.com.everis.javaweb.servlet;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.everis.javaweb.ws.services.Crud;
import mx.com.everis.javaweb.ws.services.CrudProxy;

@WebServlet("/loadCombos")
public class Servlet3 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8125753848943781795L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			doPost(req,resp);
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lista = "";		
		StringBuilder combos = new StringBuilder();
		
		Crud crud = new CrudProxy("http://localhost:8082/CrudR/services/Crud");
		
		try {
			lista = crud.listaP();		
			
			System.out.println("Listo!");
			System.out.println(lista);
			StringTokenizer tok = new StringTokenizer(lista,"|");
			combos.append("<option value=''> </option>");
			while(tok.hasMoreTokens()){
				StringTokenizer token = new StringTokenizer(tok.nextToken(),"#");
				combos.append("<option value='"+token.nextToken()+"'>"+token.nextToken()+"</option>");
			}
			System.out.println(combos.toString());
			
								
		} catch (RemoteException e) {
			e.printStackTrace();
		}				
		resp.getWriter().println(combos.toString());
	}
	

}
