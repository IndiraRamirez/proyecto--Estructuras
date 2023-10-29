package proyectoestructuras;

/**
 *
 * @author JeffryCH
 */
import javax.swing.JOptionPane;


public class CrearVehiculo {

    public static Vehiculo crearNuevoVehiculo() {
        // Solicitar la información del vehículo al usuario
        String color = JOptionPane.showInputDialog("Ingrese el color del vehículo:");
        int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año del vehículo:"));
        int cilindraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el cilindraje del vehículo:"));
        String marca = JOptionPane.showInputDialog("Ingrese la marca del vehículo:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");
        double kilometraje = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el kilometraje del vehículo:"));
        Vehiculo.TipoVehiculo tipo = Vehiculo.TipoVehiculo.valueOf(JOptionPane.showInputDialog("Ingrese el tipo de vehículo (SUV, SEDAN, HATCHBACK):").toUpperCase());
        String caracteristicas = JOptionPane.showInputDialog("Ingrese las características del vehículo:");

        // Crear un objeto Vehiculo con la información proporcionada
        Vehiculo nuevoVehiculo = new Vehiculo(color, anio, cilindraje, marca, modelo, kilometraje, tipo, caracteristicas);
        
        return nuevoVehiculo;
    }

    public static void main(String[] args) {
        Vehiculo vehiculo = crearNuevoVehiculo();
        JOptionPane.showMessageDialog(null, "Vehículo creado exitosamente:\n" + vehiculo.toString());
    }
}
