package com.tec.grac.controladores;

import com.tec.grac.modelo.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Jeison on 23/04/2018.
 */
public class ControllerAlquiler implements Initializable {

    @FXML
    DatePicker dp_fechaInicio;

    @FXML
    DatePicker dp_fechaFin;

    @FXML
    ComboBox<Cliente> cb_cliente;

    @FXML
    ComboBox<Vehiculo> cb_vehiculo;

    @FXML
    Button btn_crearAlquiler;

    public GestorDatos gestorDatos;

    public Usuario usuario;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void poblarCombobox(){
        Callback<ListView<Cliente>, ListCell<Cliente>> factoryCliente = lv -> new ListCell<Cliente>() {
            @Override
            protected void updateItem(Cliente item, boolean empty){
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNombreCompleto());
            }
        };
        cb_cliente.setCellFactory(factoryCliente);
        cb_cliente.setButtonCell(factoryCliente.call(null));
        cb_cliente.setItems(FXCollections.observableArrayList(gestorDatos.getClientes()));

        Callback<ListView<Vehiculo>, ListCell<Vehiculo>> factoryVehiculo = lv -> new ListCell<Vehiculo>(){
            @Override
            protected void updateItem(Vehiculo item, boolean empty){
                super.updateItem(item, empty);
                setText(empty ? "" : item.getModelo());
            }
        };
        cb_vehiculo.setCellFactory(factoryVehiculo);
        cb_vehiculo.setButtonCell(factoryVehiculo.call(null));
        cb_vehiculo.setItems(FXCollections.observableArrayList(gestorDatos.getVehiculos()));
    }

    public void onbtn_crearAlquilerClicked(){
        Date fechaInicio = Date.from(
                dp_fechaInicio.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()
        );
        Date fechaFin = Date.from(
                dp_fechaFin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()
        );
        Cliente cliente = cb_cliente.getValue();
        Vehiculo vehiculo = cb_vehiculo.getValue();

        try {
            Alquiler alquiler = gestorDatos.agregarAlquiler(fechaInicio, fechaFin, usuario, cliente, vehiculo);
            System.out.println(alquiler.toString());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mensaje de error");
            alert.setHeaderText("Error al crear alquiler");
            alert.setContentText("El vehiculo seleccionado ya se encuentra alquilado.");
            alert.showAndWait();
        }
    }
}
