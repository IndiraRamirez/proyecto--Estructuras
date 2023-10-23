/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;

import javax.swing.JOptionPane;


/**
 *
 * @author indir
 */
public class Menu {
    Customer p= new Customer();
        ListaCliente lista = new ListaCliente();
    Configuracion conf=new Configuracion();
     public void Menu_UsuarioGlobal(){
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Seleccione una opción:
                    1.Crear usuario
                    2.Crear vehiculos
                    3.Ver Usuarios
                    4.Gestion de clientes
                    5.Eliminar usuario
                    6.Consultar reportes
                    7.Informacion 
                    0.Salir del sistema
                    """)
            );
               
            switch (opcion) {
                case 1 -> { 
                }case 2 ->{ 
                }case 3 ->{
                }case 4 ->{
                    StringBuilder sb = new StringBuilder();
                            NodoCliente aux = lista.getCabeza();
                            while (aux != null) {
                                sb.append(aux.getPersona()).append("\n");
                                aux = aux.getSiguiente();
                            }
                            JOptionPane.showMessageDialog(null, sb.toString() , "Lista de Clientes", JOptionPane.DEFAULT_OPTION);
                            break;
                }case 5 ->{
                }case 6 ->{
                    JOptionPane.showMessageDialog(null, " A continuacion"
                             + " se le presentaran los reportes: ");
                    int opcionR = Integer.parseInt(JOptionPane.showInputDialog("""
                       Seleccione una opcion:
                       1.Cantidad total de autos venditos, reservados y disponibles
                       2.Cantidad de clientes registrados, clientes que compraron un vehículo, clientes que reservaron un 
                       vehículo.
                       3.Top 3 de clientes que más compraron vehículos
                       4.Cantidad de vehículos vendidos por vendedor
                       5.Cantidad de vehículos reservados por vendedor"""));
                       switch (opcionR) {
                            case 1->{
                           }case 2->{
                           }case 3->{
                           }case 4->{   
                           }case 5->{ 
                           }case 0->{ 
                                break;
                           }default->
                                JOptionPane.showMessageDialog(null, "Opción inválida. "
                                + "Por favor, seleccione nuevamente.");
                        }     
                }case 7 ->{
                     JOptionPane.showMessageDialog(null,  conf.toString(), "Información de la Empresa", JOptionPane.INFORMATION_MESSAGE);
                }case 0 ->{
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                     break; 
                }default ->
                    JOptionPane.showMessageDialog(null, "Opción inválida. "
                            + "Por favor, seleccione nuevamente.");}
        }while (opcion != 0);   
    }
     Customer c= new Customer();
    public void Menu_Empleado(){
        
          int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Seleccione una opción:
                    1.Actualizar estado de vehiculos
                    2.Ver lista vehiculos
                    3.Crear lista cliente      
                    4.Ver lista cliente         
                    5.Consultar garantia vehiculo
                    6.Buscar vehiculo
                    7.Informacion              
                    0.Salir del sistema
                    """)
            );
            
           
            switch (opcion) {
                case 1 -> { 
                    
                    
                }case 2 -> {
                    
                }case 3 -> {
                    //El programa debe permitir la creación de clientes.
                  String correo="";
                   String nombre = JOptionPane.showInputDialog("Ingrese el nombre : ");
                    String apellido = JOptionPane.showInputDialog("Ingrese su apellido: ");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad  :"));
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de identificacion :"));
                    if (lista.compararId(id)) {
                        break;
                    } else {
                    int numeroTel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero telefono:"));
                    correo=p.correoDado(correo);
                    lista.agregarPersonaOrdenado(new Customer(nombre,apellido,edad,id,numeroTel,correo));
                    break;
                    }
                    
                }case 4 ->{
                    //El programa debe permitir la  lectura y actualización de clientes. listo
                    //El programa no debe permitir registrar dos clientes con la misma identificación. *****falta****
                    int op;
                    do {
                        op=Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                                    Seleccione una opcion:
                                                                                    1.Buscar Cliente
                                                                                    2.Ver lista de clientes
                                                                                    3.Modificar 
                                                                                    0.Salir del sistema""", "Clientes", JOptionPane.QUESTION_MESSAGE));
                        
                        
                        switch (op) {
                        case 1 -> { 
                            
                            lista.buscar();
                        }case 2 -> {
                            StringBuilder sb = new StringBuilder();
                            NodoCliente aux = lista.getCabeza();
                            while (aux != null) {
                                sb.append(aux.getPersona()).append("\n");
                                aux = aux.getSiguiente();
                            }
                            JOptionPane.showMessageDialog(null, sb.toString() , "Lista de Clientes", JOptionPane.DEFAULT_OPTION);
                            break;
                        }case 3 -> {
                            lista.modificar();
                        }case 4 ->{
                             break;
                       }
                       }
                    }while(op!=0);
                }case 5 ->{
                }case 6 ->{
                }case 7 ->{
                     JOptionPane.showMessageDialog(null,  conf.toString(), "Información de la Empresa", JOptionPane.INFORMATION_MESSAGE);
                }case 0 ->{
                    JOptionPane.showMessageDialog(null,  "¡Cerrando sistema!", "Cerrando", JOptionPane.INFORMATION_MESSAGE);
                    
                     break; 
            }default ->
                    JOptionPane.showMessageDialog(null,  "Opción inválida. "
                            + "Por favor, seleccione nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }while (opcion != 0);   
    }

} 