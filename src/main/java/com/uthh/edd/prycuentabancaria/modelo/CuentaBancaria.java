package com.uthh.edd.prycuentabancaria.modelo;

/**
 * TDA de una cuenta bancaria. Usa un arreglo de tamaño fijo para registrar
 * hasta 20 depósitos o retiros, sin colecciones ni base de datos.
 * Autor: Ronaldo Hernández Hernández.
 */
public class CuentaBancaria extends CuentaBase {
    
    private int saldo;
    private final int[] movimientos;
    private int cantidadMovimientos;

    /** Inicia una cuenta con saldo cero y el arreglo vacío. */
    public CuentaBancaria(String numero, String titular) 
    {
        super(numero, titular);
        
        saldo = 0;
        movimientos = new int[20];
        cantidadMovimientos = 0;
    }

    /** Suma un depósito en pesos y lo guarda en el arreglo. */
    public void depositar(int monto) 
    {
        validarMonto(monto);
        verificarEspacio();
        
        if (monto > Integer.MAX_VALUE - saldo) 
        {
            throw new IllegalArgumentException("El saldo excedería el límite permitido.");
        }
        
        saldo += monto;
        movimientos[cantidadMovimientos] = monto;
        cantidadMovimientos++;
    }

    /** Resta un retiro en pesos, siempre que exista saldo suficiente. */
    public void retirar(int monto) 
    {
        validarMonto(monto);
        if (!puedeRetirar(monto)) 
        {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        verificarEspacio();
        saldo -= monto;
        movimientos[cantidadMovimientos] =- monto;
        cantidadMovimientos++;
    }

    /** Determina si el monto cabe dentro del saldo disponible. */
    public boolean puedeRetirar(int monto) 
    {
        return monto > 0 && monto <= saldo;
    }

    /** Consulta el saldo actual en pesos. */
    public int consultarSaldo() 
    {
        return saldo;
    }

    /**
     * Método recursivo del TDA.
     * Caso base: el índice llegó a la cantidad de movimientos.
     * Avance: suma uno y pasa a la siguiente posición del arreglo.
     */
    public int contarMovimientos(int indice) 
    {
        if (indice >= cantidadMovimientos) 
        {
            return 0;
        }
        return 1 + contarMovimientos(indice + 1);
    }

    /** Lee un movimiento existente: positivo es depósito, negativo es retiro. */
    public int consultarMovimiento(int indice) 
    {
        if (indice < 0 || indice >= cantidadMovimientos) 
        {
            throw new IllegalArgumentException("Movimiento inexistente.");
        }
        return movimientos[indice];
    }

    /** Indica cuántas posiciones del arreglo están ocupadas. */
    public int getCantidadMovimientos() 
    {
        return cantidadMovimientos;
    }

    /** Evita montos nulos o negativos. */
    private void validarMonto(int monto) 
    {
        if (monto <= 0) 
        {
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }
    }

    /** Impide escribir fuera de los 20 espacios del arreglo. */
    private void verificarEspacio() 
    {
        if (cantidadMovimientos == movimientos.length) 
        {
            throw new IllegalArgumentException("Se alcanzó el límite de 20 movimientos.");
        }
    }
}
