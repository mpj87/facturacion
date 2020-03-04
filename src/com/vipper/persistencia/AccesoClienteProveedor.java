package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vipper.modelo.ClienteProveedor;

public class AccesoClienteProveedor extends Conexion{

	public ClienteProveedor mostrarUno(int id) throws ClassNotFoundException, SQLException {

		String sql = "call facturacion.mostrarUnoClienteProveedor(?);";

		ClienteProveedor uno = null;
		CallableStatement st;
		ResultSet rs;

		// abrir Conexion
		abrirConexion();

		// recoger el comando
		st = miConexion.prepareCall(sql);
		// Asignar valor al parametro
		st.setInt(1, id);
		// Ejecutamos comando
		rs = st.executeQuery();
		// recorremos el resulset
		if (rs.next()) {
			uno = new ClienteProveedor(rs.getInt("id"), rs.getString("nif"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("tipo"), rs.getString("email"), rs.getInt("telefono"));
		}
		cerrarConexion();
		return uno;

	}
	
	public boolean DarAltaClienteProveedor(ClienteProveedor clienteProveedor) throws ClassNotFoundException, SQLException {
	
		String sql = "call facturacion.altaClienteProveedor(?,?,?,?,?,?,?);";
		CallableStatement st;
		int numRegistros;
		
		// abrir Conexion
		abrirConexion();

		// recoger el comando
		st = miConexion.prepareCall(sql);
		// Asignar valor al parametro
		st.setInt(1,clienteProveedor.getId());
        st.setString(2,clienteProveedor.getNif());
        st.setString(3,clienteProveedor.getNombre());
        st.setString(4,clienteProveedor.getDireccion());
        st.setString(5,clienteProveedor.getTipo());
        st.setString(6,clienteProveedor.getEmail());
        st.setInt(7,clienteProveedor.getTelefono());
        
      //Ejecutar el comando
        numRegistros = st.executeUpdate();
        cerrarConexion();
        return numRegistros > 0;
	}
	
	public boolean DarBajaClienteProveedor(int id) throws ClassNotFoundException, SQLException {
		
		String sql = "call facturacion.bajaClienteProveedor(?);";
		CallableStatement st;
		int numRegistros;
		
		// abrir Conexion
		abrirConexion();

		// recoger el comando
		st = miConexion.prepareCall(sql);
		// Asignar valor al parametro
		st.setInt(1, id);
        
        
		//Ejecutar el comando
        numRegistros = st.executeUpdate();
        cerrarConexion();
        return numRegistros > 0;
	}
}
