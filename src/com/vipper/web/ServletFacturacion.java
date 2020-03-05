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
import javax.servlet.http.HttpSession;

import com.vipper.modelo.ClienteProveedor;
import com.vipper.modelo.Contrato;
import com.vipper.modelo.Pedido;
import com.vipper.modelo.ServiciosProductos;
import com.vipper.persistencia.AccesoClienteProveedor;
import com.vipper.persistencia.AccesoContrato;
import com.vipper.persistencia.AccesoPedido;
import com.vipper.persistencia.AccesoServiciosProductos;

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
		AccesoClienteProveedor acp1=null;
		AccesoServiciosProductos asp1=null;
		AccesoContrato ac1=null;
		RequestDispatcher rd = null;
		Pedido jPedido = null;
		ServiciosProductos jServicios=null;
		ClienteProveedor jClienteProveedor=null;
		Contrato jContrato=null;
		HttpSession miSesion;
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
		case 4:
			jServicios = (ServiciosProductos) r.getAttribute("p2");
			asp1= new AccesoServiciosProductos();
			try {
				jServicios = asp1.mostrarUnServicio(jServicios.getId());
				System.out.println("Servicio de la BBDD" + jServicios.toString());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			// Se guarda el producto con los datos que se obtienen
			// de la BBDD en el ámbito request
			r.setAttribute("p2", jServicios);
			rd = r.getRequestDispatcher("/mostrarservicios.jsp");
			rd.forward(r, response);

			break;
		case 5:
			jServicios = (ServiciosProductos) r.getAttribute("p3");
			asp1= new AccesoServiciosProductos();
			boolean cond=false;
			try {
				cond=asp1.DarAltaServicio(jServicios.getDescripcion(), jServicios.getCoste(), jServicios.getId(), jServicios.getIva());
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			miSesion = r.getSession();
			miSesion.setAttribute("altaC", cond);
			
			rd = r.getRequestDispatcher("/mostrarmensaje.jsp");
			rd.forward(r, response);
			
			break;
		case 6:
			jServicios = (ServiciosProductos) r.getAttribute("p4");
			asp1= new AccesoServiciosProductos();
			boolean cond2=false;
			try {
				cond2=asp1.DarBajaServicio(jServicios.getId_servicio());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			miSesion = r.getSession();
			miSesion.setAttribute("altaC", cond2);
			
			rd = r.getRequestDispatcher("/mostrarmensaje.jsp");
			rd.forward(r, response);
			break;
			
		case 7:
			jClienteProveedor = (ClienteProveedor) r.getAttribute("p6");
			acp1 = new AccesoClienteProveedor();
			try {
				jClienteProveedor = acp1.mostrarUno(jClienteProveedor.getId());
				System.out.println("Cliente o Proveedor de la BBDD" + jClienteProveedor.toString());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			// Se guarda el producto con los datos que se obtienen
			// de la BBDD en el �mbito request
			r.setAttribute("p6", jClienteProveedor);
			rd = r.getRequestDispatcher("/mostrarclienteproveedor.jsp");
			rd.forward(r, response);
			break;
			
		case 8:
			jClienteProveedor = (ClienteProveedor) r.getAttribute("p7");
			acp1= new AccesoClienteProveedor();
			boolean cond3=false;
			try {
				cond3=acp1.DarAltaClienteProveedor(jClienteProveedor);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			miSesion = r.getSession();
			miSesion.setAttribute("altaC", cond3);
			
			rd = r.getRequestDispatcher("/mostrarmensaje.jsp");
			rd.forward(r, response);
			break;
			
		case 9:
			jClienteProveedor = (ClienteProveedor) r.getAttribute("p8");
			acp1= new AccesoClienteProveedor();
			boolean cond4=false;
			try {
				cond4=acp1.DarBajaClienteProveedor(jClienteProveedor.getId());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			miSesion = r.getSession();
			miSesion.setAttribute("altaC", cond4);
			
			rd = r.getRequestDispatcher("/mostrarmensaje.jsp");
			rd.forward(r, response);
			break;
			
		case 10:
			jContrato = (Contrato) r.getAttribute("p9");
			ac1 = new AccesoContrato();
			try {
				jContrato = ac1.mostrarUno(jContrato.getId());
				System.out.println("Contrato de la BBDD" + jContrato.toString());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			// Se guarda el producto con los datos que se obtienen
			// de la BBDD en el �mbito request
			r.setAttribute("p9", jContrato);
			rd = r.getRequestDispatcher("/mostrarcontrato.jsp");
			rd.forward(r, response);
			break;
			
		case 11:
			jContrato = (Contrato) r.getAttribute("p10");
			ac1= new AccesoContrato();
			boolean cond5=false;
			try {
				cond5=ac1.DarAltaContrato(jContrato);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			miSesion = r.getSession();
			miSesion.setAttribute("altaC", cond5);
			
			rd = r.getRequestDispatcher("/mostrarmensaje.jsp");
			rd.forward(r, response);
			break;
			
		case 12:
			jContrato = (Contrato) r.getAttribute("p11");
			ac1= new AccesoContrato();
			boolean cond6=false;
			try {
				cond6=ac1.DarBajaContrato(jContrato.getId());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.toString());
			}
			miSesion = r.getSession();
			miSesion.setAttribute("altaC", cond6);
			
			rd = r.getRequestDispatcher("/mostrarmensaje.jsp");
			rd.forward(r, response);
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
