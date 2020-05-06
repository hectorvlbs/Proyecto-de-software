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
    public String InsertVenta() {
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
    public String InsertVentaLibro() {
        return "{CALL InsertVentaLibro(?,?)}";
    }

    /**
     * Function
     *
     * @FunctionName InsertEmployed
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Regresa el query para insertar datos a la tabla Empleados.
     */
    public String InsertEmployed(String nombre, String apellido, String fecha_nac, String username, String password, int sucursal, int rol) {
        return "INSERT INTO `bd85in3u2jlgurs2idgr`.`Empleados`\n"
                + "	(`nombre`,\n"
                + "	`apellido`,\n"
                + "	`fecha_nac`,\n"
                + "	`username`,\n"
                + "	`password`,\n"
                + "	`sucursal`,\n"
                + "	`rol`)\n"
                + "	VALUES\n"
                + "	('" + nombre + "',\n"
                + "	'" + apellido + "',\n"
                + "	'" + fecha_nac + "',\n"
                + "	'" + username + "',\n"
                + "	'" + password + "',\n"
                + "	" + sucursal + ",\n"
                + "	" + rol + ");";
    }

    /**
     * Function
     *
     * @FunctionName SelectSucursalName
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Regresa el query para obetener los nombres de las
     * sucursales.
     */
    public String SelectSucursalName() {
        return "SELECT `Sucursales`.`nombre`\n"
                + "FROM `bd85in3u2jlgurs2idgr`.`Sucursales`;";
    }

    /**
     * Function
     *
     * @FunctionName GetCodeSucursal
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Regresa el query para obetener el código de una sucursal.
     */
    public String GetCodeSucursal(String nombre) {
        return "SELECT `Sucursales`.`id_sucursal`\n"
                + "FROM `bd85in3u2jlgurs2idgr`.`Sucursales`\n"
                + "WHERE `Sucursales`.`nombre` = '" + nombre + "';";
    }

    /**
     * Function
     *
     * @FunctionName SelectSucursales
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Regresa el query para hacer un select a la tabla sucursales.
     */
    public String SelectSucursales() {
        return "SELECT `Sucursales`.`nombre` as 'Nombre de la sucursal',\n"
                + "		concat_ws ( '',`Sucursales`.`calle`, ', #', `Sucursales`.`numero`, ', CP. ',`Sucursales`.`codigo_postal`) as 'Dirección'\n"
                + "FROM `bd85in3u2jlgurs2idgr`.`Sucursales`;";
    }

    /**
     * Function
     *
     * @FunctionName AddSucursal
     * @Author Jesús Villalobos
     * @Date Abril del 2020
     * @Version 1
     * @Description Regresa el query para insertar una sucursal.
     */
    public String AddSucursal(String nombre, String calle, int numero, int codigo_postal) {
        return "CALL `bd85in3u2jlgurs2idgr`.`RegistrarSucursal`('" + nombre + "', '" + calle + "'," + numero + "," + codigo_postal + ");";
    }

    /**
     * Function
     *
     * @FunctionName ConsultaEmpleados
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para consultar empleados
     */
    public String ConsultaEmpleados() {
        return "SELECT concat(Empleados.nombre,' ',Empleados.apellido) as 'Nombre del empleado',\n"
                + "concat(Empleados.id_empleado) as 'Matrícula',\n"
                + "concat(Empleados.username) as 'Nombre de usuario',\n"
                + "concat(Empleados.password) as 'Contraseña',\n"
                + "concat(Sucursales.nombre) as 'Sucursal asignada',\n"
                + "concat(Roles.rol) as 'Rol del empleado'\n"
                + "\n"
                + "\n"
                + "FROM bd85in3u2jlgurs2idgr.Empleados  JOIN bd85in3u2jlgurs2idgr.Sucursales  ON Empleados.sucursal = Sucursales.id_sucursal\n"
                + "	JOIN bd85in3u2jlgurs2idgr.Roles ON  Empleados.rol = Roles.id_rol ORDER BY Empleados.id_empleado ASC ";
    }

    /**
     * Function
     *
     * @FunctionName ConsultaSucursales
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para consultar las sucursales y meterlas a
     * un combobox.
     */
    public String ConsultaSucursales() {
        return "SELECT Sucursales.nombre FROM bd85in3u2jlgurs2idgr.Sucursales;";
    }

    /**
     * Function
     *
     * @FunctionName UpdateEmpleado
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para editar a los empleados.
     */
    public String UpdateEmpleado(String username, String password, int sucursal, int id_empleado) {
        return "UPDATE `bd85in3u2jlgurs2idgr`.`Empleados`\n"
                + "SET\n"
                + "`username` = '" + username + "',\n"
                + "`password` = '" + password + "',\n"
                + "`sucursal` = " + sucursal + "\n"
                + "WHERE `id_empleado` = " + id_empleado + ";";
    }

    /**
     * Function
     *
     * @FunctionName CallProcedureVentasPorDia
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para obtener las ventas del día
     */
    public String CallProcedureVentasPorDia(String date) {
        return "SELECT\n"
                + "concat(Ventas.importe) as 'Importe de la venta',\n"
                + "concat(Libros.titulo) as 'Titulo del libro'\n"
                + "\n"
                + "\n"
                + " From Ventas JOIN Venta_Libro ON Ventas.id_venta = Venta_Libro.venta\n"
                + "	JOIN Libros ON Venta_Libro.libro = Libros.id_libro\n"
                + "\n"
                + " where fecha = '" + date + "' ;";
    }

    /**
     * Function
     *
     * @FunctionName InventarioDeLibros
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para obtener el inventario de libros
     */
    public String InventarioDeLibros() {
        return "SELECT\n"
                + "concat(L.titulo, '. Edición: ',L.edicion, '. Editorial: ',E.nombre) AS 'Libro',\n"
                + "concat(S.nombre) AS 'Sucursal en existencia',\n"
                + "concat(I.cantidad) AS 'Cantidad de libros'\n"
                + "FROM Inventario AS I JOIN Sucursales AS S ON I.sucursal = S.id_sucursal\n"
                + "	JOIN Libros AS L ON I.libro = L.id_libro\n"
                + "    JOIN Editoriales AS E ON L.editorial = E.id_editorial";
    }

    /**
     * Function
     *
     * @FunctionName CategoriaLibrosMasVendidos
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para obtener la categoría de libros más
     * vendidos
     */
    public String CategoriaLibrosMasVendidos() {
        return "SELECT concat(Categorias.tipo) AS 'Categoria', count(Libros.id_libro) as 'Total de ejemplares vendidos' \n"
                + "    FROM Venta_Libro INNER JOIN Libros ON Libros.id_libro = Venta_Libro.libro\n"
                + "    INNER JOIN Categorias ON Categorias.id_categoria = Libros.categoria\n"
                + "	GROUP BY Categorias.id_categoria\n"
                + "    ORDER BY count(Categorias.id_categoria)  DESC;";
    }

    /**
     * Function
     *
     * @FunctionName CategoriaLibrosMenosVendidos
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para obtener la categoría de libros menos
     * vendidos
     */
    public String CategoriaLibrosMenosVendidos() {
        return "SELECT concat(Categorias.tipo) AS 'Categoria', count(Libros.id_libro) as 'Total de ejemplares vendidos' \n"
                + "    FROM Venta_Libro INNER JOIN Libros ON Libros.id_libro = Venta_Libro.libro\n"
                + "    INNER JOIN Categorias ON Categorias.id_categoria = Libros.categoria\n"
                + "	GROUP BY Categorias.id_categoria\n"
                + "    ORDER BY count(Categorias.id_categoria)  ASC;";
    }

    /**
     * Function
     *
     * @FunctionName LibrosMasVendidos
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para obtener los libros más vendidos
     */
    public String LibrosMasVendidos() {
        return "SELECT concat(Libros.titulo) AS 'Titulo', concat(Autores.nombre) AS 'Autor', count(Venta_Libro.libro) AS 'Ejemplares vendidos'\n"
                + "FROM Venta_Libro INNER JOIN Libros ON Libros.id_libro = Venta_Libro.libro\n"
                + "INNER JOIN Autores ON Libros.autor = Autores.id_autor\n"
                + "GROUP BY Venta_Libro.libro\n"
                + "ORDER BY count(Venta_Libro.libro)  DESC;";
    }

    /**
     * Function
     *
     * @FunctionName LibrosMenosVendidos
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para obtener los libros menos vendidos
     */
    public String LibrosMenosVendidos() {
        return "SELECT concat(Libros.titulo) AS 'Titulo', concat(Autores.nombre) AS 'Autor', count(Venta_Libro.libro) AS 'Ejemplares vendidos'\n"
                + "FROM Venta_Libro INNER JOIN Libros ON Libros.id_libro = Venta_Libro.libro\n"
                + "INNER JOIN Autores ON Libros.autor = Autores.id_autor\n"
                + "GROUP BY Venta_Libro.libro\n"
                + "ORDER BY count(Venta_Libro.libro) ASC;";
    }

    /**
     * Function
     *
     * @FunctionName EditorialesConMasLibrosVendidos
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para obtener las editoriales con más libros
     * vendidos.
     */
    public String EditorialesConMasLibrosVendidos() {
        return "SELECT concat(Editoriales.nombre) AS 'Editorial', count(Editoriales.id_editorial) AS 'Ejemplares vendidos' \n"
                + "FROM Venta_Libro INNER JOIN Libros ON Libros.id_libro = Venta_Libro.libro\n"
                + "INNER JOIN Editoriales ON Editoriales.id_editorial = Libros.editorial\n"
                + "GROUP BY Editoriales.id_editorial\n"
                + "ORDER BY count(Editoriales.id_editorial) DESC;";
    }

    /**
     * Function
     *
     * @FunctionName EditorialesConMenosLibrosVendidos
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para obtener las editoriales con menos
     * libros vendidos.
     */
    public String EditorialesConMenosLibrosVendidos() {
        return "SELECT concat(Editoriales.nombre) AS 'Editorial', count(Editoriales.id_editorial) AS 'Ejemplares vendidos' \n"
                + "FROM Venta_Libro INNER JOIN Libros ON Libros.id_libro = Venta_Libro.libro\n"
                + "INNER JOIN Editoriales ON Editoriales.id_editorial = Libros.editorial\n"
                + "GROUP BY Editoriales.id_editorial\n"
                + "ORDER BY count(Editoriales.id_editorial) ASC;";
    }

    /**
     * Function
     *
     * @FunctionName VentasPorEmpleado
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para obtener las ventas por empleado.
     */
    public String VentasPorEmpleado() {
        return "SELECT \n"
                + "    concat(Venta_Empleado.venta) AS 'ID de la venta',\n"
                + "    concat(Empleados.nombre, ' ', Empleados.apellido) AS 'Nombre del empleado',\n"
                + "    concat(Ventas.fecha) AS 'Fecha de la venta',\n"
                + "    concat(Ventas.importe) AS 'Importe'\n"
                + "    From Empleados\n"
                + "    INNER JOIN Venta_Empleado ON Venta_Empleado.empleado = Empleados.id_empleado\n"
                + "    INNER JOIN Ventas ON Ventas.id_venta = Venta_Empleado.venta";
    }

    /**
     * Function
     *
     * @FunctionName VentasPorPeriodoDeTiempo
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para obtener las ventas por un periodo de
     * tiempo.
     */
    public String VentasPorPeriodoDeTiempo(String date1, String date2) {
        return "SELECT\n"
                + "concat(Ventas.id_venta) AS 'ID de la venta',\n"
                + "concat(Ventas.importe) AS 'Importe de venta',\n"
                + "concat(Ventas.fecha) AS 'Fecha de la venta'\n"
                + "FROM Ventas WHERE Ventas.fecha BETWEEN '" + date1 + "' AND '" + date2 + "'";
    }

    /**
     * Function
     *
     * @FunctionName AgregaEditorial
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para agregar una nueva editorial.
     */
    public String AgregaEditorial(String Nombre, String Calle, int Numero, int Cp, String NContacto) {
        return "INSERT INTO `bd85in3u2jlgurs2idgr`.`Editoriales`\n"
                + "(`nombre`,`calle`,`numero`,`codigo_postal`,`telefono`)\n"
                + "VALUES\n"
                + "('" + Nombre + "','" + Calle + "'," + Numero + "," + Cp + ",'" + NContacto + "');";
    }

    /**
     * Function
     *
     * @FunctionName SelectEditoriales
     * @Author Jesús Villalobos
     * @Date MAyo del 2020
     * @Version 1
     * @Description Regresa el query para consultar las editoriales.
     */
    public String SelectEditoriales() {
        return "SELECT\n"
                + "concat(Editoriales.nombre) AS 'Nombre',\n"
                + "concat(Editoriales.calle, ' #', Editoriales.numero, ' Cp.', Editoriales.codigo_postal) AS 'Dirección',\n"
                + "concat(Editoriales.telefono) AS 'Número de contacto'\n"
                + "FROM bd85in3u2jlgurs2idgr.Editoriales;";
    }

    public String SelectLibros() {
        return "SELECT \n"
                + "concat(Libros.isbn) AS 'Isbn',\n"
                + "concat(Libros.titulo) AS 'Titulo'\n"
                + "\n"
                + "FROM bd85in3u2jlgurs2idgr.Libros;";
    }

    public String Pedido(int sucursal, int libro, int cantidad) {
        return "INSERT INTO `bd85in3u2jlgurs2idgr`.`Inventario`\n"
                + "(`sucursal`,`libro`,`cantidad`)\n"
                + "VALUES\n"
                + "("+sucursal+","+libro+","+cantidad+");";
    }
    
    public String InsertInventario (){
        return "{CALL `bd85in3u2jlgurs2idgr`.`InsertInventario`(?,?,?)}";
    }
}
