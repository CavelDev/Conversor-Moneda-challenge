package com.caveldev.monedaconversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstWindows extends JFrame{
    protected JPanel panelFirstWindow;
    private JButton btnStartConverter;
    private JComboBox boxConverterOptions;

    private int width = 400, height = 200;

    static String optionConverter[] = {
            "Convertidor de divisas",
            "Convertidor de temperatura",
    };

    public FirstWindows() {
        //Establecer lista opciones
        boxConverterOptions.setModel(new DefaultComboBoxModel<>(optionConverter));

        //Boton iniciar
        btnStartConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkSelectedConverter();
            }
        });
    }


    private void checkSelectedConverter(){
        switch (boxConverterOptions.getSelectedIndex()){
            case 0:
                System.out.println("divisas");
                initCurrencyConverter();
                break;
            case 1:
                System.out.println("temperatura");
                initTemperatureConverter();
                break;
        }

    }

    private void initCurrencyConverter(){
        MainCurrencyConverter windowMCC = new MainCurrencyConverter();
        windowMCC.setSize(width, height+100);
        windowMCC.add(windowMCC.panelConversorMoneda);
        windowMCC.setTitle("Convertidor de Divisas");
        windowMCC.setLocation(this.getLocation());
        windowMCC.setResizable(false);
        windowMCC.setVisible(true);
        this.dispose();
    }

    private void initTemperatureConverter(){
        MainTemperatureConverter windowMTC = new MainTemperatureConverter();
        windowMTC.setSize(width-100, height+150);
        windowMTC.add(windowMTC.panelTemperatureConverter);
        windowMTC.setTitle("Convertidor de Temperatura");
        windowMTC.setResizable(false);
        windowMTC.setLocation(this.getLocation());
        windowMTC.setVisible(true);
        this.dispose();
    }


public static void main(String[] args){
    FirstWindows ventana = new FirstWindows();
    ventana.setContentPane(ventana.panelFirstWindow);
    ventana.setTitle("Conversor de unidades");
    ventana.setSize(300,250);
    ventana.setResizable(false);
    ventana.setVisible(true);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}




}
