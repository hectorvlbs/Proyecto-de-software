
package Login;

import BaseDeDatos.MySQL;
import Consultas.Querys;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


/**
 * Class
 * @MetodoLogin
 * @author ArodyMG
 * @31/03/2020
 * @1.0
 * @Descripción: Aqui se encuentran las funciones para realizar
 *                 el inicio de sesión. 
 */
public class MetodoLogin {
    
    /**
     * Function
     * @existUser
     * @author ArodyMG
     * @31/03/2020
     * @1.0
     * @Descripción: Esta funcion regresa si el usuario existe
     *                 base de datos.
     */
    public static boolean exitsUser(String username, String password) throws SQLException{
        boolean exists;
        
        MySQL db =  new MySQL();
        Querys query = new Querys();
        String us = query.ConsultaUsuario(username,password);
        exists = db.iniciarSesion(us);
        
        return exists;
    }
    
    /**
     * Function
     * @rolUser
     * @author ArodyMG
     * @31/03/2020
     * @1.0
     * @Descripción: Esta funcion regresa el rol del empleado.
     */
    public static int rolUser(String username, String password) throws SQLException {
        int rol = 0;
        MySQL dbs =  new MySQL();
        Querys query = new Querys();
        String us = query.ConsultaUsuario(username,password);
        DefaultTableModel tab = dbs.Select(us);
        if (tab.getRowCount() == 1) {
            rol = (int) tab.getValueAt(0, 0);
        }
        return rol;
    }
    
}
