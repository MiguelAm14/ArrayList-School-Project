/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.text.DecimalFormat;
import java.util.ArrayList; 
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author migue
 * @param <T>
 */
public class ArrayListGenerica<T extends Comparable<T>> {
    // Atributos
    private T dato;
    ArrayList<T> lista;
    
    // Constructores
    public ArrayListGenerica() {
        lista = new ArrayList<>();
    }
    
    public ArrayListGenerica(ArrayList<T> lista, T dato) {
        this.dato = dato;
        this.lista = lista;
    }
    
    // Metodos
    public void guardar(T dato) {
        if(dato != null)
            lista.add(dato);
    }
    
    public void limpiarLista() {
        lista.clear();
    }
    
    public void mostrar(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(lista.size());
        
        if(!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                tabla.setValueAt(lista.get(i), i, 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay elementos para mostrar");
        }
        
    }

    public void aleatorio(JRadioButton entero, JRadioButton doble, JRadioButton caracter, JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        Random rnd = new Random();
        DecimalFormat df = new DecimalFormat("#.00");
        
        for(int i = 0; i < modelo.getRowCount(); i++) {
            if (entero.isSelected()) {
                modelo.setValueAt(rnd.nextInt(100), i, 0);
            } else if (doble.isSelected()) {
                modelo.setValueAt(df.format(rnd.nextDouble(100)), i, 0);
            } else if (caracter.isSelected()) {
                modelo.setValueAt((char)(rnd.nextInt(26) + 'A'), i, 0);
            }
        }

    }

    public void ordSeleccion() {
        for (int i = 0; i < lista.size() - 1; i++) {
            int min = i;
            for (int j = i+1; j <= lista.size() - 1; j++) {
                if (lista.get(j).compareTo(lista.get(min)) < 0) {
                    min = j;
                }
            }
            // Intercambiar el elemento más chico con el 
            //primer elemento que no se ordena
            T aux  = lista.get(min);
            lista.set(min, lista.get(i));
            lista.set(i, aux);
        }
    }

}

      

    

