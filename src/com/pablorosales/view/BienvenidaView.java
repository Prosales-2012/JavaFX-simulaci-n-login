/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablorosales.view;

import com.pablorosales.model.Usuario;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

// Hacemos que herede de VBox para estructurar los elementos verticalmente
public class BienvenidaView extends VBox {

    private Label lblMensaje;
    private Label lblRol;
    private Button btnSalir;

    // CONSTRUCTOR CORREGIDO: Ahora sí acepta el parámetro Usuario
    public BienvenidaView(Usuario usuario) {
        // Configuración de espaciado y alineación del contenedor
        this.setSpacing(20);
        this.setPadding(new Insets(30));
        this.setAlignment(Pos.CENTER);
        
        // Color de fondo corporativo y bordes redondeados requeridos en el diseño
        this.setBackground(new Background(new BackgroundFill(
                Paint.valueOf("#118C7F"), 
                new CornerRadii(20), 
                Insets.EMPTY
        )));

        // Etiqueta de bienvenida personalizada usando el objeto Usuario
        lblMensaje = new Label("¡Bienvenido, " + usuario.getNombreCompleto() + "!");
        lblMensaje.setFont(Font.font("System", FontWeight.BOLD, 18));
        lblMensaje.setTextFill(Paint.valueOf("#FFFFFF"));

        // Etiqueta para mostrar el rol asignado
        lblRol = new Label("Rol asignado: " + usuario.getRol().toString());
        lblRol.setFont(Font.font("System", FontWeight.NORMAL, 14));
        lblRol.setTextFill(Paint.valueOf("#E3DD09"));

        // Botón de salida personalizado con estilos inyectados
        btnSalir = new Button("Cerrar Sesión");
        btnSalir.setStyle("-fx-background-color: #8E27F5; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 10;");
        btnSalir.setPrefWidth(120);
        btnSalir.setPrefHeight(35);
        
        // Evento para cerrar la aplicación
        btnSalir.setOnMouseClicked((e) -> System.exit(0));
        
        // Efecto Hover para el botón (cambia de color al pasar el mouse)
        btnSalir.setOnMouseEntered((e) -> btnSalir.setStyle("-fx-background-color: #a04ef7; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 10;"));
        btnSalir.setOnMouseExited((e) -> btnSalir.setStyle("-fx-background-color: #8E27F5; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 10;"));

        // Agregamos todos los componentes al VBox
        this.getChildren().addAll(lblMensaje, lblRol, btnSalir);
    }
}

 
