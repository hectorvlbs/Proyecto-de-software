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
    public String insertarMafia(String Membership, String Activities, String Customs) {
        return "INSERT INTO `MafiaOrganisedCrime`.`Mafia`\n"
                + "(`Membership`,`Activities`,`Customs`)\n"
                + "VALUES\n"
                + "('" + Membership + "','" + Activities + "','" + Customs + "');";
    }
}
