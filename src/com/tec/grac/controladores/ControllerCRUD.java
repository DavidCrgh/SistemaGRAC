package com.tec.grac.controladores;

import com.tec.grac.modelo.GestorDatos;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Jeison on 23/04/2018.
 */
public class ControllerCRUD {

    public GestorDatos gestorDatos;
    @FXML
    TextField tf_idCliente,tf_nombre,tf_apellido,tf_direccion;


    public void salir_btn_OnClick(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vistas/Principal_admin_view.fxml"));
        Parent root = fxmlLoader.load();
        ControllerCRUD controllerCRUD=  new ControllerCRUD();
        controllerCRUD.gestorDatos=gestorDatos;
        fxmlLoader.setController(controllerCRUD);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        Stage principal= (Stage) ((Node) event.getSource()).getScene().getWindow();
        principal.hide();
        stage.show();
    }



}
