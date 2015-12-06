/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

/**
 *
 * @author jefersson
 */
public class Main {
    public static void main(String[] args) {
         ArbolNario arbol = new ArbolNario();
         arbol.insertarHijo(null, "1");
         arbol.insertarHijo("1", "2");
         arbol.insertarHijo("1", "3");
         arbol.insertarHijo("2", "4");
         arbol.insertarHijo("2", "5");
         arbol.insertarHijo("2", "6");
         arbol.imprimirArbol(arbol);
         arbol.postOrder();
    }
}
