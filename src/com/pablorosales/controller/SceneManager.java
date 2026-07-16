
package com.pablorosales.controller;

import com.pablorosales.model.Usuario;
import com.pablorosales.view.BienvenidaView;
import com.pablorosales.view.LoginView;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SceneManager {

    private static SceneManager instancia;
    private Stage escenarioPrincipal;
    private Scene escenaPrincipal; // Corregido el nombre de la variable para evitar errores

    private SceneManager() {}

    public static SceneManager getInstanciaSceneManager() {
        if (instancia == null) {
            instancia = new SceneManager();
        }
        return instancia;
    }

    public void setEscenarioPrincipal(Stage stage) {
        this.escenarioPrincipal = stage;
    }

    public Stage getEscenarioPrincipal() {
        return this.escenarioPrincipal;
    }

    public void ventanaLogin() {
        try {
            // Quitamos la barra de título por defecto para personalizarla
            this.escenarioPrincipal.initStyle(StageStyle.TRANSPARENT);
            
            LoginView login = LoginView.getInstanciaLoginView();
            
            // Creamos la escena con las dimensiones requeridas
            escenaPrincipal = new Scene(login, 370, 425);
            escenaPrincipal.setFill(Color.TRANSPARENT); // Hace transparente el fondo de la ventana
            
            this.escenarioPrincipal.setScene(escenaPrincipal);
            
            // Inicializamos el controlador pasándole la vista
            new LoginController(login);
            
            this.escenarioPrincipal.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para cambiar dinámicamente a la pantalla de Bienvenida
     * una vez el login es correcto.
     */
    public void ventanaBienvenida(Usuario usuario) {
        try {
            // Creamos la vista de Bienvenida pasando el usuario autenticado
            BienvenidaView bienvenida = new BienvenidaView(usuario);
            
            // Creamos una nueva escena para la ventana de bienvenida
            Scene escenaBienvenida = new Scene(bienvenida, 400, 250);
            escenaBienvenida.setFill(Color.TRANSPARENT); // Conserva los bordes redondeados visuales
            
            // Cambiamos la escena actual del escenario por la de bienvenida
            this.escenarioPrincipal.setScene(escenaBienvenida);
            this.escenarioPrincipal.centerOnScreen(); // Centra de nuevo la ventana en pantalla
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}