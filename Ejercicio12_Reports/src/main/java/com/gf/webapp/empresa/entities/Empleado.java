package com.gf.webapp.empresa.entities;

public class Empleado {

	private int empNo;
	private String nombre;
	private String apellidos;
	private String oficio;
	private double salario;
	private String deptNo;
	
	
	public Empleado(int empNo, String nombre, String apellidos, String oficio, double salario, String deptNo) {
		super();
		this.empNo = empNo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.oficio = oficio;
		this.salario = salario;
		this.deptNo = deptNo;
	}


	public int getEmpNo() {
		return empNo;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getOficio() {
		return oficio;
	}


	public void setOficio(String oficio) {
		this.oficio = oficio;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public String getDeptNo() {
		return deptNo;
	}


	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	
	
}
