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
public class Nodo {
    
    public ArrayList nodosHijos = new ArrayList();
    public String info = "";
    public int preOrder = 0;
    public int postOrder = 0;
    
    public Nodo(String theInfo) {
        this.setInfo(theInfo);
    }
    
    public String getInfo() {
        return this.info;
    }
    
    public void setInfo(String theInfo) {
        this.info = theInfo;
    }
    
    public int getPostOrder() {
        return postOrder;
    }
    
    public void setPostOrder(int postOrder) {
        this.postOrder = postOrder;
    }
    
    public int getPreOrder() {
        return preOrder;
    }
    
    public void setPreOrder(int preOrder) {
        this.preOrder = preOrder;
    }
}
