/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import static proyectoestructuras.Configuracion.nombre;

/**
 *
 * @author indira
 * @author jeffry
 * @author jorge
 * @author jeferson
 *
 *
 * 1. Reportes //jefferson -Indira 2.Garantias---Jeffry 3.Ver usuarios--Jorge
 * 4.eliminar usuario----Jorge
 */
public class Menu {

    static int cantidadCl;
    static int cantidadReservado;
    static int cantidadCompraron;
    Customer p = new Customer();
    private ListaUsuario lUsuario = new ListaUsuario();
    private ListaCliente lista = new ListaCliente();
    Configuracion conf = new Configuracion();
    ManejoArchivos m = new ManejoArchivos();
    private ListaDeVehiculos listaDeVehiculos = new ListaDeVehiculos();
    Usuario u = new Usuario();

    private int contador;

    public void Menu_UsuarioGlobal() throws IOException {
        int opcion;
        do {
            String opciones[] = {
                "1. Crear usuario", "2. Crear vehiculo", "3. Ver Usuarios",
                "4. Ver clientes", "5. Eliminar usuario",
                "6. Consultar reportes", "7. Informacion", "0. Salir del sistema"
            };

            Object seleccion = JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción",
                    "Menu maestro",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            // Para buscar la opcion
            opcion = -1;  // Valor por defecto
            for (int i = 0; i < opciones.length; i++) {
                if (opciones[i].equals(seleccion)) {
                    opcion = i;
                    break;
                }
            }
            //||lUsuario.compararNombre(nombre
            switch (opcion) {
                case 0 -> {
                    //creamos usuario
                    String nombre = JOptionPane.showInputDialog("Escriba el correo del nuevo usuario");
                    if (m.ComprobarNombre(nombre)) {
                        JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre");
                        break;
                    } else {
                        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su id:"));
                        String contra = JOptionPane.showInputDialog("Escriba una contrasenna para el nuevo usuario");
                        int contadorV = 0;
                        int contadorR = 0;
                        m.AgregarUE(nombre, contra, contadorR ,contadorV);
                        lUsuario.agregarUsarioOrdenado(new Usuario(nombre, contra, contadorV, contadorR, id));

                    }
                }
                case 1 -> {
                    Vehiculo nuevoVehiculo = CrearVehiculo.crearNuevoVehiculo();
                    listaDeVehiculos.agregarVehiculo(nuevoVehiculo);

                    // Utilizar ManejoArchivos para guardar el vehículo
                    ManejoArchivos manejoArchivos = new ManejoArchivos();
                    manejoArchivos.guardarVehiculo(nuevoVehiculo);

                    JOptionPane.showMessageDialog(null, "Vehículo creado exitosamente:\n" + nuevoVehiculo.toString());
                }
                case 2 -> {
                    //ver usuarios
                    m.mostrarUsuarios();

                }
                case 3 -> {
                    StringBuilder sb = new StringBuilder();
                    NodoCliente aux = lista.getCabeza();
                    while (aux != null) {
                        sb.append(aux.getPersona()).append("\n");
                        aux = aux.getSiguiente();
                    }
                    JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Clientes", JOptionPane.DEFAULT_OPTION);
                    break;
                }
                case 4 -> {

                    //eliminar Usuario
                    m.eliminarEmpleado(nombre);
                }
                case 5 -> {
                    JOptionPane.showMessageDialog(null, " A continuacion"
                            + " se le presentaran los reportes: ");
                    String[] opcionesR = {"1. Autos", "2. Clientes", "3. Top", "4. Vehiculos vendidos", "5. Vehiculos reservados", "6. Salir"};
                    int opcionR = JOptionPane.showOptionDialog(null, """
                       Seleccione una opcion:
                       1.Cantidad total de autos venditos, reservados y disponibles
                       2.Cantidad de clientes registrados, clientes que compraron un vehículo, clientes que reservaron un vehículo.
                       3.Top 3 de clientes que más compraron vehículos
                       4.Cantidad de vehículos vendidos por vendedor
                       5.Cantidad de vehículos reservados por vendedor
                       6.Salir                                       """, "Reportes", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, opcionesR, opcionesR[5]);
                    switch (opcionR) {
                        case 0 -> {
                            int cantidadReservadosV = listaDeVehiculos.calcularCantidadReservado();
                            int cantidadCompradosV = listaDeVehiculos.calcularCantidadVendidos();
                            int cantidadDisponiblesV = listaDeVehiculos.calcularCantidadDisponibles();
                            listaDeVehiculos.reporteVehiculo(cantidadCompradosV, cantidadReservadosV, cantidadDisponiblesV);
                        }
                        case 1 -> {
                            lista.calcularCantidadComprado();
                            lista.calcularCantidadReservado();
                            JOptionPane.showMessageDialog(null, "La cantidad de clientes registrados son " + cantidadCl + "\n"
                                    + "La cantidad de clientes con vehículos comprados son " + cantidadCompraron + "\n"
                                    + "La cantidad de clientes con vehículos reservados son " + cantidadReservado + "\n");
                        }
                        case 2 -> {
                            
                            JOptionPane.showMessageDialog(null, lista.getMayor());
                        }
                        case 3 -> {
                            JOptionPane.showMessageDialog(null, m.getVendedoresV());
                        }
                        case 4 -> {
                             JOptionPane.showMessageDialog(null,m.getVendedoresR());
                        }
                        case 5 -> {
                            break;
                        }
                        default ->
                            JOptionPane.showMessageDialog(null, "Opción inválida. "
                                    + "Por favor, seleccione nuevamente.");
                    }
                }
                case 6 -> {
                    JOptionPane.showMessageDialog(null, conf.toString(), "Información de la Empresa", JOptionPane.INFORMATION_MESSAGE);
                }
                case 7 -> {
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                }
                default ->
                    JOptionPane.showMessageDialog(null, "Opción inválida. "
                            + "Por favor, seleccione nuevamente.");
            }
        } while (opcion != 7);
    }

