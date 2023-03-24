package com.caveldev.monedaconversor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainTemperatureConverter extends JFrame{
    protected JPanel panelTemperatureConverter;
    private JTextField textInputTemperature;
    private JComboBox boxLeft;
    private JComboBox boxRight;
    private JButton btnConvert;
    private JButton btnBackMenu;
    private double outputTemperature;
    private double calculating;

    String[] nameTemperature ={"Celsius", "Fahrenheit", "Kelvin"};


    public MainTemperatureConverter() {
        boxLeft.setModel(new DefaultComboBoxModel<>(nameTemperature));
        boxRight.setModel(new DefaultComboBoxModel<>(nameTemperature));

        textInputTemperature.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //Metodo para definir los caracteres permitidos
                textInputTemperature.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent evt) {
                        int key = evt.getKeyChar();
                        boolean number = key>=48 && key<=57 || key == 46;
                        if (!number){ evt.consume();}
                    }
                });
            }
        });
        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInputText();

            }
        });


        btnBackMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backMenu();
            }
        });
        textInputTemperature.addKeyListener(new KeyAdapter() {
        });
    }

    public void checkInputText(){
        if (textInputTemperature.getText().isEmpty() || textInputTemperature.getText().startsWith(".")) {
            JOptionPane.showMessageDialog(btnConvert, "Ingrese el valor que desea convertir");
        } else {
            try{
                checkBoxSelectedOptions();
            } catch (NumberFormatException numberFormatException){
                JOptionPane.showMessageDialog(btnConvert, "El valor ingresado no es valido");
            }

        }
    }

    private void checkBoxSelectedOptions(){
        switch (boxLeft.getSelectedIndex()){
            case 0:
                calculateCelsius();
                break;

            case 1:
                calculateFarenheit();
                break;

            case 2:
                calculateKelvin();
                break;
        }
    }

    private void calculateCelsius(){
       outputTemperature = Double.parseDouble(textInputTemperature.getText());

       switch (boxRight.getSelectedIndex()){
            case 0:
                break;

           case 1:
               calculating = outputTemperature*1.8+32;
               break;

           case 2:
               calculating = outputTemperature+273.15;
               break;
        }
            showMessage();
    }

    private void calculateFarenheit(){
        outputTemperature = Double.parseDouble(textInputTemperature.getText());

        switch (boxRight.getSelectedIndex()){
            case 0:
                calculating = (outputTemperature-32)/1.8;
                break;

            case 1:
                break;

            case 2:
                calculating = (outputTemperature-32)* 5/9 +273.15;
                break;
        }
        showMessage();
    }

    private void calculateKelvin(){
        outputTemperature = Double.parseDouble(textInputTemperature.getText());

        switch (boxRight.getSelectedIndex()){
            case 0:
                calculating = outputTemperature-273.15;
                break;

            case 1:
                calculating = (outputTemperature-273.15)* 9/5 + 32;
                break;

            case 2:
                break;
        }
        showMessage();
    }

    private void showMessage(){
        if (boxLeft.getSelectedIndex() == boxRight.getSelectedIndex()){
            JOptionPane.showMessageDialog(btnConvert,  "El resultado de la conversión es: "+outputTemperature);
        } else {
            JOptionPane.showMessageDialog(btnConvert,  "El resultado de la conversión es: "+calculating);
        }
    }

    private void backMenu() {
        FirstWindows menu = new FirstWindows();
        menu.setSize(400, 250);
        menu.add(menu.panelFirstWindow);
        menu.setTitle("onvertidor de unidades");
        menu.setLocation(this.getLocation());
        menu.setResizable(false);
        menu.setVisible(true);
        this.dispose();
    }



}
