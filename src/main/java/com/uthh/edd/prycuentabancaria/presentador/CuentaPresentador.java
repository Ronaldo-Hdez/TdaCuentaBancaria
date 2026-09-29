package com.uthh.edd.prycuentabancaria.presentador;

import com.uthh.edd.prycuentabancaria.modelo.CuentaBancaria;
import com.uthh.edd.prycuentabancaria.vista.VentanaCuenta;

/**
 * Presentador MVP: comunica los botones de la vista con el TDA.
 * Autor: Ronaldo Hernández Hernández.
 */
public class CuentaPresentador {
    
    private final VentanaCuenta vista;
    private CuentaBancaria cuenta;

    /** Conecta la vista y su presentador. */
    public CuentaPresentador(VentanaCuenta vista) 
    {
        this.vista = vista;
        vista.setPresentador(this);
    }

    /** Crea una cuenta con los dos datos solicitados en el formulario. */
    public void crearCuenta() 
    {
        try {
            cuenta = new CuentaBancaria(vista.getNumero(), vista.getTitular());
            vista.activarCuenta(cuenta.getNumero(), cuenta.getTitular());
            actualizarVista();
        } catch (IllegalArgumentException ex) 
        {
            vista.mostrarError(ex.getMessage());
        }
    }

    /** Realiza un depósito valido. */
    public void depositar() 
    {
        try {
            cuenta.depositar(leerMonto());
            vista.limpiarMonto();
            actualizarVista();
        } catch (IllegalArgumentException ex) 
        {
            vista.mostrarError(ex.getMessage());
        }
    }

    /** Realiza un retiro valido. */
    public void retirar()
    {
        try {
            cuenta.retirar(leerMonto());
            vista.limpiarMonto();
            actualizarVista();
        } catch (IllegalArgumentException ex)
        {
            vista.mostrarError(ex.getMessage());
        }
    }

    /** Convierte a pesos enteros el monto ingresado. */
    private int leerMonto() 
    {
        try {
            return Integer.parseInt(vista.getMonto().trim());
        } catch (NumberFormatException ex) 
        {
            throw new IllegalArgumentException("Ingrese un monto valido.");
        }
    }

    /** Recorre únicamente las posiciones ocupadas del arreglo. */
    private void actualizarVista() {
        String historial = "";
        for (int i = 0; i < cuenta.getCantidadMovimientos(); i++) 
        {
            int movimiento = cuenta.consultarMovimiento(i);
            historial += (i + 1) + ". "
                    + (movimiento > 0 ? "Depósito: $" : "Retiro: $")
                    + Math.abs(movimiento) + "\n";
        }
        vista.mostrarEstado(cuenta.consultarSaldo(),
                cuenta.contarMovimientos(0), historial);
    }
}
