package com.caveldev.monedaconversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

public class Extras{
    String urlGitHub = "https://github.com/CavelDev";

    public void openLinkGithub(){
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(java.net.URI.create(urlGitHub));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
