package com.vipper.modelo;

public class ServiciosProductos {
	private int id_servicio;
	private String descripcion;
	private double coste;
	private int id;
	private double iva;
	
	
	@Override
	public String toString() {
		return "ServiciosProductos [id_servicio=" + id_servicio + ", descripcion=" + descripcion + ", coste=" + coste
				+ ", id=" + id + ", iva=" + iva + "]";
	}
	
	public ServiciosProductos() {
		// TODO Auto-generated constructor stub
	}

	public ServiciosProductos(int id_servicio, String descripcion, double coste, int id, double iva) {
		super();
		this.id_servicio = id_servicio;
		this.descripcion = descripcion;
		this.coste = coste;
		this.id = id;
		this.iva = iva;
	}

	public int getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}
	
	
	
	
}
