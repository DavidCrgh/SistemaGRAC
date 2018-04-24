package com.tec.grac.modelo;

/**
 * Creado por David Valverde Garro - 2016034774
 * Fecha: 23-Apr-18 Tiempo: 12:55 PM
 */
public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellidos;
    private String direccion;

    public Cliente(int idCliente, String nombre, String apellidos, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " ; ID: " + idCliente;
    }

    public String getNombreCompleto(){
        return nombre + "\n" + apellidos;
    }
}
