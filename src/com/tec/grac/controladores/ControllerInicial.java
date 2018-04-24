package com.tec.grac.controladores;

import com.tec.grac.modelo.GestorDatos;

import com.tec.grac.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Jeison on 23/04/2018.
 */
public class ControllerInicial {

    public GestorDatos gestorDatos;
    public Usuario usuario;

    @FXML
    public void clientes_btn_OnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vistas/CRUD_view.fxml"));
        Parent root = fxmlLoader.load();
        ControllerCRUD controllerCRUD=  fxmlLoader.getController();
        controllerCRUD.gestorDatos=gestorDatos;
        controllerCRUD.cargarTablaClientes();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        Stage principal= (Stage) ((Node) event.getSource()).getScene().getWindow();
        principal.hide();
        stage.show();
    }

    @FXML
    public void registrarVehículo_btn_OnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vistas/Reg_vehiculo_view.fxml"));
        Parent root = fxmlLoader.load();
        ControllerVehiculo controllerVehiculo=  fxmlLoader.getController();
        controllerVehiculo.gestorDatos=gestorDatos;
        controllerVehiculo.cargarTablaVehiculos();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        Stage principal= (Stage) ((Node) event.getSource()).getScene().getWindow();
        principal.hide();
        stage.show();
    }

    @FXML
    public void alquilar_btn_OnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vistas/alquilar_automovil_view.fxml"));
        Parent root = fxmlLoader.load();
        ControllerAlquiler controllerAlquiler=  fxmlLoader.getController();
        controllerAlquiler.gestorDatos=gestorDatos;
        controllerAlquiler.usuario=usuario;

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        Stage principal= (Stage) ((Node) event.getSource()).getScene().getWindow();
        principal.hide();
        stage.show();
    }









}
