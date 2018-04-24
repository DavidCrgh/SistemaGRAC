package com.tec.grac.controladores;

import com.tec.grac.modelo.Administrador;
import com.tec.grac.modelo.Cajero;
import com.tec.grac.modelo.GestorDatos;
import com.tec.grac.modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Jeison on 23/04/2018.
 */
public class ControllerLogin{

    public GestorDatos gestorDatos;

    @FXML
    TextField tf_nombreUsuario;

    @FXML
    PasswordField pf_contrasenna;


    public void ingresar_On_Click(Event event) throws IOException {
        String username = tf_nombreUsuario.getText();
        String password = pf_contrasenna.getText();
        Usuario usuario = gestorDatos.obtenerUsuario(username, password);

        if (usuario != null){
            String path_view;
            Parent root;

            if(usuario instanceof Administrador){
                path_view = "../vistas/Principal_admin_view.fxml";
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path_view));
                root = fxmlLoader.load();
                ControllerInicial controllerInicial = fxmlLoader.getController();
                controllerInicial.gestorDatos = gestorDatos;
                controllerInicial.usuario=usuario;
            } else if(usuario instanceof Cajero){
                path_view = "../vistas/alquilar_automovil_view.fxml";
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path_view));
                root = fxmlLoader.load();
                ControllerAlquiler controllerAlquiler = fxmlLoader.getController();
                controllerAlquiler.gestorDatos = gestorDatos;
                controllerAlquiler.usuario = usuario;
                controllerAlquiler.poblarCombobox();
            } else {
                path_view = "";
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path_view));
                root = fxmlLoader.load();
            }

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            Stage principal = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.show();
            principal.hide();

        }else{
         Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Mensaje de error");
            alert.setHeaderText("Error al inicar sesión");
            alert.setContentText("Contraseña o nombre de usuario incorrectos");
            alert.showAndWait();

        }
        tf_nombreUsuario.clear();
        pf_contrasenna.clear();
    }













}
