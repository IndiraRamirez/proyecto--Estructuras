package proyectoestructuras;

import java.io.*;

import proyectoestructuras.Vehiculo.EstadoVehiculo;

public class ListaDeVehiculos {
    private NodoVehiculo cabeza;
    private NodoVehiculo ultimo;
    private int size;
    private final String NOMBRE_ARCHIVO = "ListaVehiculo.txt";

    public ListaDeVehiculos() {
        cabeza = null;
        ultimo = null;
        size = 0;
    }

    public void limpiarLista() {
        cabeza = null;
        ultimo = null;
        size = 0;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        NodoVehiculo nuevoNodo = new NodoVehiculo(vehiculo);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
        size++;
    }

    //public String listarVehiculos() {
      //  StringBuilder sb = new StringBuilder();
        //NodoVehiculo aux = cabeza;
        //while (aux != null) {
          //  sb.append(aux.getVehiculo().toString()).append("\n");
          //  aux = aux.getSiguiente();
        //}
        //return sb.toString();
   //q }
   public String listarVehiculos() {
    if (cabeza == null) {
        return "No hay vehículos registrados.\n";
    }

    String resultado = "";
    // Aquí se agrega un encabezado para las columnas si deseas un formato de tabla
    resultado += String.format("%-10s %-15s %-10s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s\n",
            "Marca", "Modelo", "Color", "Año", "Cilindraje", "Kilometraje", "Tipo", "Características", "Estado", "Cliente", "Vendedor");
    resultado += "---------------------------------------------------------------------------------------------------------------\n";

    NodoVehiculo actual = cabeza;
    while (actual != null) {
        Vehiculo vehiculo = actual.getVehiculo();
        resultado += String.format("%-10s %-15s %-10s %-10d %-10d %-10.2f %-15s %-10s %-15s %-15s %-15s\n",
                vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getColor(), vehiculo.getAnio(),
                vehiculo.getCilindraje(), vehiculo.getKilometraje(), vehiculo.getTipo(),
                vehiculo.getCaracteristicas(), vehiculo.getEstado(), vehiculo.getCliente(), vehiculo.getVendedor());
        actual = actual.getSiguiente();
    }

    return resultado;
    }

