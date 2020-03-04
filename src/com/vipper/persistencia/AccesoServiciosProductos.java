package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vipper.modelo.ServiciosProductos;

public class AccesoServiciosProductos extends Conexion {

	public ServiciosProductos mostrarUnServicio(int id) throws ClassNotFoundException, SQLException {

		String sql = "call facturacion.mostrarUnoServiciosProductos(?);";
		ServiciosProductos uno = null;
		CallableStatement st;
		ResultSet rs;

		abrirConexion();
		st = miConexion.prepareCall(sql);
		st.setInt(1, id);
		rs = st.executeQuery();
		if (rs.next()) {
			uno = new ServiciosProductos(rs.getInt("id_servicio"), rs.getString("descripcion"), rs.getDouble("coste"),
					rs.getInt("id"), rs.getDouble("iva"));
		}
		cerrarConexion();
		return uno;
	}

	public boolean DarAltaServicio(String descripcion, double coste, int id, double iva)
			throws ClassNotFoundException, SQLException {
		String sql = "call facturacion.altaServiciosProductos(?,?,?,?);";

		CallableStatement st;
		int numRegistros;

		// abrir Conexion
		abrirConexion();

		// recoger el comando
		st = miConexion.prepareCall(sql);
		// Asignar valor al parametro

		st.setString(1, descripcion);
		st.setDouble(2, coste);
		st.setInt(3, id);
		st.setDouble(4, iva);

		// El execute devuelve un 0 o un 1 si devuelve el 1 es que se ha logrado
		// realizar el alta.

		numRegistros = st.executeUpdate();

		// pongo directamente la condición

		return numRegistros > 0;
	}
	public boolean DarBajaServicio (int id) throws ClassNotFoundException, SQLException {
        String sql = "call facturacion.bajaServiciosProductos(?);";
        CallableStatement st;
    	int numRegistros;
        abrirConexion();
        st = miConexion.prepareCall(sql);

        st.setInt(1, id);

        numRegistros = st.executeUpdate();
        return numRegistros > 0;
	}
}
