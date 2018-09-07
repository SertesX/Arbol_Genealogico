/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_genealogico_lab1_datos2;

/**
 *
 * @author danie
 */
public class Funciones {
    
    Nodo insertar(Nodo raiz, String nom_padre, String nombre){
        Nodo nuevo = new Nodo(nombre);
        Nodo padre=buscar(raiz,nom_padre);
        if(padre.derecho==null){
            padre.derecho=nuevo;
        }else{
            if(padre.izquierdo==null){
                padre.izquierdo=nuevo;
            }
        }
        return raiz;
    }
    
    Nodo buscar(Nodo raiz, String nombre) {
        if (raiz.getNombre().equals(nombre)){ 
                return raiz; 
        }else{
            Nodo izquierdo=buscar(raiz.getIzquierdo(),nombre);
            Nodo derecho=buscar(raiz.getDerecho(),nombre);
            if (izquierdo != null){
                return izquierdo;
            }
            if(derecho !=null){
                return derecho;
            }
        }
        return null;
    }
}
