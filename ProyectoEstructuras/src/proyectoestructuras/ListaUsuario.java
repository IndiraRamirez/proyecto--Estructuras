/*
  Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;

import javax.swing.JOptionPane;

//import static proyectoestructuras.Menu.cantidadCompraron;
//import static proyectoestructuras.Menu.cantidadReservado;
/**
 *
 * @author indir
 */
public class ListaUsuario {

    private NodoUsuario cabeza;

    public ListaUsuario() {
        cabeza = null;
    }

    public NodoUsuario getCabeza() {
        return cabeza;
    }

    // Agrega personas en lista enlanzada
    
 
      public boolean compararId(String nombre) {
            boolean luz = false;
        NodoUsuario aux = cabeza;
        // existe un cliente con ese id?
        while (aux != null) {
            if (aux.getUsuario().getNombre().equals(nombre)){ //lo busca
                JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese nombre");
                luz = true;//la condicion cambia
                return luz;
               
            }
            aux = aux.getSiguiente();
            
       
       }
        return luz;//si no existe la condicion es falsa
    }
    
    
    public void agregarUsarioOrdenado(Usuario usuario) {
        NodoUsuario nuevoNodo = new NodoUsuario(usuario);
       NodoUsuario aux = cabeza;
        if (cabeza == null || cabeza.getUsuario().getId() > usuario.getId()) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        } else {
            while (aux.getSiguiente() != null && aux.getSiguiente().getUsuario().getId() < usuario.getId()) {
                aux = aux.getSiguiente();
            }
            nuevoNodo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevoNodo);
        }
    }
    
    
    
    

    public String MostrarUsuarioV() {
        String r = "";
        NodoUsuario aux = cabeza;

        while (aux != null) {
            if (aux.getUsuario().getContadorV() != 0) {
                r += aux.getUsuario().getNombre() + aux.getUsuario().getContadorV() + "\n";
     
            }
        }
         aux = aux.getSiguiente();
            return r;
        }
    
     

    public String MostrarUsuarioR() {
        String usuarios = "";
        NodoUsuario aux = cabeza;

        while (aux.getUsuario().getContadorR() != 0) {
            usuarios += aux.getUsuario().getNombre() + aux.getUsuario().getContadorR() + "\n";
            aux = aux.getSiguiente();
        }

        return usuarios;
    }

    public void buscarVendedorR(String vendedor) {
        NodoUsuario aux = cabeza;
        boolean bandera = false;// para saber si lo encontramos

        while (aux != null) {
            if (vendedor.equals(aux.getUsuario().nombre)) { //lo busca si lo encuentra muestra los datos

                bandera = true; //lo encontro
                aux.getUsuario().setContadorR(+1);
                break;
            }
            aux = aux.getSiguiente();

            if (!bandera) { //si no lo encuentra
                JOptionPane.showMessageDialog(null, "Usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void buscarVendedorV(String vendedor) {
        NodoUsuario aux = cabeza;
        boolean bandera = false;// para saber si lo encontramos

        while (aux != null) {
            if (vendedor.equals(aux.getUsuario().nombre)) { //lo busca si lo encuentra muestra los datos

                bandera = true; //lo encontro
                aux.getUsuario().setContadorV(+1);
                break;
            }
            aux = aux.getSiguiente();

            if (!bandera) { //si no lo encuentra
                JOptionPane.showMessageDialog(null, "Usuario", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
