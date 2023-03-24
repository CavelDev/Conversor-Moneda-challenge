package com.caveldev.monedaconversor;

import javax.swing.*;

public class Pruebas extends JFrame{
    public static void main(String[] args) {
        //activity_conversor_moneda acm_ventana = new activity_conversor_moneda();
        //acm_ventana.ventanaConversorMoneda();

        MainCurrencyConverter ventana = new MainCurrencyConverter();
        ventana.setContentPane(ventana.panelConversorMoneda);
        ventana.setTitle("Conversor de unidades");
        ventana.setSize(400, 200);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
