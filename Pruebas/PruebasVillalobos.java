/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import BaseDeDatos.MySQL;
import Consultas.Querys;
import RegistrarEditorial.RegisterEditorial;
import java.sql.SQLException;
import Empleados.Registrar;

/**
 * Class
 *
 * @ClassName PruebasVillalobos
 * @Author Jesús Villalobos
 * @Date Marzo del 2020
 * @Version 1
 * @Description Está clase es para realizar pruebas
 */
public class PruebasVillalobos {

    public static void main(String[] args) throws SQLException {
        /*
        MySQL sql = new MySQL();
        Querys q = new Querys();
        if (sql.Insert(q.InsertEmployed("Jesus", "Vv", "1999/07/28", "asdd", "asd", 1, 1))) {
            System.out.println("o");
        } else{
            System.out.println("p");
        }
        */
        Registrar r = new Registrar();
        r.setVisible(true);
    }

}
