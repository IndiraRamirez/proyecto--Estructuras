/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoestructuras;

import javax.swing.JOptionPane;

/**
 *
 * @author indir
 */
public class ProyectoEstructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         
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
    }
    

