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
    /**,,,,,,,,,,,,,,,,,,,,,,,,,
    public void Menu_Inicial(){
       int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Seleccione una opción:
                    1.Iniciar sesion Master
                    2.Iniciar sesion empleado
                    3.Informacion
                    0.Salir del sistema
                    """)
            );
               
            switch (opcion) {
                case 1 -> { 
                    JOptionPane.showMessageDialog(null, "Iniciar sesion master");
                
                }case 2 ->{ 
                    JOptionPane.showMessageDialog(null, "Iniciar sesion empleado");

                }case 3 ->{ 
                    JOptionPane.showMessageDialog(null, "Se muestra la informacion");
                }case 0 ->{ 
                    JOptionPane.showMessageDialog(null, "Adios");
                    break;
                }default ->
                    JOptionPane.showMessageDialog(null, "Opción inválida. "
                            + "Por favor, seleccione nuevamente.");}
        }while (opcion != 0);   
    }
    **/
         
    
    
    
     public void Menu_UsuarioGlobal(){
        int opcion;
        do {
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
        }while (opcion != 0);   
    }

    
    public void Menu_Empleado(){
          int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Seleccione una opción:
                    1. Actualizar estado de vehiculos
                    2.Ver lista vehiculos
                    3.Crear lista cliente
                    4.Busca Cliente
                    5.Consultar garantia vehiculo
                    6.buscar vehiculo
                    7.Informacion 
                    0.Salir del sistema
                    """)
            );
               
            switch (opcion) {
                case 1 -> { 
                    
                    break;
                }case 2 -> {
                    
                }case 3 -> {
                   
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
        }while (opcion != 0);   
    }

} 
    

