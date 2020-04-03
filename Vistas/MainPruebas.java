/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import BaseDeDatos.MySQL;

/**
 *
 * @author villalobos28
 */
public class MainPruebas {

    public static void main(String[] args) {
        //RegisterEditorial v = new RegisterEditorial();
        //v.setVisible(true);
        MySQL m = new MySQL();
        m.Open();
    }
}