    public void cargarDesdeArchivo() {
        File archivo = new File(NOMBRE_ARCHIVO);
        if (!archivo.exists()) {
            System.out.println("El archivo no existe: " + NOMBRE_ARCHIVO);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            limpiarLista(); // Limpia la lista antes de cargar nuevos datos
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    Vehiculo vehiculo = convertirLineaAVehiculo(linea);
                    agregarVehiculo(vehiculo);
                } catch (Exception e) {
                    System.out.println("Error al convertir datos a Vehiculo: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
  
    
    public void guardarEnArchivo() {
        try {
            File file = new File(NOMBRE_ARCHIVO);
    
            // Asegurarse de que el archivo exista antes de intentar escribir en él.
            if (!file.exists()) {
                file.createNewFile();
            }
    
            // Sobrescribe el archivo con la lista actual de vehículos.
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
                NodoVehiculo actual = cabeza;
                while (actual != null) {
                    // Escribe cada vehículo en una nueva línea.
                    bw.write(actual.getVehiculo().toString());
                    bw.newLine(); // Asegúrate de añadir un salto de línea al final de cada vehículo.
                    actual = actual.getSiguiente();
                }
            }
            System.out.println("Datos guardados exitosamente en " + NOMBRE_ARCHIVO);
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo: " + e.getMessage());
        }
    } 

    private Vehiculo convertirLineaAVehiculo(String linea) throws Exception {
        String[] datos = linea.split(",");
        if (datos.length != 11) {
            throw new Exception("Datos de vehículo incompletos o en formato incorrecto: " + linea);
        }
        
        try {
            String marca = obtenerDato(datos[0]);
            String modelo = obtenerDato(datos[1]);
            String color = obtenerDato(datos[2]);
            int anio = Integer.parseInt(obtenerDato(datos[3]));
            int cilindraje = Integer.parseInt(obtenerDato(datos[4]));
            double kilometraje = Double.parseDouble(obtenerDato(datos[5]));
            Vehiculo.TipoVehiculo tipo = Vehiculo.TipoVehiculo.valueOf(obtenerDato(datos[6]).toUpperCase());
            String caracteristicas = obtenerDato(datos[7]);
            Vehiculo.EstadoVehiculo estado = Vehiculo.EstadoVehiculo.valueOf(obtenerDato(datos[8]).toUpperCase());
            String cliente = obtenerDato(datos[9]);
            String vendedor = datos.length > 10 ? obtenerDato(datos[10]) : "";
    
            return new Vehiculo(marca, modelo, color, anio, cilindraje, kilometraje, tipo, caracteristicas, estado, cliente, vendedor);
        } catch (NumberFormatException e) {
            throw new Exception("Error en el formato numérico: " + e.getMessage() + " en la línea: " + linea);
        } catch (IllegalArgumentException e) {
            throw new Exception("Error en el valor de enumeración: " + e.getMessage() + " en la línea: " + linea);
        }
    }
    
    private String obtenerDato(String dato) {
        String[] partes = dato.split(":", 2);
        if (partes.length == 2) {
            return partes[1].trim();
        } else {
            throw new IllegalArgumentException("Dato incompleto o en formato incorrecto: " + dato);
        }
    }
     
    @Override
    public String toString() {
        return listarVehiculos();
    }
    // Método para actualizar el estado del vehículo
    public boolean actualizarVehiculo(String modelo, EstadoVehiculo nuevoEstado, String cliente, String vendedor) {
        NodoVehiculo actual = cabeza;
        while (actual != null) {
            Vehiculo vehiculo = actual.getVehiculo();
            if (vehiculo.getModelo().equals(modelo)) {
                // No permitir la actualización si el vehículo ya ha sido vendido
                if (vehiculo.getEstado() == Vehiculo.EstadoVehiculo.VENDIDO) {
                    System.out.println("El vehículo ya ha sido vendido y no puede ser modificado.");
                    return false;
                }

                // Actualizar estado, cliente y vendedor
                vehiculo.setEstado(nuevoEstado);
                if (nuevoEstado != Vehiculo.EstadoVehiculo.DISPONIBLE) {
                    vehiculo.setCliente(cliente);
                    vehiculo.setVendedor(vendedor);
                } else {
                    // Si el vehículo vuelve a estar disponible, eliminar cliente y vendedor
                    vehiculo.setCliente(null);
                    vehiculo.setVendedor(null);
                }

                // Suponiendo que tienes un método para guardar la lista de vehículos en un archivo
                guardarEnArchivo();
                return true;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Vehículo no encontrado.");
        return false;
    }

    public String[] getModelosVehiculos() {
        if (cabeza == null) {
            System.out.println("La lista de vehículos está vacía.");
            return new String[0];
        }
    
        // Contamos la cantidad de nodos/vehículos en la lista
        int contador = 0;
        NodoVehiculo actual = cabeza;
        while (actual != null) {
            System.out.println("Modelo encontrado: " + actual.getVehiculo().getModelo());
            contador++;
            actual = actual.getSiguiente();
        }
    
        if (contador == 0) {
            System.out.println("Contador de modelos es 0 después de recorrer la lista.");
            return new String[0];
        }

        // Creamos el arreglo con el tamaño contado
        String[] modelos = new String[contador];
        int i = 0;
        actual = cabeza; // Reiniciamos el nodo actual a la cabeza para volver a recorrer la lista
        while (actual != null) {
            modelos[i] = actual.getVehiculo().getModelo();
            actual = actual.getSiguiente();
            i++;
        }

        return modelos;
    }
}