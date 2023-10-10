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
///Como estas?
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Menu m = new Menu();
         Configuracion conf= new Configuracion();
         ///Holaaaa
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
                     m.Menu_UsuarioGlobal();
                }case 2 ->{ 
                    JOptionPane.showMessageDialog(null, "Iniciar sesion empleado");
                    m.Menu_Empleado();
                }case 3 ->{ 
                    JOptionPane.showMessageDialog(null, "Se muestra la informacion");
                    JOptionPane.showMessageDialog(null,  conf.toString(), "Información de la Empresa", JOptionPane.INFORMATION_MESSAGE);
                   
                }case 0 ->{ 
                    JOptionPane.showMessageDialog(null, "Cerrando sistema");
                    break;
                }default ->
                    JOptionPane.showMessageDialog(null, "Opción inválida. "
                            + "Por favor, seleccione nuevamente.");}
        }while (opcion != 0);   
    }
    }
    

