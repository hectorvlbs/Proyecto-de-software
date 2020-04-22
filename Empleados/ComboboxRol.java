/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empleados;

import javax.swing.JComboBox;

/**
 *
 * @author villalobos28
 */
public class ComboboxRol {

    /**
     * Function
     *
     * @FunctionName FillComboboxRol
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Está función llena el combobox para los roles de empleado
     */
    public static void FillComboboxRol(JComboBox Rol) {
        Rol.removeAllItems();
        Rol.addItem("Empleado");
        Rol.addItem("Administrador");
    }

    /**
     * Function
     *
     * @FunctionName FillComboboxRol
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Está función llena el combobox para los roles de empleado
     */
    public int GetRolCode(JComboBox Rol) {
        int rol = 0;
        if (Rol.getSelectedItem().equals("Empleado")) {
            rol = 1;
        } else{
            rol = 2;
        }
        
        return rol;
    }
}
