# Cuenta Bancaria - TDA

Autor: Ronaldo Hernández Hernández

## Descripción

Aplicación de escritorio desarrollada en Java que simula las operaciones básicas de una cuenta bancaria mediante un Tipo de Dato Abstracto (TDA) llamado `CuentaBancaria`.

El usuario puede crear una cuenta ingresando un número de cuenta y el nombre del titular. Una vez creada, el sistema permite realizar depósitos y retiros, consultar el saldo disponible y visualizar un historial de los movimientos realizados.

Los movimientos se almacenan en un arreglo de tamaño fijo con capacidad para un máximo de 20 operaciones. Los depósitos se representan mediante valores positivos y los retiros mediante valores negativos.

La aplicación permite realizar las siguientes operaciones:

- Crear una cuenta bancaria.
- Registrar depósitos.
- Registrar retiros.
- Consultar el saldo actual.
- Verificar si existe saldo suficiente para realizar un retiro.
- Consultar el historial de movimientos.
- Contar los movimientos registrados mediante un método recursivo.
- Validar los datos ingresados antes de realizar cada operación.

## Conceptos aplicados

- **TDA y encapsulamiento:** la clase `CuentaBancaria` mantiene privados los atributos relacionados con el saldo, los movimientos y la cantidad de operaciones registradas. El acceso y modificación de estos datos se realiza mediante métodos definidos por el TDA.

- **Herencia:** la clase `CuentaBancaria` hereda de `CuentaBase`. La clase base contiene los datos generales de una cuenta, como el número de cuenta y el nombre del titular.

- **Constructores con validaciones:** al crear una cuenta se verifica que el número de cuenta y el nombre del titular no estén vacíos.

- **Arreglos:** los depósitos y retiros se almacenan en un arreglo de enteros con capacidad máxima de 20 movimientos.

- **Recursividad:** el método `contarMovimientos` recorre de manera recursiva las posiciones ocupadas del arreglo para determinar la cantidad de movimientos registrados.

- **Patrón MVP (Modelo, Vista, Presentador):** el proyecto separa la lógica de la aplicación, la interfaz gráfica y la comunicación entre ambas mediante las capas Modelo, Vista y Presentador.

- **Manejo de excepciones:** las operaciones inválidas generan mensajes de error mediante `IllegalArgumentException`, los cuales son mostrados al usuario desde la interfaz gráfica.

## Estructura del proyecto

El proyecto se encuentra organizado de la siguiente manera:

### Modelo

La clase `CuentaBase` contiene los datos generales de una cuenta bancaria:

- Número de cuenta.
- Nombre del titular.

La clase `CuentaBancaria` hereda de `CuentaBase` y contiene la lógica principal del TDA:

- Saldo disponible.
- Arreglo de movimientos.
- Cantidad de movimientos registrados.
- Depósitos.
- Retiros.
- Validaciones.
- Consulta de movimientos.
- Conteo recursivo de operaciones.

### Presentador

La clase `CuentaPresentador` funciona como intermediario entre la Vista y el Modelo.

Se encarga de:

- Crear la cuenta bancaria.
- Obtener los datos capturados en la interfaz.
- Convertir el monto ingresado a un valor numérico.
- Solicitar depósitos y retiros al modelo.
- Actualizar el saldo mostrado.
- Construir el historial de movimientos.
- Mostrar los errores de validación.

### Vista

La clase `VentanaCuenta` contiene la interfaz gráfica desarrollada con Java Swing y JFrame Form de NetBeans.

La ventana permite:

- Capturar el número de cuenta.
- Capturar el nombre del titular.
- Crear la cuenta.
- Ingresar un monto.
- Realizar depósitos.
- Realizar retiros.
- Consultar el saldo.
- Consultar la cantidad de movimientos.
- Visualizar el historial de operaciones.

## Métodos principales del TDA

La clase `CuentaBancaria` contiene los siguientes métodos:

- `depositar(int monto)`: agrega dinero al saldo y registra el depósito.
- `retirar(int monto)`: descuenta dinero del saldo y registra el retiro.
- `puedeRetirar(int monto)`: verifica si existe saldo suficiente para realizar un retiro.
- `consultarSaldo()`: devuelve el saldo actual de la cuenta.
- `contarMovimientos(int indice)`: cuenta recursivamente los movimientos registrados.
- `consultarMovimiento(int indice)`: devuelve un movimiento almacenado en el arreglo.
- `getCantidadMovimientos()`: devuelve la cantidad de posiciones utilizadas en el arreglo.
- `validarMonto(int monto)`: verifica que el monto ingresado sea mayor que cero.
- `verificarEspacio()`: comprueba que todavía exista espacio disponible en el arreglo de movimientos.

## Recursividad

El proyecto implementa recursividad mediante, el caso base ocurre cuando el índice alcanza la cantidad de movimientos registrados. En caso contrario, el método suma uno y vuelve a llamarse utilizando la siguiente posición del arreglo.

De esta forma se obtiene la cantidad total de operaciones registradas sin utilizar un ciclo para realizar el conteo.

## Funcionamiento de los movimientos

Cada operación realizada se almacena dentro del arreglo `movimientos`.

- Los depósitos se almacenan como números positivos.
- Los retiros se almacenan como números negativos.
- El arreglo permite almacenar como máximo 20 movimientos.

Ejemplo:

```text
1. Depósito: $500
2. Depósito: $300
3. Retiro: $200
```

Después de estas operaciones, el saldo disponible sería:

```text
Saldo: $600
```

## Validaciones

El programa incluye diferentes validaciones para evitar operaciones incorrectas:

- El número de cuenta no puede estar vacío.
- El nombre del titular no puede estar vacío.
- El monto debe ser un número entero válido.
- El monto debe ser mayor que cero.
- No se puede retirar una cantidad superior al saldo disponible.
- No se permiten más de 20 movimientos.
- Se verifica que un depósito no provoque que el saldo exceda el límite permitido para un número entero.
- No se puede consultar una posición inexistente del arreglo de movimientos.

Cuando ocurre un error, la aplicación muestra un mensaje de advertencia y la operación no se realiza.

## Cómo usar la aplicación

1. Escribir el número de cuenta.
2. Escribir el nombre del titular.
3. Presionar el botón **Crear cuenta**.
4. Después de crear la cuenta se habilitarán las opciones para realizar movimientos.
5. Escribir el monto de la operación.
6. Presionar **Depositar** para agregar dinero a la cuenta o **Retirar** para retirar dinero.
7. La aplicación actualizará automáticamente:
   - El saldo disponible.
   - La cantidad de movimientos.
   - El historial de depósitos y retiros.
8. Después de una operación exitosa, el campo del monto se limpia automáticamente.

## Requisitos para ejecutar el proyecto

- JDK 21.
- Apache NetBeans.
- Maven.
- Sistema operativo compatible con Java Swing.

## Cómo ejecutar el proyecto

1. Clonar el repositorio o descargarlo como archivo ZIP desde GitHub.
2. Descomprimir el proyecto si fue descargado como ZIP.
3. Abrir Apache NetBeans.
4. Seleccionar **File > Open Project**.
5. Buscar y seleccionar la carpeta del proyecto.
6. Esperar a que Maven cargue la configuración del archivo `pom.xml`.
7. Ejecutar el proyecto desde NetBeans utilizando **Run Project** o presionando `F6`.
8. Se abrirá la ventana principal de la aplicación.

## Autor

**Ronaldo Hernández Hernández**
