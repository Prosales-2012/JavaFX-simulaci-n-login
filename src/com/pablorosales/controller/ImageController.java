/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablorosales.controller;

/**
 *
 * @author informatica
 */
import javafx.scene.image.Image;
 
/**

*

* @author informatica

*/

public class ImageController {
 
    private final String RUTA_IMAGENES = "/com/pablorosales/resources/";

    Image imagenAMostrar;

    public Image getImageLogin(String nombreImagen) {

        switch (nombreImagen) {

            case "logo":

                imagenAMostrar = new Image(RUTA_IMAGENES + "login-logo.png");

                break;

            default:

                imagenAMostrar = new Image(RUTA_IMAGENES + "login-logo.png");

        }

        return imagenAMostrar;

    }

}
 