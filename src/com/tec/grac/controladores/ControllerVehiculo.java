package com.tec.grac.controladores;

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
public class ControllerVehiculo implements Initializable {

    public GestorDatos gestorDatos;

    @FXML
    TextField tf_placa,tf_modelo,tf_anno,tf_color;

    @FXML
    Spinner sp_asientos;


    @FXML
    TableView tv_vehiculos;

    @FXML
    TableColumn tc_placa,tc_modelo,tc_anno,tc_color,tc_asientos;




    @FXML
    public void salir_btn_OnClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../vistas/Principal_admin_view.fxml"));
        Parent root = fxmlLoader.load();
        ControllerInicial controllerInicial = fxmlLoader.getController();
        controllerInicial.gestorDatos=gestorDatos;

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        Stage principal= (Stage) ((Node) event.getSource()).getScene().getWindow();
        principal.hide();
        stage.show();
    }


    @FXML
    public void registrar_btn_OnClickç(ActionEvent event){
        try {
            String placa =tf_placa.getText();
            String modelo= tf_modelo.getText();
            int anno= Integer.parseInt(tf_anno.getText());
            String color=tf_color.getText();
            int asientos= (int) sp_asientos.getValue();
            boolean existeVehiculo= gestorDatos.exiteVehiculo(placa);
            if (!existeVehiculo){
                Vehiculo nuevoVehiculo= new Vehiculo(placa,modelo,anno,color,asientos);
                gestorDatos.setVehiculo(nuevoVehiculo);
                cargarTablaVehiculos();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Mensaje de error");
                alert.setHeaderText("Error al registrar vehículo");
                alert.setContentText("El vehñiculo ya existe");
                alert.showAndWait();
                cargarTablaVehiculos();

            }
            limpiarInterface();

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia!!!");
            alert.setHeaderText("Mensaje de advertencia");
            alert.setContentText("Verifique los datos de entrada");
            alert.showAndWait();
        }
    }

    public void cargarTablaVehiculos(){
        ObservableList<Vehiculo> datosTablaProducto = FXCollections.observableArrayList(gestorDatos.getVehiculos());
        tv_vehiculos.setItems(datosTablaProducto);
    }




    public void limpiarInterface(){
        tf_anno.clear();
        tf_modelo.clear();
        tf_color.clear();
        tf_placa.clear();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
//Cofiguracion de columnas de tabla de productos
        tc_placa.setCellValueFactory(
                new PropertyValueFactory<Vehiculo, String>("placa")
        );
        tc_modelo.setCellValueFactory(
                new PropertyValueFactory<Vehiculo, String>("modelo")
        );
        tc_anno.setCellValueFactory(
                new PropertyValueFactory<Vehiculo, Integer>("anno")
        );
        tc_color.setCellValueFactory(
                new PropertyValueFactory<Vehiculo, String>("color")
        );
        tc_asientos.setCellValueFactory(
                new PropertyValueFactory<Vehiculo, Integer>("asientos")
        );
    }
}
