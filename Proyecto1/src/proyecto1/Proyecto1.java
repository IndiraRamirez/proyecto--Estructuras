/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

import javax.swing.JOptionPane;

/**
 *
 * @author indir
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Seleccione una opción:
                    1. Crear Usuario                                         
                    2. Crear Vehiculo 
                    3. Actualizar estado de vehículos                                            
                    4. Ver listado de vehículos disponibles
                    5. Crear clientes
                    6.Ver listado de clientes
                    7.Consultar garantías de vehículos 
                    8.Consultar reportes
                    0.Salir
                    """)
            );
                
            switch (opcion) {
                case 1 -> { 
                    //crear usuario
                }case 2 -> {
                    
                    //crear vehiculo
                  
                }case 3 -> {
                   //actualizar estado
                }case 4 -> {
                    //ver lista de vehiculos
                }case 5 -> {
                    //Crear clientes
                }case 6 -> {
                      //Ver lista de clientes     
                }case 7 -> {
                    //ver garantias  
                }case 8 ->{
                     JOptionPane.showMessageDialog(null, " A continuacion"
                             + " se le presentaran los reportes: ");
                 int opcionR = Integer.parseInt(JOptionPane.showInputDialog("""
                    Seleccione una opcion:                                         
                    1.  Cantidad total de autos vendidos, reservados y disponibles
                    2.  Cantidad de clientes registrados, clientes que compraron un vehículo, clientes que reservaron un 
                        vehículo
                    3. Top 3 de clientes que más compraron vehículos
                    4. Cantidad de vehículos vendidos por vendedor
                    5. Cantidad de vehículos reservados por vendedor                                                      
                    6.Salir"""));
                    switch (opcionR) {
                        case 1 -> {
                            
                        }case 2->{
                            
                        }case 3 ->{
                            
                        }case 4 -> {   
                           
                        }case 5 -> {
                            //
                         
                        }case 6->{
                        break;}
                    }     
            }case 0 ->{
               JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                       break; 
            }default ->
                    JOptionPane.showMessageDialog(null, "Opción inválida. "
                            + "Por favor, seleccione nuevamente.");}
        }while (opcion != 6);   
    }
}    