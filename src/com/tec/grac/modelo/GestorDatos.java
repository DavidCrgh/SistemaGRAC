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
        poblarEstructuras();
    }

    private void poblarEstructuras(){

        //<editor-fold desc="Inicializacion de listas">
        vehiculos = new ArrayList<>();
        clientes = new ArrayList<>();
        usuarios = new ArrayList<>();
        alquileres = new ArrayList<>();
        informes = new ArrayList<>();
        //</editor-fold>

        //<editor-fold desc="Creacion de objetos">

        //<editor-fold desc="Administradores">
        Administrador admin1= new Administrador(1,"Jeison","Esquivel Samudio","admin1","1");
        Administrador admin2= new Administrador(2,"Jaime","Solano","admin2","1");
        //</editor-fold>

        //<editor-fold desc="Cajeros">
        Cajero cajero1 = new Cajero(3, "Jager", "Gato Cat", "cajero1", "1");
        Cajero cajero2 = new Cajero(4, "Michael", "Perez", "cajero2", "1");
        //</editor-fold>

        //<editor-fold desc="Clientes">
        Cliente cliente1 = new Cliente(1, "Jesus", "De La Cruz", "Jerusalem");
        Cliente cliente2 = new Cliente(2, "Hitomi", "Tanaka", "Tokyo, Japon");
        //</editor-fold>

        //</editor-fold>

        //<editor-fold desc="Poblacion de listas">
        usuarios.add(admin1);
        usuarios.add(admin1);

        usuarios.add(cajero1);
        usuarios.add(cajero2);

        clientes.add(cliente1);
        clientes.add(cliente2);
        //</editor-fold>
    }

    public Usuario obtenerUsuario(String username, String password) {
        for (Usuario u:usuarios) {
            if (u.getUsername().equals(username) && u.getContrasenna().equals(password))
                return u;
        }
        return null;
    }
}
