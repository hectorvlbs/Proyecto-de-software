/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

/**
 *
 * @author villalobos28
 */
public class Prueba {

    public static void main(String[] args) {
        MySQL db =  new MySQL();
        db.abrir();
        db.cerrar();
    }
}
