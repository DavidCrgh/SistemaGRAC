package com.tec.grac;

import com.tec.grac.controladores.ControllerLogin;
import com.tec.grac.modelo.GestorDatos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader=  new FXMLLoader(getClass().getResource("vistas/login_view.fxml"));
        Parent root = loader.load();
        ControllerLogin controllerLogin= loader.getController();
        controllerLogin.gestorDatos= new GestorDatos();

        primaryStage.setTitle("Sistema GRAC");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
