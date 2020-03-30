 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

/**
 * Class
 *
 * @ClassName Querys
 * @Author Jesús Villalobos
 * @Date Marzo del 2020
 * @Version 1
 * @Description En está clase se guardan todas las querys de MySQL que el sistema
 *              va a utilizar.
 */

public class Querys {

    /**
     * Function
     *
     * @FunctionName SelectAuthors
     * @Author Jesús Villalobos
     * @Date Marzo del 2020
     * @Version 1
     * @Description Este es un ejemplo de como van a estar declaradas las querys; tienen
     *              que estar en manera de función que regrese un string con la query lista para
     *              mandarla a la base de datos.
     */
    public String SelectAuthors() {
        return "SELECT `Autores`.`id autor`,\n"
                + "    `Autores`.`nombre`,\n"
                + "    `Autores`.`apellido`,\n"
                + "    `Autores`.`nacionalidad`\n"
                + "FROM `bd85in3u2jlgurs2idgr`.`Autores`;";
    }
    
    /**
     * Function
     *
     * @FunctionName RegisterEditorial
     * @Author Jesús Villalobos
     * @Date Marzo del 2020
     * @Version 1
     * @Description Regresa el query para llamar al procedure RegisterEditorial()
     */
    public String RegisterEditorial(){
        return "{CALL RegisterEditorial(?,?,?,?,?)}";
    }
    
}
