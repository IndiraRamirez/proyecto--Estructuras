/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;

/**
 *
 * @author indir
 */
public class NodoCliente {
      private Customer persona;
    
    private NodoCliente siguiente;

    public NodoCliente (Customer persona) {
        this.persona = persona;
        this.siguiente= null;
        
    }

    public Customer getPersona() {
        return persona;
    }

    public void setPersona(Customer persona) {
        this.persona = persona;
    }

    public NodoCliente  getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Nodo{" + persona +" }";
    }
    
    
    
    
}

