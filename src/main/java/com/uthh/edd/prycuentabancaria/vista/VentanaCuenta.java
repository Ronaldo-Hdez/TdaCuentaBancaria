package com.uthh.edd.prycuentabancaria.vista;

import com.uthh.edd.prycuentabancaria.presentador.CuentaPresentador;
import javax.swing.JOptionPane;

/**
 * Vista MVP creada como JFrame Form de NetBeans.
 * Autor: Ronaldo Hernández Hernández.
 */
public class VentanaCuenta extends javax.swing.JFrame {
    private static final long serialVersionUID = 1L;

    /** Crea la ventana con los controles diseñados en NetBeans. */
    public VentanaCuenta() {
        initComponents();
        setLocationRelativeTo(null);
        txtMonto.setEnabled(false);
        btnDepositar.setEnabled(false);
        btnRetirar.setEnabled(false);
    }

    /** Enlaza los botones con los métodos del presentador. */
    public void setPresentador(CuentaPresentador presentador) {
        btnCrear.addActionListener(evento -> presentador.crearCuenta());
        btnDepositar.addActionListener(evento -> presentador.depositar());
        btnRetirar.addActionListener(evento -> presentador.retirar());
    }

    /** Lee el número escrito en la vista. */
    public String getNumero() {
        return txtNumero.getText();
    }

    /** Lee el titular escrito en la vista. */
    public String getTitular() {
        return txtTitular.getText();
    }

    /** Lee el monto escrito en la vista. */
    public String getMonto() {
        return txtMonto.getText();
    }

    /** Habilita los botones tras crear una cuenta válida. */
    public void activarCuenta(String numero, String titular) {
        txtNumero.setEnabled(false);
        txtTitular.setEnabled(false);
        btnCrear.setEnabled(false);
        txtMonto.setEnabled(true);
        btnDepositar.setEnabled(true);
        btnRetirar.setEnabled(true);
        lblTitulo.setText("Cuenta " + numero + " - " + titular);
    }

    /** Vacía el campo después de una operación exitosa. */
    public void limpiarMonto() {
        txtMonto.setText("");
    }

    /** Presenta el saldo, el conteo recursivo y el historial. */
    public void mostrarEstado(int saldo, int cantidad, String historial) {
        lblSaldo.setText("Saldo: $" + saldo + "   |   Movimientos: " + cantidad);
        txtMovimientos.setText(historial);
    }

    /** Muestra un problema de validación sin cerrar la ventana. */
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Revisa los datos",
                JOptionPane.WARNING_MESSAGE);
    }

    /** Código visual generado a partir de VentanaCuenta.form. */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblTitulo = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblTitular = new javax.swing.JLabel();
        txtTitular = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        btnDepositar = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();
        scrollMovimientos = new javax.swing.JScrollPane();
        txtMovimientos = new javax.swing.JTextArea();
        lblSaldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cuenta bancaria");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblTitulo.setText("Cuenta bancaria - Ronaldo Hernández Hernández");
        java.awt.GridBagConstraints c = new java.awt.GridBagConstraints();
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2;
        c.anchor = java.awt.GridBagConstraints.WEST;
        c.insets = new java.awt.Insets(16, 16, 12, 16);
        getContentPane().add(lblTitulo, c);

        lblNumero.setText("Número de cuenta:");
        c = new java.awt.GridBagConstraints();
        c.gridx = 0; c.gridy = 1;
        c.anchor = java.awt.GridBagConstraints.WEST;
        c.insets = new java.awt.Insets(4, 16, 4, 8);
        getContentPane().add(lblNumero, c);

        txtNumero.setColumns(20);
        c = new java.awt.GridBagConstraints();
        c.gridx = 1; c.gridy = 1;
        c.fill = java.awt.GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.insets = new java.awt.Insets(4, 4, 4, 16);
        getContentPane().add(txtNumero, c);

        lblTitular.setText("Titular:");
        c = new java.awt.GridBagConstraints();
        c.gridx = 0; c.gridy = 2;
        c.anchor = java.awt.GridBagConstraints.WEST;
        c.insets = new java.awt.Insets(4, 16, 4, 8);
        getContentPane().add(lblTitular, c);

        txtTitular.setColumns(20);
        c = new java.awt.GridBagConstraints();
        c.gridx = 1; c.gridy = 2;
        c.fill = java.awt.GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.insets = new java.awt.Insets(4, 4, 4, 16);
        getContentPane().add(txtTitular, c);

        btnCrear.setText("Crear cuenta");
        c = new java.awt.GridBagConstraints();
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2;
        c.anchor = java.awt.GridBagConstraints.WEST;
        c.insets = new java.awt.Insets(8, 16, 12, 16);
        getContentPane().add(btnCrear, c);

        lblMonto.setText("Monto en pesos:");
        c = new java.awt.GridBagConstraints();
        c.gridx = 0; c.gridy = 4;
        c.anchor = java.awt.GridBagConstraints.WEST;
        c.insets = new java.awt.Insets(4, 16, 4, 8);
        getContentPane().add(lblMonto, c);

        txtMonto.setColumns(20);
        c = new java.awt.GridBagConstraints();
        c.gridx = 1; c.gridy = 4;
        c.fill = java.awt.GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.insets = new java.awt.Insets(4, 4, 4, 16);
        getContentPane().add(txtMonto, c);

        btnDepositar.setText("Depositar");
        c = new java.awt.GridBagConstraints();
        c.gridx = 0; c.gridy = 5;
        c.anchor = java.awt.GridBagConstraints.WEST;
        c.insets = new java.awt.Insets(8, 16, 8, 8);
        getContentPane().add(btnDepositar, c);

        btnRetirar.setText("Retirar");
        c = new java.awt.GridBagConstraints();
        c.gridx = 1; c.gridy = 5;
        c.anchor = java.awt.GridBagConstraints.WEST;
        c.insets = new java.awt.Insets(8, 4, 8, 16);
        getContentPane().add(btnRetirar, c);

        txtMovimientos.setColumns(35);
        txtMovimientos.setRows(8);
        txtMovimientos.setEditable(false);
        scrollMovimientos.setViewportView(txtMovimientos);
        c = new java.awt.GridBagConstraints();
        c.gridx = 0; c.gridy = 6; c.gridwidth = 2;
        c.fill = java.awt.GridBagConstraints.BOTH;
        c.weightx = 1.0; c.weighty = 1.0;
        c.insets = new java.awt.Insets(4, 16, 8, 16);
        getContentPane().add(scrollMovimientos, c);

        lblSaldo.setText("Saldo: $0   |   Movimientos: 0");
        c = new java.awt.GridBagConstraints();
        c.gridx = 0; c.gridy = 7; c.gridwidth = 2;
        c.anchor = java.awt.GridBagConstraints.WEST;
        c.insets = new java.awt.Insets(4, 16, 16, 16);
        getContentPane().add(lblSaldo, c);

        pack();
    }//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnDepositar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTitular;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollMovimientos;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextArea txtMovimientos;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTitular;
    // End of variables declaration//GEN-END:variables
}
