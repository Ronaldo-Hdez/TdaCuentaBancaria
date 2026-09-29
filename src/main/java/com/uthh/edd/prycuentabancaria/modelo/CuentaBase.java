package com.uthh.edd.prycuentabancaria.modelo;

/**
 * Datos comunes de una cuenta bancaria.
 * Autor: Ronaldo Hernández Hernández.
 */
public class CuentaBase 
{
    private final String numero;
    private String titular;

    /** Crea la cuenta y valida sus datos. */
    public CuentaBase(String numero, String titular)
    {
        if (numero == null || numero.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("Escribe el número de cuenta.");
        }

        this.numero = numero.trim();
        setTitular(titular);
    }

    /** Devuelve el número de cuenta. */
    public String getNumero()
    {
        return numero;
    }

    /** Devuelve el nombre del titular. */
    public String getTitular()
    {
        return titular;
    }

    /** Cambia el titular después de validar el nombre. */
    public void setTitular(String titular) 
    {
        if (titular == null || titular.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("Escribe el nombre del titular.");
        }

        this.titular = titular.trim();
    }
}