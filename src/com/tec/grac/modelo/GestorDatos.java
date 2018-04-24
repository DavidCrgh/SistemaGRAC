package com.tec.grac.modelo;

import java.util.ArrayList;
import java.util.Date;

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

        //<editor-fold desc="Vehiculos">
        Vehiculo vehiculo1 = new Vehiculo("DSS-072", "Citroen C1", 2013, "Rojo", 4);
        Vehiculo vehiculo2 = new Vehiculo("BFF-565", "Ford Ecosport", 2014, "Gris", 5);
        //</editor-fold>

        //</editor-fold>

        //<editor-fold desc="Poblacion de listas">
        usuarios.add(admin1);
        usuarios.add(admin1);

        usuarios.add(cajero1);
        usuarios.add(cajero2);

        clientes.add(cliente1);
        clientes.add(cliente2);

        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        //</editor-fold>
    }

    public Alquiler agregarAlquiler(
            Date fechaInicio,
            Date fechaFin,
            Usuario cajero,
            Cliente cliente,
            Vehiculo vehiculo) throws Exception{

        if(vehiculo.isAlquilado()){
            throw new Exception();
        } else {
            Alquiler alquiler = new Alquiler(fechaInicio, fechaFin, cajero, cliente, vehiculo);
            alquileres.add(alquiler);
            vehiculo.setAlquilado(true);
            return alquiler;
        }
    }

    public Usuario obtenerUsuario(String username, String password) {
        for (Usuario u:usuarios) {
            if (u.getUsername().equals(username) && u.getContrasenna().equals(password))
                return u;
        }
        return null;
    }


    public boolean existeCliente(int cliente){
        for (Cliente c:clientes) {
            if (c.getIdCliente()==cliente)
                return true;
        }
        return false;
    }





    public boolean exiteVehiculo(String placa){
        for (Vehiculo v: vehiculos) {
            if (v.getPlaca().equals(placa))
                return true;
        }
        return false;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }


    public void setVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }


    public void setCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }



    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public void editarCliente(Cliente clienteSeleccionado) {
        Cliente cliente = null;
        for (Cliente c: clientes) {
            if (c.getIdCliente()==clienteSeleccionado.getIdCliente()){
                cliente=c;
            }
        }
        cliente.setNombre(clienteSeleccionado.getNombre());
        cliente.setDireccion(clienteSeleccionado.getDireccion());
        cliente.setApellidos(clienteSeleccionado.getApellidos());
    }
}
