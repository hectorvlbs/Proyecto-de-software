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
    public String InsertVenta(){
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
    public String InsertVentaLibro(){
        return "{CALL InsertVentaLibro(?,?)}";
    }
}
