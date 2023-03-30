package com.caveldev.monedaconversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class FirstWindows extends JFrame {
    protected JPanel panelFirstWindow;
    private JButton btnStartConverter;
    private JComboBox boxConverterOptions;
    private JLabel githubUserLabel;

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

        //Boton GitHub
        githubUserLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Acceso a Extras
                Extras extras = new Extras();
                extras.openLinkGithub();
            }
        });
    }


    private void checkSelectedConverter(){
        switch (boxConverterOptions.getSelectedIndex()){
            case 0:
                initCurrencyConverter();
                break;
            case 1:
                initTemperatureConverter();
                break;
        }

    }

    private void initCurrencyConverter(){
        MainCurrencyConverter windowMCC = new MainCurrencyConverter();
        windowMCC.setSize(400, 350);
        windowMCC.setLocation(this.getLocation());
        windowMCC.add(windowMCC.panelConversorMoneda);
        windowMCC.setTitle("Convertidor de Divisas");
        windowMCC.setResizable(false);
        windowMCC.setVisible(true);
        this.dispose();
    }

    private void initTemperatureConverter(){
        MainTemperatureConverter windowMTC = new MainTemperatureConverter();
        windowMTC.setSize(width-100, height+150);
        windowMTC.setLocation(this.getLocation());
        windowMTC.add(windowMTC.panelTemperatureConverter);
        windowMTC.setTitle("Convertidor de Temperatura");
        windowMTC.setResizable(false);
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
