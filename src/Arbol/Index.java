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
public class Index {
    
    private int indexPreOrder=-1;
    private int indexPostOrder=-1;
    private String infoNodo="";
    
    public Index(int preOrder, int postOrder, String infoNodo) {
        this.setIndexPreOrder(preOrder);
        this.setIndexPostOrder(postOrder);
        this.setInfoNodo(infoNodo);
    }
    
    public int getIndexPostOrder() throws Exception {
        return indexPostOrder;
    }
    
    public void setIndexPostOrder(int indexPostORder) {
        this.indexPostOrder = indexPostOrder;
    }
    
    public int getIndexPreOrder() {
        return indexPreOrder;
    }
    
    public void setIndexPreOrder(int indexPreOrder) {
        this.indexPreOrder = indexPreOrder;
    }
    
    public String getInfoNodo() {
        return infoNodo;
    }
    
    public void setInfoNodo(String infoNodo) {
        this.infoNodo = infoNodo;
    }
}
