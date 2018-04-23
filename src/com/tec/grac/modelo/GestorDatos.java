package com.tec.grac.modelo;

import java.util.ArrayList;

/**
 * Creado por David Valverde Garro - 2016034774
 * Fecha: 23-Apr-18 Tiempo: 1:22 PM
 */
public class GestorDatos {
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Alquiler> alquileres;
    private ArrayList<Informe> informes;

    public GestorDatos() {
        usuarios= new ArrayList<>();
        Administrador user1= new Administrador(1,"Jeison","Esquivel Samudio","1","1");
        Administrador user2= new Administrador(2,"Jeison","Esquivel Samudio","2","2");
        usuarios.add(user1);
        usuarios.add(user2);
    }

    public boolean obtenerUsuario(String username, String password) {
        for (Usuario u:usuarios) {
            if (u.getUsername().equals(username) && u.getContrasenna().equals(password))
                return true;
        }
        return false;
    }
}
