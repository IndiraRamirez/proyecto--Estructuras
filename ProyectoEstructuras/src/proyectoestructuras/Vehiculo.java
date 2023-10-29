/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructuras;
import java.io.Serializable;

/**
 *
 * @author JeffryCh
 */
public class Vehiculo implements Serializable {

    // Enumeración para el tipo de vehículo
    public enum TipoVehiculo {
        SUV, SEDAN, HATCHBACK
    }

    // Enumeración para el estado del vehículo
    public enum EstadoVehiculo {
        DISPONIBLE, RESERVADO, VENDIDO
    }

    private String color;
    private int anio;
    private int cilindraje;
    private String marca;
    private String modelo;
    private double kilometraje;
    private TipoVehiculo tipo;
    private String caracteristicas;
    private EstadoVehiculo estado;
    private String cliente;
    private String vendedor;

    // Constructor
    public Vehiculo(String color, int anio, int cilindraje, String marca, String modelo, double kilometraje, TipoVehiculo tipo, String caracteristicas) {
        this.color = color;
        this.anio = anio;
        this.cilindraje = cilindraje;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.estado = EstadoVehiculo.DISPONIBLE;
        this.cliente = null;
        this.vendedor = null;
    }

    // Set
    public void setColor(String color) {
        this.color = color;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    // Get
    public String getColor() {
        return color;
    }

    public int getAnio() {
        return anio;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public String getCliente() {
        return cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    // Métodos adicionales
    public void reservarVehiculo(String cliente, String vendedor) {
        if (this.estado == EstadoVehiculo.DISPONIBLE) {
            this.estado = EstadoVehiculo.RESERVADO;
            this.cliente = cliente;
            this.vendedor = vendedor;
        }
    }

    public void venderVehiculo() {
        if (this.estado == EstadoVehiculo.RESERVADO) {
            this.estado = EstadoVehiculo.VENDIDO;
        }
    }

    public void desistirCompra() {
        if (this.estado == EstadoVehiculo.RESERVADO) {
            this.estado = EstadoVehiculo.DISPONIBLE;
            this.cliente = null;
        }
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Color: " + color + ", Año: " + anio;
    }

}
