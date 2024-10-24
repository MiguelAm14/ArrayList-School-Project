/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author migue
 */
public class ArrayListDefinida {
    // Atributos
    private ArrayList <Tiendita> arrayTiendita;
    
    // Constructor
    public ArrayListDefinida() {
        arrayTiendita = new <Tiendita> ArrayList();
    }

    public ArrayList<Tiendita> getArrayTiendita() {
        return arrayTiendita;
    }
        
    // Métodos
    public void guardar(Tiendita oTiendita) {
        arrayTiendita.add(oTiendita);
    }
    
    public void eliminar(Tiendita oTienda) {
        // Verifica si el arreglo contiene el objeto deseado, y lo elimina
        if(arrayTiendita.contains(oTienda))
            arrayTiendita.remove(oTienda);
        else
            JOptionPane.showMessageDialog(null, "El objeto no existe en la lista", "Error", JOptionPane.ERROR_MESSAGE);      
    }
    
    public void modificar(Tiendita oTiendita, int pos) {
        if(pos >= 0 && pos <= arrayTiendita.size())
            arrayTiendita.set(pos, oTiendita);
        else
            JOptionPane.showMessageDialog(null, "La posicion no existe","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public void mostrar(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(arrayTiendita.size());
        
        if(!arrayTiendita.isEmpty()) {
            for (int i = 0; i < arrayTiendita.size(); i++) {
                tabla.setValueAt(arrayTiendita.get(i).getNombre(), i, 0);
                tabla.setValueAt(arrayTiendita.get(i).getProducto(), i, 1);
                tabla.setValueAt(arrayTiendita.get(i).getExistencia(), i, 2);
                tabla.setValueAt(arrayTiendita.get(i).getCosto(), i, 3);
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay elementos para mostrar");
        }
    }
    
    public void ordShell() {
        Tiendita aux;
        boolean cambios;
        
        for (int i = arrayTiendita.size()/2; i != 0; i/=2) {
            cambios = true;
            while(cambios) {
                cambios = false;
                for (int j = i; j < arrayTiendita.size(); j++) {
                    if (arrayTiendita.get(j-i).getCosto() > arrayTiendita.get(j).getCosto()) {
                        aux = arrayTiendita.get(j);
                        arrayTiendita.set(j, arrayTiendita.get(j-i));
                        arrayTiendita.set(j-i, aux);
                        cambios = true;
                    }
                }
            }
        }

    
    }
    
    
}
