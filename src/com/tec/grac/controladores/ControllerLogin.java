package com.tec.grac.controladores;

import com.tec.grac.modelo.Administrador;
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
        String username=tf_nombreUsuario.getText();
        String password= pf_contrasenna.getText();


        if (gestorDatos.obtenerUsuario(username,password)){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vistas/Principal_admin_view.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            Stage principal= (Stage) ((Node) event.getSource()).getScene().getWindow();
            principal.hide();
            stage.showAndWait();
            principal.show();
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
