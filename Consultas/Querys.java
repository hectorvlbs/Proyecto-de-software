/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

/**
 *
 * @author villalobos28
 */
//  En está clase se insertan todas las consultas que el sistema va a ejecutar
public class Querys {

    /**
     * Function
     *
     * @FunctionName RegisterEditorial
     * @Author Jesús Villalobos
     * @Date Marzo del 2020
     * @Version 1
     * @Description Regresa el query para llamar al procedure
     * RegisterEditorial()
     */
    public String RegisterEditorial() {
        return "{CALL RegisterEditorial(?,?,?,?,?)}";
    }

    /**
     * Query
     *
     * @ConsusltaUsuario
     * @author ArodyMG
     * @01/04/2020
     * @1.0
     * @Descripción: Este query consulta el rol del usuario.
     */
    public String ConsultaUsuario(String user, String pass) {
        return "SELECT rol  "
                + " FROM bd85in3u2jlgurs2idgr.Empleados "
                + " WHERE username = '" + user + "' AND password = '" + pass + "';";
    }

    /**
     * Query
     *
     * @InsertVenta
     * @author Jesús Gil
     * @ Marzo del 2020
     * @1.0
     * @Descripción: Este query Inserta una venta.
     */
    public String InsertVenta() {
        return "{CALL InsertVenta(?,?)}";
    }

    /**
     * Query
     *
     * @InsertVentaLibrp
     * @author Jesús Gil
     * @ Marzo del 2020
     * @1.0
     * @Descripción: Este query Inserta en tabla venta_libro.
     */
    public String InsertVentaLibro() {
        return "{CALL InsertVentaLibro(?,?)}";
    }

    /**
     * Function
     *
     * @FunctionName InsertEmployed
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Regresa el query para insertar datos a la tabla Empleados.
     */
    public String InsertEmployed(String nombre, String apellido, String fecha_nac, String username, String password, int sucursal, int rol) {
        return "INSERT INTO `bd85in3u2jlgurs2idgr`.`Empleados`\n"
                + "	(`nombre`,\n"
                + "	`apellido`,\n"
                + "	`fecha_nac`,\n"
                + "	`username`,\n"
                + "	`password`,\n"
                + "	`sucursal`,\n"
                + "	`rol`)\n"
                + "	VALUES\n"
                + "	('" + nombre + "',\n"
                + "	'" + apellido + "',\n"
                + "	'" + fecha_nac + "',\n"
                + "	'" + username + "',\n"
                + "	'" + password + "',\n"
                + "	" + sucursal + ",\n"
                + "	" + rol + ");";
    }

    /**
     * Function
     *
     * @FunctionName SelectSucursalName
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Regresa el query para obetener los nombres de las
     * sucursales.
     */
    public String SelectSucursalName() {
        return "SELECT `Sucursales`.`nombre`\n"
                + "FROM `bd85in3u2jlgurs2idgr`.`Sucursales`;";
    }

    /**
     * Function
     *
     * @FunctionName GetCodeSucursal
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Regresa el query para obetener el código de una sucursal.
     */
    public String GetCodeSucursal(String nombre) {
        return "SELECT `Sucursales`.`id_sucursal`\n"
                + "FROM `bd85in3u2jlgurs2idgr`.`Sucursales`\n"
                + "WHERE `Sucursales`.`nombre` = '" + nombre + "';";
    }

    /**
     * Function
     *
     * @FunctionName SelectSucursales
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Regresa el query para hacer un select a la tabla sucursales.
     */
    public String SelectSucursales() {
        return "SELECT `Sucursales`.`nombre` as 'Nombre de la sucursal',\n"
                + "		concat_ws ( '',`Sucursales`.`calle`, ', #', `Sucursales`.`numero`, ', CP. ',`Sucursales`.`codigo_postal`) as 'Dirección'\n"
                + "FROM `bd85in3u2jlgurs2idgr`.`Sucursales`;";
    }

    /**
     * Function
     *
     * @FunctionName AddSucursal
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Regresa el query para insertar una sucursal.
     */
    public String AddSucursal(String nombre, String calle, int numero, int codigo_postal) {
        return "CALL `bd85in3u2jlgurs2idgr`.`RegistrarSucursal`('" + nombre + "', '" + calle + "'," +numero + "," + codigo_postal +");";
    }
}