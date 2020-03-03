package com.vipper.persistencia;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.vipper.modelo.Pedido;

public class AccesoPedido extends Conexion {

	public Pedido mostrarUno(int id) throws ClassNotFoundException, SQLException {

		String sql = "call facturacion.mostrarUnoPedido(?);";

		Pedido uno = null;
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
			uno = new Pedido(rs.getInt("id_pedido"), rs.getString("descripcion"), rs.getInt("id"),
					rs.getInt("id_forma_pago"), rs.getDouble("total"), rs.getDate("fecha"), rs.getInt("id_servicio"),
					rs.getInt("id_contrato"), rs.getDouble("importe_facturado"));

		}
		cerrarConexion();
		return uno;

	}

	public boolean DarAlta(int id_pedido, String descripcion, int id, int id_forma_pago, double total, Date fecha,
			int id_servicio, int id_contrato, double importe_facturado) throws ClassNotFoundException, SQLException {

		String sql = "call facturacion.altaPedido(?,?,?,?,?,?,?,?,?);";

		CallableStatement st;
		int numRegistros;

		// abrir Conexion
		abrirConexion();

		// recoger el comando
		st = miConexion.prepareCall(sql);
		// Asignar valor al parametro
		st.setInt(1, id_pedido);
		st.setString(2, descripcion);
		st.setInt(3, id);
		st.setInt(4, id_forma_pago);
		st.setDouble(5, total);
		st.setDate(6, fecha);
		st.setInt(7, id_servicio);
		st.setInt(8, id_contrato);
		st.setDouble(9, importe_facturado);

		// El execute devuelve un 0 o un 1 si devuelve el 1 es que se ha logrado
		// realizar el alta.

		numRegistros = st.executeUpdate();

		// pongo directamente la condición

		return numRegistros > 0;
	}
	public boolean eliminarPedido (int id) throws ClassNotFoundException, SQLException {
        String sql = "call facturacion.borrarPedido(?);";
        CallableStatement st;
    	int numRegistros;
        abrirConexion();
        st = miConexion.prepareCall(sql);

        st.setInt(1, id);

        numRegistros = st.executeUpdate();
        return numRegistros > 0;
    }
}
