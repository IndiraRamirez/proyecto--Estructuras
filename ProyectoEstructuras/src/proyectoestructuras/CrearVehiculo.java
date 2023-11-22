package proyectoestructuras;

import javax.swing.JOptionPane;

public class CrearVehiculo {

    public static Vehiculo crearNuevoVehiculo() {
        String marca = JOptionPane.showInputDialog("Escribe la marca del vehículo");
        String modelo = JOptionPane.showInputDialog("Escribe el modelo del vehículo");
        String color = JOptionPane.showInputDialog("Escribe el color del vehículo");
        int anio = Integer.parseInt(JOptionPane.showInputDialog("Escribe el año del vehículo"));

        // Solicitar cilindraje y kilometraje
        int cilindraje = Integer.parseInt(JOptionPane.showInputDialog("Escribe el cilindraje del vehículo"));
        double kilometraje = Double.parseDouble(JOptionPane.showInputDialog("Escribe el kilometraje del vehículo"));

        Vehiculo.TipoVehiculo tipo = null;
        Vehiculo.EstadoVehiculo estado = Vehiculo.EstadoVehiculo.DISPONIBLE; // Estado inicial
        String caracteristicas = JOptionPane.showInputDialog("Escribe las características del vehículo");

        // Asegúrate de que el usuario seleccione un tipo de vehículo
        while (tipo == null) {
            Object seleccion = JOptionPane.showInputDialog(
                null,
                "Selecciona el tipo de vehículo",
                "Tipo de Vehículo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Vehiculo.TipoVehiculo.values(),
                Vehiculo.TipoVehiculo.values()[0]
            );

            if (seleccion != null) {
                try {
                    String seleccionStr = seleccion.toString();
                    tipo = Vehiculo.TipoVehiculo.valueOf(seleccionStr.toUpperCase());
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un tipo de vehículo válido.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se seleccionó ningún tipo de vehículo.");
                break; // Salir del bucle si el usuario cancela
            }
        }

        // Crear el vehículo usando el constructor con todos los parámetros
        Vehiculo nuevoVehiculo = new Vehiculo(marca, modelo, color, anio, cilindraje, kilometraje, tipo, caracteristicas, estado, "", "");

        return nuevoVehiculo;
    }
}




