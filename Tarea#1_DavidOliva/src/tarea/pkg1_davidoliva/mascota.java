/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea.pkg1_davidoliva;

import java.util.Date;

/**
 *
 * @author DAVIDANDRESOLIVAHERN
 */
public class mascota {
    String nombre;
    String tipo;
    String color;
    Date fnmas;
    int precio;

    public mascota(String nombre, String tipo, String color, Date fnmas, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.color = color;
        this.fnmas = fnmas;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", tipo=" + tipo + ", color=" + color + ", fecha de nacimiento=" + fnmas + ", precio=" + precio + '}';
    }
    
    
}
