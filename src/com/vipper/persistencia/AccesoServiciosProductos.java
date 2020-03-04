package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vipper.modelo.ServiciosProductos;

public class AccesoServiciosProductos extends Conexion {

	public ServiciosProductos mostrarUno(int id) throws ClassNotFoundException, SQLException {

		String sql = "call facturacion.mostrarUnoServiciosProductos(?);";

		ServiciosProductos uno = null;
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
			uno = new ServiciosProductos(rs.getInt("id_servicio"), rs.getString("descripcion"), rs.getDouble("coste"), rs.getInt("id"), rs.getDouble("iva"));
		}
		cerrarConexion();
		return uno;

	}
	
	public boolean altaServiciosProductos(ServiciosProductos serviciosProductos) throws ClassNotFoundException, SQLException {
		
		String sql = "call facturacion.altaServiciosProductos(?,?,?,?,?);";
		CallableStatement st;
		int numRegistros;
		
		// abrir Conexion
		abrirConexion();

		// recoger el comando
		st = miConexion.prepareCall(sql);
		// Asignar valor al parametro
		st.setInt(1,serviciosProductos.getId_servicio());
        st.setString(2,serviciosProductos.getDescripcion());
        st.setDouble(3,serviciosProductos.getCoste());
        st.setInt(4,serviciosProductos.getId());
        st.setDouble(5,serviciosProductos.getIva());
        
      //Ejecutar el comando
        numRegistros = st.executeUpdate();
        cerrarConexion();
        return numRegistros > 0;
        
	}
		
	public boolean bajaServiciosProductos(int id) throws ClassNotFoundException, SQLException {
		
		String sql = "call facturacion.bajaServiciosProductos(?);";
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
