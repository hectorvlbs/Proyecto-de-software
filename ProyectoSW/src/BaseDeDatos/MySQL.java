/*
    Clase que hace la conexión con la base de datos.
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Class
 * @ClassName       MySQL
 * @Author          Jesús Villalobos
 * @Date            Marzo del 2020
 * @Version         1
 * @Description     Está clase se encarga de la conexión con la base de datos.
 *                  Funciona no mover en caso de querer hacer otro tipo de query.
 */

public class MySQL {

    public static Connection Connection;
    public static final String Host = "bd85in3u2jlgurs2idgr-mysql.services.clever-cloud.com";
    public static final String DataBaseName = "bd85in3u2jlgurs2idgr";
    public static final String User = "uzvzz1gsmduzxxd6";
    public static final String Password = "CbNbdnUOv2sQmaPXriq5";
    public static final String Port = "3306";

    public Connection Open() {
        String Url = "jdbc:mysql://" + Host + ":" + Port + "/" + DataBaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection = (Connection) DriverManager.getConnection(Url, User, Password);
            System.out.println("Conexión a MySQL");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return Connection;
    }

    public void Close() {
        try {
            if (Connection != null) {
                Connection.close();
                System.out.println("Se cerro.");
            }
        } catch (SQLException ex) {
            System.out.println("Excepción: " + ex.toString());
        }
    }

    public boolean Update(String queryString) throws SQLException {
        Connection = Open();
        PreparedStatement pstm = Connection.prepareStatement(queryString);
        if (pstm.executeUpdate() == 1) {
            //miConexion
            return true;
        }
        return false;
    }

    public boolean Login(String queryString) throws SQLException {
        Statement st = null;
        ResultSet rs = null;
        try {
            Connection = Open();
            st = Connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(queryString);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Excepción: " + ex.toString());
        }
        return false;
    }
    
    public boolean Insert(String queryString) throws SQLException {
        Statement st = null;
        int regreso = 0;
        try {
            Connection = Open();
            // Inicializar Statement y Resulset
            st = Connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            regreso = st.executeUpdate(queryString);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Excepción: " + ex.toString());
            // System.out.println("Excepción: " + ex.toString());
        } finally {
            // Cierra o null los objetos
            try {
                if (st != null) {
                    st.close();
                }
                if (Connection != null) {
                    Connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Excepción: " + ex.toString());
            }
        }
        if (regreso > 0) {return true;}
        return false;
    }
    
    public DefaultTableModel Select(String queryString) throws SQLException {
        Statement st = null;
        ResultSet rs = null;
        DefaultTableModel dtm = new DefaultTableModel();
        try { // try-catch-finally
            Connection = Open();
            // Inicializar Statement y Resulset
            st = Connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            // rs = st.executeQuery( "SELECT expediente, nombre, sexo, activo FROM Alumno");
            rs = st.executeQuery(queryString);
            // Obtiene Meta Datos de la consulta que regresa.
            // En ete caso Número y Nombre de Columnas
            ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
            // Agregamos las columas en mi modelo de datos
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                dtm.addColumn(rsmd.getColumnName(i));
            }
            // Agregamos los registos al modelo de datos
            int numeroRegistros = 0;
            if (rs.last()) // Pone el cursor en el último registro
            {
                numeroRegistros = rs.getRow(); // Obtiene el número de registros
            }
            rs.beforeFirst(); // Pone el cursor antes del primer registo

            if (numeroRegistros > 0) {
                // Se utiliza un arreglo de Object para obtener los datos, ya que son de diferentes tipos
                Object[] registros = new Object[rsmd.getColumnCount()];
                while (rs.next()) {
                    // Por cada columna obtiene el valor de la celda
                    for (int i = 0; i < rsmd.getColumnCount(); i++) {
                        // registros obtiene i, ya que un arreglo empieza en la posición 0
                        // rs.getObject(i+1) ya que la columna empieza en 1, no 0
                        registros[i] = rs.getObject(i + 1);
                    }
                    // Agrega un registro de datos al modelo
                    dtm.addRow(registros);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Excepción: " + ex.toString());
            System.out.println("Excepción: " + ex.toString());
        } finally {
            // Cierra o null los objetos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (Connection != null) {
                    Connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("Excepción: " + ex.toString());
            }
        }
        return dtm;
    }
}
