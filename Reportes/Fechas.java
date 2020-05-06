/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

/**
 *
 * @author villalobos28
 */
public class Fechas {

    /**
     * Function
     *
     * @FunctionName Birthdate
     * @Author Jesús Villalobos
     * @Date Marzo del 2020
     * @Version 1
     * @Description Está regresa la fecha con el formato de MySQL.
     */
    public String Birthdate(String date) {
        String birthdate = "";
        String[] parts = date.split(" ");

        String Month = parts[1];
        String Day = parts[2];
        String Year = parts[5];

        if (Month.equals("Jan")) {
            birthdate = Year + "-01-" + Day;
        } else if (Month.equals("Feb")) {
            birthdate = Year + "-02-" + Day;
        } else if (Month.equals("Mar")) {
            birthdate = Year + "-03-" + Day;
        } else if (Month.equals("Apr")) {
            birthdate = Year + "-04-" + Day;
        } else if (Month.equals("May")) {
            birthdate = Year + "-05-" + Day;
        } else if (Month.equals("Jun")) {
            birthdate = Year + "-06-" + Day;
        } else if (Month.equals("Jul")) {
            birthdate = Year + "-07-" + Day;
        } else if (Month.equals("Aug")) {
            birthdate = Year + "-08-" + Day;
        } else if (Month.equals("Sep")) {
            birthdate = Year + "-09-" + Day;
        } else if (Month.equals("Oct")) {
            birthdate = Year + "-10-" + Day;
        } else if (Month.equals("Nov")) {
            birthdate = Year + "-11-" + Day;
        } else if (Month.equals("Dec")) {
            birthdate = Year + "-12-" + Day;
        }

        return birthdate;
    }
}
