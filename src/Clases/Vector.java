/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Random;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author migue
 */
public class Vector {
    // Atributos
    private char [] vector;
    private int tamaño;
    
    // Constructor por default
    public Vector() {
        vector = null;
    }
    
    // Constructor parametrizado
    public Vector(int tamaño) {
        this.tamaño = tamaño;
        vector = new char[tamaño];
    }
    
    // Metodos get
    public int getTamaño() {
        return tamaño;
    }
    
    // Metodos
    public char[] aleatorio() {
        Random rnd = new Random();
    
        for (int i = 0; i < tamaño; i++) 
            // La clase random genera indices correspondientes a las letras del alfabeto
             vector[i] = (char)(rnd.nextInt(26) + 'A');
        
        return vector;
    }
    
    public void ordInsercion() {
        char aux;
        int i,j;
        
        for (i = 1; i < vector.length; i++) {                             
            aux = vector[i];                                              
            j = i-1;                                              
            while( (j>=0) && (aux<vector[j]) ) { 
                vector[j+1] = vector[j];                                  
                j--;                                                    
            }                                                             
            vector[j+1] = aux;                                             
        }        
    }
    
    public void mostrar(JTable tablaVector) {
        // Se muestra el vector en la JTable
        DefaultTableModel modelo = (DefaultTableModel)tablaVector.getModel();
        
        for (int i = 0; i < tamaño; i++) 
            modelo.setValueAt(vector[i], i, 0);
        
    }

}
