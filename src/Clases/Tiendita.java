/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JTable;

/**
 *
 * @author migue
 */
public class Tiendita {
    // Atributos
    public String nombre;
    public String producto;
    public int existencia;
    public double costo;
    
    // Constructores
    public Tiendita() {
        this.nombre = null;
        this.producto = null;
        this.existencia = 0;
        this.costo = 0.0;
    }

    public Tiendita(String nombre, String producto, int existencia, double costo) {
        this.nombre = nombre;
        this.producto = producto;
        this.existencia = existencia;
        this.costo = costo;
    }
    
    // Metodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    // Metodos
    public void aleatorio(JTable tabla) {
        String nombres[] = {"Antoja Tec", "Chela", "El Amigo", "Oxxo", "Seven",
                        "Cirlce K", "Extra", "One Stop", "Punto +", "Fiesta", "Alsuper", "Bodega Aurrera"};
        String productos[] = {"Papas", "Coca Cola", "Galletas Emperador", "Burritos", "Fresca",
                        "Churros", "Gorditas", "Hersheys", "Chocomilk", "Tecate", "Cigarros"};
        
        Random rnd = new Random();
        DecimalFormat formato = new DecimalFormat("#.##");
        
        tabla.setValueAt(nombres[rnd.nextInt(nombres.length)], 0, 0);
        tabla.setValueAt(productos[rnd.nextInt(productos.length)], 0, 1);
        tabla.setValueAt(rnd.nextInt(0,250), 0, 2);
        tabla.setValueAt(formato.format(rnd.nextInt(15,80) + rnd.nextDouble()), 0, 3);
    }    
    
    
    
    
    
    
}
