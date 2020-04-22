/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleados;

import BaseDeDatos.MySQL;
import Consultas.Querys;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author villalobos28
 */
public class ComboboxSucursal {

    private static Querys querys = new Querys();
    private static MySQL mysql = new MySQL();
    private static String query = querys.SelectSucursalName();
    private static String query2;
    private static DefaultTableModel DefaultTableModel;

    /**
     * Function
     *
     * @FunctionName FillComboboxSucursal
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Está función llena el combobox para los roles de empleado
     */
    public static void FillComboboxRol(JComboBox Sucursal) throws SQLException {
        Sucursal.removeAllItems();
        String sucursales = GetSucursal();
        String[] parts = sucursales.split("-");
        for (int i = 0; i < parts.length; i++) {
            Sucursal.addItem(parts[i]);
        }
    }

    /**
     * Function
     *
     * @FunctionName GetSucursal
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Está función obtiene una cadena de String con todas las
     * sucursales.
     */
    public static String GetSucursal() throws SQLException {
        String sucursales = "";
        DefaultTableModel = mysql.Select(query);

        for (int i = 0; i < DefaultTableModel.getColumnCount(); i++) {
            for (int j = 0; j < DefaultTableModel.getRowCount(); j++) {
                sucursales = sucursales + "-" + DefaultTableModel.getValueAt(j, i);
            }
        }

        return sucursales;
    }

    /**
     * Function
     *
     * @FunctionName GetCodeSucursal
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Está función obtiene el codigo de una sucursal
     */
    public int GetCodeSucursal(String nombre) throws SQLException {
        int code = 0;
        query2 = querys.GetCodeSucursal(nombre);
        DefaultTableModel = mysql.Select(query2);
        code = (int) DefaultTableModel.getValueAt(0, 0);
        return code;
    }

}
