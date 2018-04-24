package com.tec.grac.modelo;

/**
 * Creado por David Valverde Garro - 2016034774
 * Fecha: 23-Apr-18 Tiempo: 12:57 PM
 */
public class Vehiculo {
    private String placa;
    private String modelo;
    private int anno;
    private String color;
    private int asientos;
    private boolean alquilado;

    public Vehiculo(String placa, String modelo, int anno, String color, int asientos) {
        this.placa = placa;
        this.modelo = modelo;
        this.anno = anno;
        this.color = color;
        this.asientos = asientos;
        this.alquilado = false;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    //TODO Insertar toString()
}
