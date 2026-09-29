package com.uthh.edd.prycuentabancaria;

import com.uthh.edd.prycuentabancaria.presentador.CuentaPresentador;
import com.uthh.edd.prycuentabancaria.vista.VentanaCuenta;
import javax.swing.SwingUtilities;

/**
 * Punto de entrada que conecta los componentes de la arquitectura MVP.
 * Autor: Ronaldo Hernández Hernández.
 */
public class PryCuentaBancaria {

    public static void main(String[] args) {
        // Swing debe construir la ventana en su hilo de eventos.
        SwingUtilities.invokeLater(() -> {
            VentanaCuenta vista = new VentanaCuenta();
            new CuentaPresentador(vista);
            vista.setVisible(true);
        });
    }
}
