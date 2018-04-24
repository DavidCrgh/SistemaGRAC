package com.tec.grac.controladores;

import com.tec.grac.modelo.Cliente;
import com.tec.grac.modelo.GestorDatos;
import com.tec.grac.modelo.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Jeison on 23/04/2018.
 */
public class ControllerCRUD implements Initializable{

    public GestorDatos gestorDatos;

    @FXML
    TextField tf_idCliente,tf_nombre,tf_apellidos,tf_direccion;


    @FXML
    TableView tv_clientes;


    @FXML
    TableColumn tc_id,tc_nombre,tc_apellidos,tc_direccion;

    @FXML
    Button btn_guardar,btn_registrar;

    Cliente clienteSeleccionado;




    @FXML
    public void registrar_btn_OnClick(ActionEvent event){
        try {
            int idCliente= Integer.parseInt(tf_idCliente.getText());
            String nombre= tf_nombre.getText();
            String apellido= tf_apellidos.getText();
            String direccion = tf_direccion.getText();

            boolean existeCliente= gestorDatos.existeCliente(idCliente);
            if (!existeCliente){
                if (nombre.equals("") || apellido.equals("")|| direccion.equals("")){
                    mostrarMensajeAlerta();
                }else{
                    Cliente nuevoCliente= new Cliente(idCliente,nombre,apellido,direccion);
                    gestorDatos.setCliente(nuevoCliente);
                    limpiarInterface();
                    cargarTablaClientes();
                }
            }else{
                mostrarMensajeError();
            }
        }catch (Exception e){
            mostrarMensajeAlerta();
        }
    }

    @FXML
    public void eliminar_btn_OnClick(ActionEvent event){
        try {
            Cliente cliente= (Cliente) tv_clientes.getSelectionModel().getSelectedItem();
            gestorDatos.eliminarCliente(cliente);
            cargarTablaClientes();
            limpiarInterface();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia!!!");
            alert.setHeaderText("Mensaje de advertencia");
            alert.setContentText("Se debe seleccionar una fila");
            alert.showAndWait();
        }
    }


    @FXML
    public void guardar_btn_OnClick(ActionEvent event){
        try {
            String nombre= tf_nombre.getText();
            String apellido= tf_apellidos.getText();
            String direccion = tf_direccion.getText();
            clienteSeleccionado.setApellidos(apellido);
            clienteSeleccionado.setDireccion(direccion);
            clienteSeleccionado.setNombre(nombre);
            gestorDatos.editarCliente(clienteSeleccionado);
            cargarTablaClientes();
            limpiarInterface();
            clienteSeleccionado=null;
        }catch (Exception e){

        }

    }





    @FXML
    public void editar_btn_OnClick(ActionEvent event){
        try {
            clienteSeleccionado= (Cliente) tv_clientes.getSelectionModel().getSelectedItem();
            tf_nombre.setText(clienteSeleccionado.getNombre());
            tf_idCliente.setText(String.valueOf(clienteSeleccionado.getIdCliente()));
            tf_apellidos.setText(clienteSeleccionado.getApellidos());
            tf_direccion.setText(clienteSeleccionado.getDireccion());

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia!!!");
            alert.setHeaderText("Mensaje de advertencia");
            alert.setContentText("Se debe seleccionar una fila");
            alert.showAndWait();
        }

    }



    public void mostrarMensajeError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Mensaje de error");
        alert.setHeaderText("Error al registrar cliente");
        alert.setContentText("El cliente ya existe");
        alert.showAndWait();
    }

    public void mostrarMensajeAlerta(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia!!!");
        alert.setHeaderText("Mensaje de advertencia");
        alert.setContentText("Verifique los datos de entrada");
        alert.showAndWait();

    }





    @FXML
    public void salir_btn_OnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vistas/Principal_admin_view.fxml"));
        Parent root = fxmlLoader.load();
        ControllerInicial controllerInicial=  fxmlLoader.getController();
        controllerInicial.gestorDatos=gestorDatos;

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        Stage principal= (Stage) ((Node) event.getSource()).getScene().getWindow();
        principal.hide();
        stage.show();
    }


    public void cargarTablaClientes(){
        ObservableList<Cliente> datosTablaProducto = FXCollections.observableArrayList(gestorDatos.getClientes());
        tv_clientes.setItems(datosTablaProducto);
    }

    public void limpiarInterface(){
        tf_apellidos.clear();
        tf_direccion.clear();
        tf_idCliente.clear();
        tf_nombre.clear();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tc_id.setCellValueFactory(
                new PropertyValueFactory<Cliente, Integer>("idCliente")
        );
        tc_nombre.setCellValueFactory(
                new PropertyValueFactory<Cliente, String>("nombre")
        );
        tc_apellidos.setCellValueFactory(
                new PropertyValueFactory<Cliente, String>("apellidos")
        );
        tc_direccion.setCellValueFactory(
                new PropertyValueFactory<Cliente, String>("direccion")
        );




    }
}
