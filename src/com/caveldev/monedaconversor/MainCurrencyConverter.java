package com.caveldev.monedaconversor;

import javax.swing.*;
import java.awt.event.*;

public class MainCurrencyConverter extends JFrame{

    private JComboBox boxExchangeCurrencies;
    private JTextField imputAmount;
    private JButton btnConvert;
    protected JPanel panelConversorMoneda;
    private JLabel valorText;
    private JButton btnBackMenu;
    private JLabel githubUserLabel;
    private JComboBox boxConversionType;
    private JLabel labelConversionExplain;
    static double[] valueCurrency = {
            24.87,
            26.13,
            0.187,
            1,
            29.83,
            4.65,
            1.29,
            0.030,
            1.36,
            0.0051,
    };
    static String[] nameCurrency = {
            "Dolar (USD)",
            "Euro (EUR)",
            "Yen (JPY)",
            "Lempira (HNL)",
            "Libra Esterlina (GBP)",
            "Real Brasileño (BRL)",
            "Lira Turca (TRY)",
            "Peso Chileno (CLP)",
            "Peso Mexicano (MXN)",
            "Peso Colombiano (COP)",
    };

    static String[] nameCurrencyAbbreviated = {
            " USD",
            " EUR",
            " JPY",
            " HNL",
            " GBP",
            " BRL",
            " TRY",
            " CLP",
            " MXN",
            " COP",
    };

    static String[] conversionType = {"Lempiras (HNL) a otras divisas", "Otras divisas a Lempiras (HNL)"};

    //Metodo para verificar las monedas seleccionadas
    private void checkExchangeRate(){
        int i;
        int indexBoxEC = boxExchangeCurrencies.getSelectedIndex();

        //Busca los indices "Moneda" = "valor"
        for (i=0; i< nameCurrency.length; i++){
            for (int j = 0; j< valueCurrency.length; j++){

                //Iguala los indices "Moneda" = "valor"
                if (i==j && boxExchangeCurrencies.getItemAt(indexBoxEC) == nameCurrency[i]){
                    System.out.println(indexBoxEC + " = "+ i);

                    //Convierte los Strings en double.
                    double outputAmount = Double.parseDouble(imputAmount.getText());

                    //Efectua la conversion segun el indice seleccionado
                    if (nameCurrency[i] == boxExchangeCurrencies.getItemAt(indexBoxEC)) {

                        //Verifica el tipo de conversion a realizar
                        if (boxConversionType.getSelectedIndex() == 0){
                            System.out.println(nameCurrency[i] +" = "+ valueCurrency[i]);
                            valorText.setText(String.format("%.2f", outputAmount / valueCurrency[i]) + nameCurrencyAbbreviated[i]);
                        } else {
                            System.out.println(nameCurrency[i] +" = "+ valueCurrency[i]);
                            valorText.setText(String.format("%.2f", outputAmount * valueCurrency[i]) + nameCurrencyAbbreviated[3]);
                        }
                    }else {
                        JOptionPane.showMessageDialog(btnConvert, "Ocurrió un error, por favor reportar este incidente");
                    }
                    break;
                }
            }
        }


    }

    //Metodo para verificar tipo de cambio
    private void ConversionType(){
        String boxSelected = (String) boxExchangeCurrencies.getItemAt(boxExchangeCurrencies.getSelectedIndex());

        if (boxConversionType.getSelectedIndex() == 0){
                labelConversionExplain.setText("Se convertirá de Lempiras (HNL) a " + boxSelected);
        } else {
            labelConversionExplain.setText("Se convertirá de " + boxSelected + " a Lempiras (HNL)");
        }
    }

    //Metodo para verificar si hay datos validos
    private void checkInputText(){
        if (imputAmount.getText().isEmpty() || imputAmount.getText().startsWith(".")) {
            JOptionPane.showMessageDialog(btnConvert, "Por favor ingrese el monto que desea convertir");
        } else {
            checkExchangeRate();
        }
    }

    public MainCurrencyConverter() {
        boxExchangeCurrencies.setModel(new DefaultComboBoxModel<>(nameCurrency));
        boxConversionType.setModel(new DefaultComboBoxModel<>(conversionType));
        ConversionType();

        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInputText();
            }
        });

        //Metodo para definir los caracteres permitidos
        imputAmount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                int key = evt.getKeyChar();
                boolean number = key>=48 && key<=57 || key == 46;
                if (!number){ evt.consume();}
            }
        });
        btnBackMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backMenu();
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
        boxConversionType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConversionType();
            }
        });
        boxExchangeCurrencies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConversionType();
            }
        });
    }


    private void backMenu(){
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
