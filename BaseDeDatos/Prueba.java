/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import Consultas.Querys;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author villalobos28
 */
public class Prueba {

    public static void main(String[] args) throws SQLException {
        MySQL db =  new MySQL();
        Querys querys = new Querys();
        String us = querys.ConsultaUsuario("arodymg","papa");
        DefaultTableModel tab = db.Select(us);
        if (tab.getRowCount() == 1) {
            int a = (int) tab.getValueAt(0, 0);
            System.out.println(a);
        }else{
            System.out.println("no existe");
        }
        
    }
}
