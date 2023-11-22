/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoestructuras;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author indir
 * @author Jeffry 22/11/03
 *
 * 
 */
public class ProyectoEstructuras {

    public static void main(String[] args) throws IOException {
        Menu m = new Menu();
        Configuracion conf = new Configuracion();
        ManejoArchivos logins = new ManejoArchivos();

        String[] opcionesM = {"Iniciar sesion Master", "Iniciar sesion empleado", "Informacion", "Salir"};
        m.Cargar();
        int comprobarAR = logins.ComprobarAR();
        if (comprobarAR == 2) {
            JOptionPane.showMessageDialog(null, "Agregue un usuario master");
            String nombre = JOptionPane.showInputDialog("Escriba un correo");
            String contra = JOptionPane.showInputDialog("Escriba una contrasenna");
            logins.AgregarUM(nombre, contra);
        }

        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesM, opcionesM[3]);
            switch (opcion) {
                case 0:
                    String nombreINI = JOptionPane.showInputDialog("Escriba el correo para iniciar sesion");
                    String contraINI = JOptionPane.showInputDialog("Escriba la contrasenna");
                    boolean comprobar = logins.ComprobarMASTER(nombreINI, contraINI);
                    if (comprobar) {
                        m.Menu_UsuarioGlobal();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro el usuario");
                    }
                    break;
                case 1:
                    nombreINI = JOptionPane.showInputDialog("Escriba el correo para iniciar sesion");
                    contraINI = JOptionPane.showInputDialog("Escriba la contrasenna");
                    comprobar = logins.ComprobarEMPLEADO(nombreINI, contraINI);
                    if (comprobar) {
                        m.Menu_Empleado();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontro el usuario");
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, conf.toString(), "Información de la Empresa", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Cerrando sistema");
                    m.Guardar();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, seleccione nuevamente.");
                    break;
            }
        } while (opcion != 3);
    }
}