    public void Menu_Empleado() {

        int opcion;
        do {
            String opciones[] = new String[7];
            opciones[0] = "1. Actualizar estado de vehiculos";
            opciones[1] = "2. Ver lista de vehiculos";
            opciones[2] = "3. Crear usuario para cliente";
            opciones[3] = "4. Ver lista de clientes";
            opciones[4] = "5. Consultar garantia de un vehiculo";
            opciones[5] = "7. Informacion";
            opciones[6] = "0. Salir del sistema";

            Object seleccion = JOptionPane.showInputDialog(
                    null,
                    "Seleccione una opción",
                    "Menu maestro",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            // Para buscar la opcion
            opcion = -1;  // Valor por defecto
            for (int i = 0; i < opciones.length; i++) {
                if (opciones[i].equals(seleccion)) {
                    opcion = i;
                    break;
                }
            }
            switch (opcion) {
                case 0 -> {
                    actualizarEstadoVehiculo();
                }

                case 1 -> {
                   
                    // Obtiene la lista de vehículos
                    String vehiculosStr = listaDeVehiculos.listarVehiculos();

                    if (vehiculosStr == null || vehiculosStr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay vehículos registrados.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Lista de Vehículos:\n" + vehiculosStr);
                    }
                }
                case 2 -> {
                    //El programa debe permitir la creación de clientes.

                    String correo = "";
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre : ");
                    String apellido = JOptionPane.showInputDialog("Ingrese su apellido: ");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad  :"));
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de identificacion :"));
                    if (lista.compararId(id)) {
                        break;
                    } else {
                        int numeroTel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero telefono:"));
                        correo = p.correoDado(correo);
                        int cantidadV = 0;
                        boolean reservado = false;
                        boolean comprado = false;

                        lista.agregarPersonaOrdenado(new Customer(nombre, apellido, edad, id, numeroTel, correo, cantidadV, reservado, comprado));
                        lista.ContarClientes();
                        m.EscribirArchivo(lista);
                        break;
                    }

                }
                case 3 -> {
                    //El programa debe permitir la  lectura y actualización de clientes. listo
                    //El programa no debe permitir registrar dos clientes con la misma identificación. *****falta****
                    int op;
                    do {
                        String[] opcionesM = {"Buscar Cliente", "Ver lista de clientes", "Modificar", "Salir"};
                        op = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesM, opcionesM[3]);

                        switch (op) {
                            case 0 -> {

                                lista.buscar();
                            }
                            case 1 -> {
                                StringBuilder sb = new StringBuilder();
                                NodoCliente aux = lista.getCabeza();
                                while (aux != null) {
                                    sb.append(aux.getPersona()).append("\n");
                                    aux = aux.getSiguiente();
                                }
                                JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Clientes", JOptionPane.DEFAULT_OPTION);
                                break;
                            }
                            case 2 -> {
                                lista.modificar();
                                m.EscribirArchivo(lista);
                            }
                            case 3 -> {
                                break;
                            }
                        }
                    } while (op != 3);

                }
                case 4 -> {
                    //Garantia
                }
                case 5 -> {
                    JOptionPane.showMessageDialog(null, conf.toString(), "Información de la Empresa", JOptionPane.INFORMATION_MESSAGE);

                }
                case 6 -> {
                    JOptionPane.showMessageDialog(null, "¡Cerrando sistema!", "Cerrando", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                default ->
                    JOptionPane.showMessageDialog(null, "Opción inválida. "
                            + "Por favor, seleccione nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 6);
    }

    private void actualizarEstadoVehiculo() {
        // Asegúrate de que la lista de modelos no esté vacía
        String[] modelos = listaDeVehiculos.getModelosVehiculos();
        if (modelos.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay modelos de vehículos disponibles para actualizar.");
            return;
        }
        String modeloSeleccionado = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el vehículo a actualizar:",
                "Actualizar Estado del Vehículo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                modelos,
                modelos[0] // El primer elemento por defecto
        );
        // Si no se selecciona ningún modelo (cancelar), se sale del método
        if (modeloSeleccionado == null || modeloSeleccionado.isEmpty()) {
            return;
        }
        // Opciones para el estado del vehículo
        Vehiculo.EstadoVehiculo[] estadosPosibles = Vehiculo.EstadoVehiculo.values();
        Vehiculo.EstadoVehiculo nuevoEstado = (Vehiculo.EstadoVehiculo) JOptionPane.showInputDialog(
                null,
                "Seleccione el nuevo estado del vehículo:",
                "Estado del Vehículo",
                JOptionPane.QUESTION_MESSAGE,
                null,
                estadosPosibles,
                estadosPosibles[0]
        );
        // Si no se selecciona ningún estado (cancelar), se sale del método
        if (nuevoEstado == null) {
            return;
        }
        int id = 0;

        String cliente = null;
        String vendedor = null;
        if (nuevoEstado != Vehiculo.EstadoVehiculo.DISPONIBLE) {
            cliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
            id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el  ID del cliente:"));
            vendedor = obtenerNombreVendedor(); // Implementar este método para obtener el nombre del vendedor actual
        }
        if (nuevoEstado == Vehiculo.EstadoVehiculo.VENDIDO) {
            lista.buscarClienteV(id);
            lUsuario.buscarVendedorV(vendedor);
            m.EscribirArchivo(lista);
        }
        if (nuevoEstado == Vehiculo.EstadoVehiculo.RESERVADO) {
            lista.buscarClienteR(id);
            lUsuario.buscarVendedorR(vendedor);
            m.EscribirArchivo(lista);
        }

        // Llamar al método de la clase ListaDeVehiculos para actualizar el vehículo
        boolean actualizado = listaDeVehiculos.actualizarVehiculo(modeloSeleccionado, nuevoEstado, cliente, vendedor);
        if (actualizado) {
            JOptionPane.showMessageDialog(null, "Vehículo actualizado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el vehículo.");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String obtenerNombreVendedor() {
        // Paso 1: Contar el número de vendedores
        int contadorVendedores = 0;
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader("LoginEmpleado.txt"))) {
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Correo:") && !linea.contains("null")) {
                    contadorVendedores++;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de empleados.");
            return null;
        }

        // Si no hay vendedores, regresa null
        if (contadorVendedores == 0) {
            JOptionPane.showMessageDialog(null, "No hay vendedores disponibles para seleccionar.");
            return null;
        }

        // Paso 2: Almacenar los nombres de los vendedores en un arreglo
        String[] vendedores = new String[contadorVendedores];
        int indice = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("LoginEmpleado.txt"))) {
            while ((linea = br.readLine()) != null && indice < contadorVendedores) {
                if (linea.startsWith("Correo:") && !linea.contains("null")) {
                    vendedores[indice++] = linea.split(":")[1].trim();
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al volver a leer el archivo de empleados.");
            return null;
        }

        // Mostrar el JOptionPane para seleccionar un vendedor
        String vendedorSeleccionado = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione un vendedor:",
                "Selección de Vendedor",
                JOptionPane.QUESTION_MESSAGE,
                null,
                vendedores,
                vendedores[0] // El primer elemento por defecto
        );

        if (vendedorSeleccionado == null || vendedorSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún vendedor.");
            return null;
        }

        return vendedorSeleccionado;
    }

    public void Cargar() throws IOException {
        m.cargarAR(lista);
        listaDeVehiculos.limpiarLista();
         listaDeVehiculos.cargarDesdeArchivo();

    }

    public void Guardar() {
        m.EscribirArchivo(lista);
    }

    public static void actualizar(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenido);
            salida.close();
            //System.out.println("Se escribio informacion en archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
