/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import BaseDeDatos.MySQL;
import Consultas.Querys;
import Sucursales.Sucursales;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author villalobos28
 */
public class EjecutaReporte {

    public DefaultTableModel EjecutaReporte(String query) {
        DefaultTableModel dtm = null;
        try {
            MySQL mysql = new MySQL();
            dtm = mysql.Select(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(Sucursales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }
}
