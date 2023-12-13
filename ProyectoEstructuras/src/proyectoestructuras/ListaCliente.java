/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;

import javax.swing.JOptionPane;
import static proyectoestructuras.Menu.cantidadCl;
import static proyectoestructuras.Menu.cantidadCompraron;
import static proyectoestructuras.Menu.cantidadReservado;

/**
 *
 * @author indir
 */
public class ListaCliente {

    ManejoArchivos m = new ManejoArchivos();
    private NodoCliente cabeza;

    public ListaCliente() {
        cabeza = null;
    }

    public NodoCliente getCabeza() {
        return cabeza;
    }

    public int ContarClientes() {
        cantidadCl += 1;
        return cantidadCl;
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

    Customer p = new Customer();

    // Muestra lista
    public void mostrarPersonas() {
        NodoCliente aux = cabeza;
        while (aux != null) {
            System.out.println(aux.getPersona());
            aux = aux.getSiguiente();
        }
    }

    //permite modificar todos los datos exepto la id
    public void modificar() {
        String nuevo_correo = "";
        NodoCliente aux = cabeza;
        boolean bandera = false;
        int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id del cliente"));
        while (aux != null) {
            if (aux.getPersona().getId() == buscar) { //buscamos a  la persona , si la encontramos solicita los datos nuevamente
                String nuevo_nombre = JOptionPane.showInputDialog("Ingrese el nombre : ");
                aux.getPersona().setNombre(nuevo_nombre);
                String nuevo_apellido = JOptionPane.showInputDialog("Ingrese su apellido: ");
                aux.getPersona().setApellido(nuevo_apellido);
                int nueva_edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad  :"));
                aux.getPersona().setEdad(nueva_edad);
                int nuevo_numeroTel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero telefono:"));
                aux.getPersona().setNumeroTel(nuevo_numeroTel);
                nuevo_correo = JOptionPane.showInputDialog("Ingrese su correo : ");
                aux.getPersona().setCorreo(nuevo_correo);
                bandera = true;//si lo encontramos
            }
            aux = aux.getSiguiente();
        }
        if (bandera != true) {   // si no se encuentra
            JOptionPane.showMessageDialog(null, "Id no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public boolean compararId(int id) {
        NodoCliente aux = cabeza;
        boolean bandera = false;// existe un cliente con ese id?
        while (aux != null) {
            if (aux.getPersona().getId() == id) { //lo busca
                JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese id");
                bandera = true;//la condicion cambia
                return bandera;
            }
            aux = aux.getSiguiente();
        }
        return bandera;//si no existe la condicion es falsa
    }

    public void buscar() {
        NodoCliente aux = cabeza;
        boolean bandera = false;// para saber si lo encontramos
        int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el Id del cliente"));
        while (aux != null) {
            if (aux.getPersona().getId() == buscar) { //lo busca si lo encuentra muestra los datos
                JOptionPane.showMessageDialog(null, "ID: " + aux.getPersona().getId()
                        + "\nNombre: " + aux.getPersona().getNombre()
                        + "\nApellido: " + aux.getPersona().getApellido()
                        + "\nEdad: " + aux.getPersona().getEdad()
                        + "\nApellido: " + aux.getPersona().getApellido()
                        + "\nNumero Telefono: " + aux.getPersona().getNumeroTel()
                        + "\nCorreo: " + aux.getPersona().getCorreo());
                bandera = true; //lo encontro
            }
            aux = aux.getSiguiente();
        }
        if (bandera != true) { //si no lo encuentra
            JOptionPane.showMessageDialog(null, "Id no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    //////////////////reportes------------------------------------------------------------------------------------------------------

   
    
    //1.
    public int calcularCantidadReservado() {
        NodoCliente actual = cabeza;
        cantidadReservado = 0;
        while (actual != null) {
            if (actual.getPersona().isReservado()) {
                cantidadReservado++;
            }
            actual = actual.getSiguiente();
        }
        return cantidadReservado;
    }
    public void buscarClienteR(int id) {
        NodoCliente auxiliar = cabeza;
        boolean cambio = false;// para saber si lo encontramos
        while (auxiliar != null) {
            if (auxiliar.getPersona().getId() == id) { //lo busca si lo encuentra muestra los datos
                cambio = true; //lo encontro
                auxiliar.getPersona().setReservado(true);
                break;
            }
            auxiliar = auxiliar.getSiguiente();
        }
        if (!cambio) { //si no lo encuentra
            JOptionPane.showMessageDialog(null, "Id no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    ///2
     public int calcularCantidadComprado() {

        NodoCliente actual = cabeza;
        cantidadCompraron = 0;
        while (actual != null) {
            if (actual.getPersona().comprado()) {
                cantidadCompraron++;
            }
            actual = actual.getSiguiente();
        }
        return cantidadCompraron;
    }

    public void buscarClienteV(int id) {
        NodoCliente aux = cabeza;
        boolean cambio = false;// para saber si lo encontramos

        while (aux != null) {
            if (aux.getPersona().getId() == id) { //lo busca si lo encuentra muestra los datos
                cambio = true; //lo encontro
                aux.getPersona().setComprado(true);
                aux.getPersona().setCantidadV(aux.getPersona().getCantidadV() + 1);
                break;
            }
            aux = aux.getSiguiente();
        }
        if (!cambio) { //si no lo encuentra
            JOptionPane.showMessageDialog(null, "Id no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //3
    
   public String getMayor(){
        NodoCliente aux = cabeza;
        Customer primero = null;
        Customer segundo = null;
        Customer tercero = null;
        int cantidad = 0;
        while (aux != null) {
            if (aux.getPersona().getCantidadV()>cantidad) { 
                cantidad = aux.getPersona().getCantidadV();
                primero = aux.getPersona();
            }
            aux = aux.getSiguiente();
            }
        if(primero==null){
            return "No se encontro ningun usuario";
        }
        cantidad = 0;
        aux = cabeza;
        while (aux != null) {
            if (aux.getPersona().getCantidadV()>cantidad && aux.getPersona().getCantidadV()<=primero.getCantidadV() && !aux.getPersona().getNombre().equals(primero.getNombre())) { 
                cantidad = aux.getPersona().getCantidadV();
                segundo = aux.getPersona();
            }
            aux = aux.getSiguiente();
            }
        if(segundo==null){
            return "Top 3 de clientes que mas vehiculos han comprado:\n1. "+primero.getNombre()+": "+primero.getCantidadV();
        }
        cantidad = 0;
        aux = cabeza;
        while (aux != null) {
            if ((aux.getPersona().getCantidadV()>cantidad && aux.getPersona().getCantidadV()<=primero.getCantidadV() && !aux.getPersona().getNombre().equals(primero.getNombre())) && aux.getPersona().getCantidadV()>cantidad && aux.getPersona().getCantidadV()<=segundo.getCantidadV() && !aux.getPersona().getNombre().equals(segundo.getNombre())) { 
                cantidad = aux.getPersona().getCantidadV();
                tercero = aux.getPersona();
            }
            aux = aux.getSiguiente();
            }
        
        if(tercero==null){
            return "Top 3 de clientes que mas vehiculos han comprado:\n1. "+primero.getNombre()+": "+primero.getCantidadV()
                    +"\n2. "+segundo.getNombre()+": "+segundo.getCantidadV();
        }else{
            return "Top 3 de clientes que mas vehiculos han comprado:\n1. "+primero.getNombre()+": "+primero.getCantidadV()
                    +"\n2. "+segundo.getNombre()+": "+segundo.getCantidadV()
                    +"\n3. "+tercero.getNombre()+": "+tercero.getCantidadV();
        }
    }
}

