/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablorosales.controller;

import com.pablorosales.model.Usuario;
import com.pablorosales.view.LoginView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController {

    private final LoginView LOGIN_VIEW;
    private double xOffset = 0;
    private double yOffset = 0;
    private Stage escenario = SceneManager.getInstanciaSceneManager().getEscenarioPrincipal();
    private AuthSistema authSistema = new AuthSistema();

    public LoginController(LoginView loginView) {
        this.LOGIN_VIEW = loginView;
        construirAcciones();
    }

    public void construirAcciones() {
        // Botón de cerrar (hecho a mano)
        this.LOGIN_VIEW.getBtnCerrarVentana().setOnMouseClicked((evento) -> {
            System.exit(0);
        });

        // Eventos para arrastrar la ventana (Drag) sin barra de título estándar
        this.LOGIN_VIEW.setOnMousePressed((evento) -> {
            xOffset = evento.getSceneX();
            yOffset = evento.getSceneY();
        });

        this.LOGIN_VIEW.setOnMouseDragged((evento) -> {
            escenario.setX(evento.getScreenX() - xOffset);
            escenario.setY(evento.getScreenY() - yOffset);
        });

        // Evento de inicio de sesión
        this.LOGIN_VIEW.getBtnIniciarSesion().setOnMouseClicked((evento) -> {
            iniciarSesion();
        });
    }

    public void iniciarSesion() {
        // Limpiamos estilos de validación previos
        this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().removeAll("empty", "error");
        this.LOGIN_VIEW.getPwdClave().getStyleClass().removeAll("empty", "error");

        String userName = this.LOGIN_VIEW.getTxtNombreUsuario().getText().trim();
        String clave = this.LOGIN_VIEW.getPwdClave().getText().trim();

        if (userName.isEmpty()) {
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("empty");
            JOptionPane.showMessageDialog(null, "No deje el campo usuario vacío");
        } else if (clave.isEmpty()) {
            this.LOGIN_VIEW.getPwdClave().getStyleClass().add("empty");
            JOptionPane.showMessageDialog(null, "No deje el campo contraseña vacío");
        } else {
            Usuario usuario = authSistema.login(userName, clave);
            if (usuario == null) {
                // Si el login falla, pintamos los bordes de color rojo (CSS error)
                this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("error");
                this.LOGIN_VIEW.getPwdClave().getStyleClass().add("error");
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Valide sus datos.");
            } else {
                JOptionPane.showMessageDialog(null, "¡Acceso concedido!");
                // Transición: Se abre la ventana de bienvenida con los datos del usuario logueado
                SceneManager.getInstanciaSceneManager().ventanaBienvenida(usuario);
            }
        }
    }
}