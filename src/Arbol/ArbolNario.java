/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

import java.util.ArrayList;
/**
 *
 * @author jefersson
 */
public class ArbolNario {
    
    public Nodo raiz;
    Nodo nodoActual;
    private int contPostOrder = 0;
    private int contPreOrder = 0;
    private ArrayList indexNodos = new ArrayList();
    
    public ArbolNario(){
        raiz = null;
    }
    
    public void insertarHijo(String padre, String label, String info){
        Nodo aux = new Nodo(label, info);
        if (raiz == null){
            raiz = aux;
            System.out.println("Raíz insertada = " + label);
        } else if (padre.equals("")) {
            System.out.println("Padre vacío");
        } else {
            this.insertarHijo(raiz, padre, label, info);
        }
    }
    private void insertarHijo(Nodo nodoActual, String padre, String theLabel, String theInfo){
        if (nodoActual.getLabel().equals(padre)) {
            nodoActual.nodosHijos.add(new Nodo(theLabel, theInfo));
            System.out.println("Nodo insertado = " + theLabel);
        } else {
            for (int i = 0; i < nodoActual.nodosHijos.size(); i++){
                this.insertarHijo((Nodo)nodoActual.nodosHijos.get(i), padre, theLabel, theInfo);
            }
        }
    }
    
    public void imprimirRecorridos() {
        this.preOrder();
        this.postOrder();
    }
    public void preOrder() {
        contPreOrder = 0;
        this.preOrder(raiz);
    }
    
    private void preOrder(Nodo nodoActual){
        Nodo aux = null;
        contPreOrder++;
        nodoActual.setPreOrder(contPreOrder);
        this.agregarEnIndex(nodoActual, true, false);
        //System.out.println("PreOrder de " + nodoActual.getInfo() + "= " + nodoActual.getPreOrder());
        for (int i=0; i < nodoActual.nodosHijos.size(); i++) {
            aux = (Nodo)nodoActual.nodosHijos.get(i);
            this.preOrder(aux);
        }
    }
    
    public void postOrder() {
        contPostOrder = 0;
        this.postOrder(raiz);
    }
    
    private void postOrder(Nodo nodoActual) {
        Nodo aux = null;
        for (int i=0; i < nodoActual.nodosHijos.size(); i++) {
            aux = (Nodo)nodoActual.nodosHijos.get(i);
            this.postOrder(aux);
        }
        contPostOrder++;
        nodoActual.setPostOrder(contPostOrder);
        this.agregarEnIndex(nodoActual, false, true);
        System.out.println("Postorden de " + nodoActual.getLabel() + "= " + nodoActual.getPostOrder());
    }
    
    private void agregarEnIndex(Nodo nodoActual, boolean esPreOrder, boolean esPostOrder) {
        Index indexTemp;
        boolean exist = false;
        for (int i=0; i < indexNodos.size(); i++) {
            indexTemp = (Index)indexNodos.get(i);
            if (indexTemp.getInfoNodo().equals(nodoActual.getInfo())) {
                exist = true;
                if (esPreOrder) indexTemp.setIndexPreOrder(nodoActual.getPreOrder());
                if (esPostOrder) indexTemp.setIndexPostOrder(nodoActual.getPostOrder());
            }
            if (!exist) {
                indexNodos.add(new Index(nodoActual.getPreOrder(), nodoActual.getPostOrder(), nodoActual.getInfo()));
            }
        }
    }
    
    public void imprimirIndexCompleto() throws Exception {
        Index index = null;
        System.out.println("num index " + indexNodos.size());
        for (int i = 0; i < indexNodos.size(); i++) {
            index = (Index)indexNodos.get(i);
            System.out.println("Nodo " + index.getInfoNodo()+ " Preorden {" + index.getIndexPreOrder() + "} PostOrden {" + index.getIndexPostOrder() + "}" );   
        }
    }
    
    public void getIndex(String nodoInfo) throws Exception {
        Index index;
        boolean exist = false;
        for (int i = 0; i < indexNodos.size(); i++) {
            index = (Index)indexNodos.get(i);
            if (index.getInfoNodo().equals(nodoInfo)) {
                System.out.println("Nodo " + index.getInfoNodo()+ " Preorden {" + index.getIndexPreOrder() + "} PostOrden {" + index.getIndexPostOrder() + "}" );
                exist = true;
            }
            if (!exist) System.out.println("No se ha encontrado el nodo buscado"); 
        }
    }
    
    public void imprimirArbol(ArbolNario arbol) {
        this.imprimirNodo(arbol.raiz);
    }
    
    private void imprimirNodo(Nodo nodoActual) {
        Nodo aux = null;
        //System.out.println("Nodo Papa: " + nodoActual.getInfo());
        for (int i = 0; i < nodoActual.nodosHijos.size(); i++) {
            aux = (Nodo)nodoActual.nodosHijos.get(i);
            System.out.println("Nodo Papa: " + nodoActual.getLabel()+ " -- Nodo hijo: " + aux.getLabel());
            this.imprimirNodo(aux);
        }
    }
}
