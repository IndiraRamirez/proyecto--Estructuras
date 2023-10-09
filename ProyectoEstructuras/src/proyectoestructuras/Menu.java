/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;

import javax.swing.JOptionPane;
import static proyectoestructuras.ManejoArchivos.manejoArchivos.archivar;

/**
 *
 * @author indir
 */
public class Menu {
//Customer c= new Customer("",0,0,0,"");
     public void Menu_UsuarioGlobal(){
        int opcion;
       
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Seleccione una opción:
                    1.Crear usuario
                    2.Crear vehiculos
                    3.Ver Usuarios
                    4.Ver lista cliente
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
                }case 0 ->{
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                     break; 
                }default ->
                    JOptionPane.showMessageDialog(null, "Opción inválida. "
                            + "Por favor, seleccione nuevamente.");}
        
    }
    
    public void Menu_Empleado(){
        
          int opcion;
       
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Seleccione una opción:
                    1.Actualizar estado de vehiculos
                    2.Ver lista vehiculos
                    3.Crear lista cliente
                    4.Busca Cliente
                    5.Consultar garantia vehiculo
                    6.Buscar vehiculo
                    7.Informacion 
                    0.Salir del sistema
                    """)
            );
               
            switch (opcion) {
                case 1 -> { 
                    
                    
                }case 2 -> {
                    
                }case 3 -> {//crear clienteCliente cliente = new Cliente();
                   Cliente cliente=new Cliente();
                   Customer c=cliente.CrearCliente();
                   JOptionPane.showMessageDialog(null,c.toString());
                    archivar("Clientes.txt",c.toString());
                }case 4 ->{
                }case 5 ->{
                }case 6 ->{
                }case 7 ->{
                }case 0 ->{
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                     break; 
            }default ->
                    JOptionPane.showMessageDialog(null, "Opción inválida. "
                            + "Por favor, seleccione nuevamente.");}
         
    
    }
} 
    

