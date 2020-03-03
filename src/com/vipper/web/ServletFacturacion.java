package com.vipper.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vipper.modelo.Pedido;

import com.vipper.persistencia.AccesoPedido;

/**
 * Servlet implementation class ServletFacturacion
 */
@WebServlet("/servletfacturacion")
public class ServletFacturacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletFacturacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest r, HttpServletResponse response) throws ServletException, IOException {
		int jopcion = Integer.parseInt(r.getParameter("op"));
		AccesoPedido ap1 = null;
		RequestDispatcher rd = null;
		Pedido jPedido = null;
		switch (jopcion) {
		case 1:
			jPedido = (Pedido) r.getAttribute("p1");
			ap1 = new AccesoPedido();
			try {
				jPedido = ap1.mostrarUno(jPedido.getId());
				System.out.println("Producto de la BBDD" + jPedido.toString());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			// Se guarda el producto con los datos que se obtienen
			// de la BBDD en el ámbito request
			r.setAttribute("p1", jPedido);
			rd = r.getRequestDispatcher("/mostrarpedido.jsp");
			rd.forward(r, response);

			break;

		case 2:

			int jidpedido = Integer.parseInt(r.getParameter("id_pedido"));
			String jdescripcion = r.getParameter("descripcion");
			int jid = Integer.parseInt(r.getParameter("id"));
			int jformapago = Integer.parseInt(r.getParameter("id_forma_pago"));
			double jtotal = Double.parseDouble(r.getParameter("total"));
			Date jfecha = Date.valueOf(r.getParameter("fecha"));
			int jidservicios = Integer.parseInt(r.getParameter("id_servicio"));
			int jidcontrato = Integer.parseInt(r.getParameter("id_contrato"));
			double jimportefacturado = Double.parseDouble(r.getParameter("importe_facturado"));
			ap1 = new AccesoPedido();
			try {
				ap1.DarAlta(jidpedido, jdescripcion, jid, jformapago, jtotal, jfecha, jidservicios, jidcontrato,
						jimportefacturado);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}

			break;
		case 3:
		
			int jidpedido2 = Integer.parseInt(r.getParameter("id_pedido"));
			ap1 = new AccesoPedido();
			try {
				ap1.eliminarPedido(jidpedido2);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
	
			break;
		
					
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
