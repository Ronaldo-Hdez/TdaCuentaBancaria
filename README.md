# TDA Cuenta Bancaria

Autor: Ronaldo Hernández Hernández

## Descripción

Aplicación de escritorio desarrollada en Java que implementa un Tipo de Dato Abstracto (TDA) para simular una cuenta bancaria.

Permite crear una cuenta, realizar depósitos y retiros, consultar el saldo y visualizar el historial de movimientos.

## Conceptos aplicados

- TDA y encapsulamiento.
- Herencia mediante `CuentaBase` y `CuentaBancaria`.
- Arreglo fijo para almacenar hasta 20 movimientos.
- Recursividad para contar los movimientos registrados.
- Validaciones de datos y saldo disponible.
- Patrón MVP para separar Modelo, Vista y Presentador.

## Funcionalidades

- Crear una cuenta bancaria.
- Realizar depósitos.
- Realizar retiros.
- Consultar saldo.
- Consultar historial de movimientos.
- Validar montos y saldo disponible.

## Estructura principal

- Modelo: `CuentaBase` y `CuentaBancaria`.
- Presentador: `CuentaPresentador`.
- Vista: `VentanaCuenta`.
- Clase principal: `PryCuentaBancaria`.

## Tecnologías

- Java 21
- Java Swing
- Maven
- NetBeans
- Git y GitHub
