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
        return "SELECT `Autores`.`id_autor`,\n"
                + "    `Autores`.`nombre`,\n"
                + "    `Autores`.`apellido`,\n"
                + "    `Autores`.`nacionalidad`\n"
                + "FROM `bd85in3u2jlgurs2idgr`.`Autores`;";
    }
    
    /**
     * Query
     * @ConsusltaUsuario
     * @author ArodyMG
     * @01/04/2020
     * @1.0
     * @Descripción: Este query consulta el rol del usuario.
     */
    public String ConsultaUsuario(String user, String pass) {
        return "SELECT rol  "
                + " FROM bd85in3u2jlgurs2idgr.Empleados "
                + " WHERE username = '"+user+"' AND password = '"+pass+"';";
    }
}