/*
  Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;

import javax.swing.JOptionPane;

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
         NodoCliente aux = cabeza;
        if (cabeza == null || cabeza.getPersona().getId() > persona.getId()) {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        } else {
        while (aux.getSiguiente() != null && aux.getSiguiente().getPersona().getId() < persona.getId()) {
                aux = aux.getSiguiente();
            }
            nuevoNodo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevoNodo);
            }
             
        }
        
    Customer p= new Customer();

    // Muestra lista
    public void mostrarPersonas() {
        NodoCliente aux = cabeza;
        while (aux != null) {
            System.out.println(aux.getPersona());
            aux = aux.getSiguiente();
        }
    }
    
    //permite modificar todos los datos exepto la id
    public void modificar(){         
        String nuevo_correo="";
        NodoCliente aux = cabeza;
        boolean bandera=false;
        int buscar=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id del cliente"));
        while(aux!=null){
            if(aux.getPersona().getId()==buscar){ //buscamos a  la persona , si la encontramos solicita los datos nuevamente
                String nuevo_nombre = JOptionPane.showInputDialog("Ingrese el nombre : ");
                aux.getPersona().setNombre(nuevo_nombre);  
                String nuevo_apellido = JOptionPane.showInputDialog("Ingrese su apellido: ");
                aux.getPersona().setApellido(nuevo_apellido); 
                int nueva_edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad  :"));
                aux.getPersona().setEdad(nueva_edad);
                int nuevo_numeroTel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero telefono:"));
                aux.getPersona().setNumeroTel(nuevo_numeroTel);
                nuevo_correo=JOptionPane.showInputDialog("Ingrese su correo : ");
                aux.getPersona().setCorreo(nuevo_correo);
                bandera=true;//si lo encontramos
            }
            aux=aux.getSiguiente();
        }
        if (bandera!=true){   // si no se encuentra
            JOptionPane.showMessageDialog(null,  "Id no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
       
    }
    
    public void buscar() {
    NodoCliente aux = cabeza;
    boolean bandera=false;// para saber si lo encontramos
         int buscar=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id del cliente"));
        while(aux!=null){
            if(aux.getPersona().getId()==buscar){ //lo busca si lo encuentra muestra los datos
                JOptionPane.showMessageDialog(null, "ID: " + aux.getPersona().getId() +
                        "\nNombre: " + aux.getPersona().getNombre() +
                        "\nApellido: "+aux.getPersona().getApellido() +
                        "\nEdad: "+aux.getPersona().getEdad() +
                        "\nApellido: "+aux.getPersona().getApellido() +
                        "\nNumero Telefono: "+aux.getPersona().getNumeroTel()+
                        "\nCorreo: "+aux.getPersona().getCorreo()) ;
                bandera=true; //lo encontro
            }
            aux=aux.getSiguiente();
        }
        if(bandera!=true){ //si no lo encuentra
         JOptionPane.showMessageDialog(null,  "Id no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }    
    }

}
    
    



