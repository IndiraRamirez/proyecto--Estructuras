package proyectoestructuras;

import java.io.*;
import javax.swing.JOptionPane;

public class ManejoArchivos {

    private final String nombreARmaster = "LoginMaestro.txt";
    private final String nombreARempleado = "LoginEmpleado.txt";
    private final String nombreARClientes = "ListaClientes.txt";
    private final File ARmaster = new File(nombreARmaster);
    private final File ARempleado = new File(nombreARempleado);
    private final File ARcliente = new File(nombreARClientes);
    private final String nombreARvehiculo = "ListaVehiculo.txt";
    private final File ARvehiculo = new File(nombreARvehiculo);

    Customer c = new Customer();

    ///////////////////////////////////////////////////
    public void eliminarEmpleado(String nombre) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ARempleado));
        StringBuilder datosArchivo = new StringBuilder();
        String linea;
        boolean clienteEncontrado = false;
        String eliminar_nombre = "Correo:" + nombre;

        linea = br.readLine();
        while (linea != null) {
            if (linea.equals(eliminar_nombre)) {
                clienteEncontrado = true;
                linea = br.readLine();
                while (!(linea.contains("Correo"))) {
                    linea = br.readLine();
                    if (linea == null) {
                        break;
                    }
                    if (linea.contains("Correo")) {
                        datosArchivo.append(linea).append("\n");
                    }
                }
            } else {
                datosArchivo.append(linea).append("\n");
            }
            linea = br.readLine();
        }
        br.close();
        if (clienteEncontrado) {
            try {
                BufferedWriter escribir = new BufferedWriter(new FileWriter(ARempleado));
                escribir.write(datosArchivo.toString());
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
                escribir.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al escribir en el archivo: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado en la base de datos.");
        }
    }

    public void mostrarUsuarios() {
        StringBuilder usuarios = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(ARempleado));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("Correo:")) {
                    usuarios.append(linea);
                    usuarios.append("\n");
                }
            }
            if (usuarios.equals(null)) {
                JOptionPane.showMessageDialog(null, "El archivo no tiene usuarios");
            } else {
                JOptionPane.showMessageDialog(null, usuarios.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al leer el archivo");
        }
    }

    public boolean ComprobarEMPLEADO(String nombre, String contra) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(ARempleado));
        String linea;
        String comprobarNB = "Correo:" + nombre;
        String comprobarCT = "Contrasenna:" + contra;
        while ((linea = br.readLine()) != null) {
            if (linea.equals(comprobarNB)) {
                linea = br.readLine();
                if (linea.equals(comprobarCT)) {
                    br.close();
                    return true;
                }
            }
        }
        br.close();
        return false;
    }

    public void AgregarUM(String nombre, String contra) throws IOException {
        String datosArchivo = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(ARmaster));
            String linea;
            while ((linea = br.readLine()) != null) {
                datosArchivo += linea;
                datosArchivo += "\n";
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
        }

        String datosClienteNuevo = "Correo:" + nombre + "\nContrasenna:" + contra + "\n\n";
        datosArchivo += datosClienteNuevo;
        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter(ARmaster));
            escribir.write(datosArchivo);
            JOptionPane.showMessageDialog(null, "Usuario agregado!");
            escribir.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void AgregarUE(String nombre, String contra) throws IOException {
        String datosArchivo = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(ARempleado));
            String linea;
            while ((linea = br.readLine()) != null) {
                datosArchivo += linea;
                datosArchivo += "\n";
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
        }

        String datosClienteNuevo = "Correo:" + nombre + "\nContrasenna:" + contra + "\n\n";
        datosArchivo += datosClienteNuevo;
        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter(ARempleado));
            escribir.write(datosArchivo);
            JOptionPane.showMessageDialog(null, "Usuario agregado!");
            escribir.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public int ComprobarAR() {
        if (ARmaster.exists() && ARempleado.exists() && ARcliente.exists()) {
            return 1;
        } else {
            try {
                if (!ARmaster.exists()) {
                    ARmaster.createNewFile();
                }
                if (!ARempleado.exists()) {
                    ARempleado.createNewFile();
                }
                if (!ARcliente.exists()) {
                    ARcliente.createNewFile();
                }
                return 2;
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Hubo un error creando el archivo.\nError: " + e.getMessage());
                return 3;
            }
        }
    }

    ///////////////////////////////////////////////////////////
    public boolean ComprobarMASTER(String nombre, String contra) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(ARmaster));
        String linea;
        String comprobarNB = "Nombre:" + nombre;
        String comprobarCT = "Contrasenna:" + contra;
        while ((linea = br.readLine()) != null) {
            if (linea.equals(comprobarNB)) {
                linea = br.readLine();
                if (linea.equals(comprobarCT)) {
                    br.close();
                    return true;
                }
            }
        }
        br.close();
        return false;
    }

    public void EscribirArchivo(ListaCliente lista) {
        StringBuilder datoArchivo = new StringBuilder();
        try {
            NodoCliente aux = lista.getCabeza();
            while (aux != null) {
                datoArchivo.append("Nombre:").append(aux.getPersona().getNombre());
                datoArchivo.append("\nApellidos:").append(aux.getPersona().getApellido());
                datoArchivo.append("\nEdad:").append(aux.getPersona().getEdad());
                datoArchivo.append("\nID:").append(aux.getPersona().getId());
                datoArchivo.append("\nTelefono:").append(aux.getPersona().getNumeroTel());
                datoArchivo.append("\nCorreo:").append(aux.getPersona().getCorreo());
                datoArchivo.append("\nCantidad Vehiculos:").append(aux.getPersona().getCantidadV());
                datoArchivo.append("\nReservado:").append(aux.getPersona().getReservado());
                datoArchivo.append("\nComprado:").append(aux.getPersona().getCompro());
                datoArchivo.append("\n\n");
                aux = aux.getSiguiente();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al leer el archivo.\n" + e.getMessage());
        }
        try {
            BufferedWriter escribir = new BufferedWriter(new FileWriter(ARcliente));
            escribir.write(datoArchivo.toString());
            escribir.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al leer el archivo.\n" + e.getMessage());
        }
    }

    // Método para agregar un vehículo al archivo sin sobrescribir los existentes
    public void guardarVehiculo(Vehiculo vehiculo) {
        String vehiculoString = vehiculo.toString();
        try (PrintWriter salida = new PrintWriter(new FileWriter(nombreARvehiculo, true))) {
            salida.println(vehiculoString);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al archivar en el archivo: " + ex.getMessage());
        }
    }

    ////////////////// guardar usuarios 
    public void guardaUsuario(Usuario usuario) {
        String usuarioString = usuario.toString();
        try (PrintWriter salida = new PrintWriter(new FileWriter(nombreARempleado, true))) {
            salida.println(usuarioString);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al archivar en el archivo: " + ex.getMessage());
        }
    }

    public void cargarAR(ListaCliente lista) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(ARcliente));
        String linea = "";
        while ((linea = br.readLine()) != null) {
            String nombre = linea.substring(7).trim();
            linea = br.readLine();

            String apellidos = linea.substring(10).trim();
            linea = br.readLine();

            int edad = Integer.parseInt(linea.substring(5).trim());
            linea = br.readLine();

            int id = Integer.parseInt(linea.substring(3).trim());
            linea = br.readLine();

            int numero = Integer.parseInt(linea.substring(9).trim());
            linea = br.readLine();

            String correo = linea.substring(7).trim();
            linea = br.readLine();

            int cantidadV = Integer.parseInt(linea.substring(19).trim());
            linea = br.readLine();

            boolean reservado = Boolean.parseBoolean(linea.substring(9).trim());
            linea = br.readLine();

            boolean comprado = Boolean.parseBoolean(linea.substring(9).trim());
            linea = br.readLine();

            Customer persona = new Customer(nombre, apellidos, edad, id, numero, correo, cantidadV, reservado, comprado);

            lista.agregarPersonaOrdenado(persona);
            lista.ContarClientes();
            c.getCantidadV();
            
            //lista.reporteCliente();
        }
        br.close();
    }

    // Método para modificar un vehículo en el archivo
    public void modificarVehiculo(Vehiculo vehiculoAntiguo, Vehiculo vehiculoNuevo) {
        String contenidoArchivo = leerArchivo(nombreARvehiculo);
        String vehiculoAntiguoString = vehiculoAntiguo.toString();
        String vehiculoNuevoString = vehiculoNuevo.toString();
        contenidoArchivo = contenidoArchivo.replace(vehiculoAntiguoString, vehiculoNuevoString);
        escribirArchivo(nombreARvehiculo, contenidoArchivo);
        JOptionPane.showMessageDialog(null, "Vehículo actualizado con éxito.");
    }

    // Método para agregar datos al final del archivo (usar para agregar vehículos)
    public static void archivar(String nombreArchivo, String contenido) {
        try (PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo, true))) {
            salida.println(contenido);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al archivar en el archivo: " + ex.getMessage());
        }
    }

    public Vehiculo cargarVehiculo(String modelo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreARvehiculo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Verifica si la línea contiene el modelo buscado
                if (linea.contains("Modelo:" + modelo)) {
                    // Divide la línea por comas para obtener los atributos del vehículo
                    String[] datos = linea.split(",");
                    if (datos.length != 11) {
                        throw new IOException("Datos de vehículo incompletos.");
                    }

                    String marca = obtenerDato(datos[0]);
                    // El modelo ya lo tenemos, es el parámetro 'modelo'
                    String color = obtenerDato(datos[2]);
                    int anio = Integer.parseInt(obtenerDato(datos[3]));
                    int cilindraje = Integer.parseInt(obtenerDato(datos[4]));
                    double kilometraje = Double.parseDouble(obtenerDato(datos[5]));
                    Vehiculo.TipoVehiculo tipo = Vehiculo.TipoVehiculo.valueOf(obtenerDato(datos[6]).toUpperCase());
                    String caracteristicas = obtenerDato(datos[7]);
                    Vehiculo.EstadoVehiculo estado = Vehiculo.EstadoVehiculo.valueOf(obtenerDato(datos[8]).toUpperCase());
                    String cliente = obtenerDato(datos[9]);
                    String vendedor = obtenerDato(datos[10]);

                    return new Vehiculo(marca, modelo, color, anio, cilindraje, kilometraje, tipo, caracteristicas, estado, cliente, vendedor);
                }
            }
        }
        return null; // Si no se encuentra el vehículo, retorna null
    }

    private String obtenerDato(String dato) {
        return dato.split(":")[1].trim();
    }

    public static void guardarListaVehiculos(String contenido) {
        escribirArchivo("ListaVehiculo.txt", contenido);
    }

    public static String cargarListaVehiculos() {
        return leerArchivo("ListaVehiculo.txt");
    }

    public static String leerArchivo(String nombreArchivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return ""; // Retorna una cadena vacía en caso de error.
        }
        return contenido.toString();
    }

    // Método para escribir contenido completo en un archivo
    public static void escribirArchivo(String nombreArchivo, String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, false))) {
            bw.write(contenido);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    
    public boolean ComprobarID(String nombre) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(ARempleado));
        String linea;
        while((linea = br.readLine())!=null) {
            if(linea.startsWith("Correo:")) {
                String arrSplit[]= linea.split(":",8 );
                String nombrebuscar = arrSplit[1].trim();
                if (nombrebuscar.equals(nombre)) {
                    br.close();
                    return true;
                }}}
        br.close();
        return false;
    }


}
