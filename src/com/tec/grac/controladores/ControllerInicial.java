package com.tec.grac.controladores;

import com.tec.grac.modelo.GestorDatos;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Created by Jeison on 23/04/2018.
 */
public class ControllerInicial {

    public GestorDatos gestorDatos;


    public void clientes_btn_OnClick(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vistas/CRUD_view.fxml"));
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
