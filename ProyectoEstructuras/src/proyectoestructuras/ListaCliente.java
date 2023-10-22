/*
  Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;

/**
 *
 * @author indir
 */
public class ListaCliente {
     private NodoCliente cabeza;

    public ListaCliente() {
        cabeza = null;
    }

    public NodoCliente getCabeza() {
        return cabeza;
    }

    // Agrega personas en lista enlanzada
    public void agregarPersonaOrdenado(Customer persona) {
        NodoCliente nuevoNodo = new NodoCliente(persona);
        if (cabeza == null || cabeza.getPersona().getId() > persona.getId()) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        } else {
            NodoCliente aux = cabeza;
            while (aux.getSiguiente() != null && aux.getSiguiente().getPersona().getId() < persona.getId()) {
                aux = aux.getSiguiente();
            }
            nuevoNodo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevoNodo);
        }
    }

    // Muestra lista
    public void mostrarPersonas() {
        NodoCliente aux = cabeza;
        while (aux != null) {
            System.out.println(aux.getPersona());
            aux = aux.getSiguiente();
        }
    }
}


