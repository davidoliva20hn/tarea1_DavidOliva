/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea.pkg1_davidoliva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author DAVIDANDRESOLIVAHERN
 */
public class Tarea1_DavidOliva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        ArrayList<mascota> masco = new ArrayList<>();

        int opc = 0;
        String opcion[] = {"Agregar", "Listar", "Modificar", "Eliminar", "Mascota más antigua", "Mascotas negras", "Diferencia de edad", "Salir"};

        do {
            opc = JOptionPane.showOptionDialog(null, "Seleccionar una opción", "MENU", 0, JOptionPane.INFORMATION_MESSAGE, null, opcion, null);
            switch (opc) {
                case 0 -> {
                    if (masco.size() < 100) {
                        String nombre = JOptionPane.showInputDialog("Nombre");
                        String tipo = JOptionPane.showInputDialog("Tipo");
                        String color = JOptionPane.showInputDialog("Color");
                        String fnmas = JOptionPane.showInputDialog("Fecha de nacimiento [D/M/Y]");
                        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyy");
                        Date fn = fecha.parse(fnmas);
                        int precio = Integer.parseInt(JOptionPane.showInputDialog("Precio"));
                        mascota Mascota = new mascota(nombre, tipo, color, fn, precio);
                        masco.add(Mascota);
                    } else {
                        JOptionPane.showMessageDialog(null, "El programa llegó al máximo de mascotas");
                    }
                }
                case 1 -> {
                    String estado = "";
                    for (int i = 0; i < masco.size(); i++) {
                        estado += masco.get(i).toString() + "\n";

                    }
                    JOptionPane.showMessageDialog(null, estado);
                }
                case 2 -> {
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota a modificar");
                    for (int i = 0; i < masco.size(); i++) {
                        if (masco.get(i).nombre.equalsIgnoreCase(nombre)) {
                            String opcion2[] = {"tipo", "color", "fecha de nacimiento", "precio"};
                            int opc2 = JOptionPane.showOptionDialog(null, "Seleccionar una opción", "MENU", 0, JOptionPane.INFORMATION_MESSAGE, null, opcion2, null);
                            switch (opc2) {
                                case 0 -> {
                                    String tipo = JOptionPane.showInputDialog("Ingrese el nuevo tipo de la mascota");
                                    String color = masco.get(i).color;
                                    Date fn = masco.get(i).fnmas;
                                    int precio = masco.get(i).precio;
                                    mascota Mascota = new mascota(nombre, tipo, color, fn, precio);
                                    masco.remove(i);
                                    masco.add(Mascota);
                                }
                                case 1 -> {
                                    String color = JOptionPane.showInputDialog("Ingrese el nuevo color de la mascota");
                                    String tipo = masco.get(i).tipo;
                                    Date fn = masco.get(i).fnmas;
                                    int precio = masco.get(i).precio;
                                    mascota Mascota = new mascota(nombre, tipo, color, fn, precio);
                                    masco.remove(i);
                                    masco.add(Mascota);
                                }
                                case 2 -> {
                                    String fnmas = JOptionPane.showInputDialog("Ingrese la nueva Fecha [D/M/Y]");
                                    SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyy");
                                    Date fn = fecha.parse(fnmas);
                                    String color = masco.get(i).color;
                                    String tipo = masco.get(i).tipo;
                                    int precio = masco.get(i).precio;
                                    mascota Mascota = new mascota(nombre, tipo, color, fn, precio);
                                    masco.remove(i);
                                    masco.add(Mascota);
                                }
                                case 3 -> {
                                    int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio de la mascota"));
                                    String color = masco.get(i).color;
                                    String tipo = masco.get(i).tipo;
                                    Date fn = masco.get(i).fnmas;
                                    mascota Mascota = new mascota(nombre, tipo, color, fn, precio);
                                    masco.remove(i);
                                    masco.add(Mascota);
                                }
                            }
                        }
                    }
                }
                case 3 -> {
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota a Eliminar");
                    for (int i = 0; i < masco.size(); i++) {
                        if (masco.get(i).nombre.equalsIgnoreCase(nombre)) {
                            masco.remove(i);
                            break;
                        }
                    }
                }
                case 4 -> {
                    String estado = "";
                    int añomenor = 0;
                    for (int i = 0; i < masco.size(); i++) {
                        Date fn = masco.get(i).fnmas;
                        int año= fn.getYear();;
                        if (añomenor < año) {
                            añomenor = año;
                            estado = masco.get(i).toString();
                        }
                    }
                    JOptionPane.showMessageDialog(null, estado);
                }
                case 5 -> {
                    String estado = "";
                    for (int i = 0; i < masco.size(); i++) {
                        if (masco.get(i).color.equalsIgnoreCase("negro")) {
                            estado += masco.get(i).toString() + "\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, estado);
                }
                case 6 -> {
                    int edad1 = 0;
                    int edad2 = 0;
                    String nombre1 = JOptionPane.showInputDialog("Ingrese nombre de la mascota 1 ");
                    String nombre2 = JOptionPane.showInputDialog("Ingrese nombre de la mascota 2");
                    for (int i = 0; i < masco.size(); i++) {
                        if (masco.get(i).nombre.equalsIgnoreCase(nombre1)) {
                            Date fn = masco.get(i).fnmas;
                            edad1 = fn.getYear();
                        } else if (masco.get(i).nombre.equalsIgnoreCase(nombre2)) {
                            Date fn = masco.get(i).fnmas;
                            edad2 = fn.getYear();
                        }
                    }
                    int dif = 0;
                    if (edad1 < edad2) {
                        dif = edad2 - edad1;
                    } else {
                        dif = edad1 - edad2;
                    }
                    JOptionPane.showMessageDialog(null, " Diferencia de edad entre las 2 mascotas es de:" + dif);
                }
                case 7 -> {
                    System.exit(0);
                }
            }

        } while (true);
    }

}
