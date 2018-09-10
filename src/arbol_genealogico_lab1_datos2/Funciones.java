/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_genealogico_lab1_datos2;

import java.awt.Font;
import java.io.InputStream;

/**
 *
 * @author danie
 */
public class Funciones {

    public Font font = null;

    Nodo insertar(Nodo raiz, String nom_padre, String nombre) {
        Nodo nuevo = new Nodo(nombre);
        Nodo padre = buscar(raiz, nom_padre);
        if (padre.derecho == null) {
            padre.derecho = nuevo;
        } else {
            if (padre.izquierdo == null) {
                padre.izquierdo = nuevo;
            }
        }
        return raiz;
    }

    Nodo buscar(Nodo raiz, String nombre) {
        if (raiz != null) {
            if (raiz.getNombre().equals(nombre)) {
                return raiz;
            } else {
                Nodo izquierdo = buscar(raiz.getIzquierdo(), nombre);
                Nodo derecho = buscar(raiz.getDerecho(), nombre);
                if (izquierdo != null) {
                    return izquierdo;
                }
                if (derecho != null) {
                    return derecho;
                }
            }
        }
        return null;
    }

    public void CustomFont() {
        String fontName = "Minecrafter.Alt.ttf";
        try {
            InputStream is = getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 14);
        }
    }

    public Font MyFont(int estilo, float tamanio) {
        Font tfont = font.deriveFont(estilo, tamanio);
        return tfont;
    }

    public String padre(Nodo raiz, String nombre) {
        if (raiz != null) {
            if (raiz.izquierdo != null && raiz.izquierdo.nombre.equals(nombre)) {
                return raiz.nombre;
            }
            if (raiz.derecho != null && raiz.derecho.nombre.equals(nombre)) {
                return raiz.nombre;
            }
            String izquierdo = padre(raiz.izquierdo, nombre);
            String derecho = padre(raiz.derecho, nombre);
            if (!izquierdo.equals("")) {
                return izquierdo;
            }
            if (!derecho.equals("")) {
                return derecho;
            }
        }
        return "";
    }

    public boolean hermano(Nodo raiz, String herma1, String herma2) {
        if (padre(raiz, herma1).equals(padre(raiz, herma2))) {
            return true;
        }
        return false;
    }

    public boolean tio(Nodo raiz, String nomtio, String nomsob) {
        if (hermano(raiz, nomtio, padre(raiz, nomsob))) {
            return true;
        }
        return false;
    }

    public boolean primo(Nodo raiz, String primo1, String primo2) {
        if (hermano(raiz, padre(raiz, primo1), padre(raiz, primo2))) {
            return true;
        }
        return false;
    }

    public boolean abuelo(Nodo raiz, String nomabuelo, String nomnieto) {
        if (nomabuelo.equals(padre(raiz, padre(raiz, nomnieto)))) {
            return true;
        }
        return false;
    }

}
