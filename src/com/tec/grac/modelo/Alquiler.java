package com.tec.grac.modelo;

import java.util.Date;

/**
 * Creado por David Valverde Garro - 2016034774
 * Fecha: 23-Apr-18 Tiempo: 1:08 PM
 */
public class Alquiler {
    private Date fechaInicio;
    private Date fechaFin;
    private Usuario cajero;
    private Cliente cliente;
    private Vehiculo vehiculo;

    public Alquiler(Date fechaInicio, Date fechaFin, Usuario cajero, Cliente cliente, Vehiculo vehiculo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cajero = cajero;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Usuario getCajero() {
        return cajero;
    }

    public void setCajero(Usuario cajero) {
        this.cajero = cajero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", cajero=" + cajero +
                ", cliente=" + cliente.toString() +
                ", vehiculo=" + vehiculo.toString() +
                '}';
    }
}
