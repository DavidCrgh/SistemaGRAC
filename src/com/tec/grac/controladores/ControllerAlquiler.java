package com.tec.grac.controladores;

import com.tec.grac.modelo.GestorDatos;
import com.tec.grac.modelo.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;

import java.net.URL;
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
    ComboBox cb_cliente;

    @FXML
    ComboBox cb_vehiculo;

    @FXML
    Text txt_detallesCliente;

    @FXML
    Text txt_detallesVehiculo;

    public GestorDatos gestorDatos;

    public Usuario usuario;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
