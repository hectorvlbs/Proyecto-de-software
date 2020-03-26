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

    //  Ejemplo
    public String ConsultaAutores() {
        return "SELECT `Autores`.`id autor`,\n"
                + "    `Autores`.`nombre`,\n"
                + "    `Autores`.`apellido`,\n"
                + "    `Autores`.`nacionalidad`\n"
                + "FROM `bd85in3u2jlgurs2idgr`.`Autores`;";
    }
}
