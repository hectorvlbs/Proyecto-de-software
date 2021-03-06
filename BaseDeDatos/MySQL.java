/*
    Clase que hace la conexión con la base de datos.
 */
package BaseDeDatos;

import Consultas.Querys;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Class
 *
 * @ClassName MySQL
 * @Author Jesús Villalobos
 * @Date Marzo del 2020
 * @Version 1
 * @Description Está clase se encarga de la conexión con la base de datos.
 * Funciona no mover en caso de querer hacer otro tipo de query.
 */
public class MySQL {

    static Connection Connection;
    static final String Host = "bd85in3u2jlgurs2idgr-mysql.services.clever-cloud.com";
    static final String DataBaseName = "bd85in3u2jlgurs2idgr";
    static final String User = "uzvzz1gsmduzxxd6";
    static final String Password = "CbNbdnUOv2sQmaPXriq5";
    static final String Port = "3306";

    Querys querys = new Querys();

    /**
     * Function
     *
     * @FunctionName Open
     * @Author Jesús Villalobos
     * @Date Marzo del 2020
     * @Version 1
     * @Description Está función abre la conexión con la base de datos
     */
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

    /**
     * Function
     *
     * @FunctionName Close
     * @Author Jesús Villalobos
     * @Date Marzo del 2020
     * @Version 1
     * @Description Está función cierra la conexión con la base de datos
     */
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

    /**
     * Function
     *
     * @FunctionName Update
     * @Author Jesús Villalobos
     * @Date Marzo del 2020
     * @Version 1
     * @Description Está actualiza tablas en la base de datos y regresa un valor
     * de tipo booleano en caso de hacerse o no el update.
     */
    public boolean Update(String queryString) throws SQLException {
        Connection = Open();
        PreparedStatement pstm = Connection.prepareStatement(queryString);
        if (pstm.executeUpdate() == 1) {
            //miConexion
            return true;
        }
        return false;
    }

    /**
     * Function
     *
     * @FunctionName Login
     * @Author Jesús Villalobos
     * @Date Marzo del 2020
     * @Version 1
     * @Description Está función se encargar del inicio de sesión de los
     * usuarios en el sistema verficiando en la base de datos; regresa un valor
     * de tipo booleano si se hace o no el login.
     */
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

    /**
     * Function
     *
     * @FunctionName Inserta
     * @Author Jesús Villalobos
     * @Date Marzo del 2020
     * @Version 1
     * @Description Está función inserta datos en la base de datos; regresa un
     * valor de tipo booleano en caso de hacerse o no el insert.
     */
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
        if (regreso > 0) {
            return true;
        }
        return false;
    }

    /**
     * Function
     *
     * @FunctionName Select
     * @Author Jesús Villalobos
     * @Date Marzo del 2020
     * @Version 1
     * @Description Está función hace una consulta de datos y las inserta en un
     * 'DefaultTableModel'.
     */
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

    /**
     * Function
     *
     * @FunctionName ProcedureRegisterEditorial
     * @Author Jesús Villalobos
     * @Date Marzo del 2020
     * @Version 1
     * @Description Está función ejecuta el procedure RegisterEditorial
     * FUNCIONA; NO MOVER.
     */
    public boolean ProcedureRegisterEditorial(String Nombre, String Calle, int Numero, int CP, String Telefono) {
        Connection = Open();
        try {
            CallableStatement stmt = Connection.prepareCall(querys.RegisterEditorial());
            stmt.setString(1, Nombre);
            stmt.setString(2, Calle);
            stmt.setInt(3, Numero);
            stmt.setInt(4, CP);
            stmt.setString(5, Telefono);
            if (stmt.execute() == false) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Function
     *
     * @FunctionName ProcedureRegisterVenta
     * @Author Jesús Gil
     * @Date Marzo del 2020
     * @Version 1
     * @Description Está función registra una venta y obtiene su id FUNCIONA; NO
     * MOVER.
     */
    public int ProcedureRegisterVenta(float money) {
        Connection = Open();
        int regreso = 0;
        try {
            CallableStatement stmt = Connection.prepareCall(querys.InsertVenta());
            stmt.setFloat(1, money);
            stmt.registerOutParameter(2, Types.INTEGER);
            stmt.execute();
            regreso = stmt.getInt(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regreso;
    }

    /**
     * Function
     *
     * @FunctionName ProcedureRegisterVentaLibro
     * @Author Jesús Gil
     * @Date Marzo del 2020
     * @Version 1
     * @Description Está función registra en tabla venta_libros FUNCIONA; NO
     * MOVER.
     */
    public boolean ProcedureRegisterVentaLibro(int venta, int libro) {
        Connection = Open();
        int regreso = 0;
        try {
            CallableStatement stmt = Connection.prepareCall(querys.InsertVentaLibro());
            stmt.setInt(1, venta);
            stmt.setInt(2, libro);
            if (stmt.execute() == false) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean ProcedureInsertInventario(int sucursal, String isbn, int cantidad) {
        Connection = Open();
        try {
            CallableStatement stmt = Connection.prepareCall(querys.InsertInventario());
            stmt.setInt(1, sucursal);
            stmt.setString(2, isbn);
            stmt.setInt(3, cantidad);
            if (stmt.execute() == false) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
