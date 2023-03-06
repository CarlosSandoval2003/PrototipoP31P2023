/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsLineas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoLineas {

    private static final String SQL_SELECT = "SELECT codigo_marca, nombre_marca, estatus_marca FROM marcas";
    private static final String SQL_INSERT = "INSERT INTO marcas(codigo_marca, nombre_marca, estatus_marca) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE marcas SET nombre_marca=?, estatus_marca=? WHERE codigo_marca = ?";
    private static final String SQL_DELETE = "DELETE FROM marcas WHERE codigo_marca=?";
    private static final String SQL_SELECT_NOMBRE = "codigo_marca, nombre_marca, estatus_marca FROM marcas WHERE nombre_marca = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_marca, nombre_marca, estatus_marca FROM marcas WHERE codigo_marca = ?";    

    public List<clsLineas> consultaMarcas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsLineas> secciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_marca");
                String nombre = rs.getString("nombre_marca");
                String estatus = rs.getString("estatus_marca");
                clsLineas seccion = new clsLineas();
                seccion.setCodigoMarca(codigo);
                seccion.setNombreMarca(nombre);
                seccion.setEstatusMarca(estatus);
                secciones.add(seccion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return secciones;
    }

    public int ingresaMarcas(clsLineas seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, seccion.getCodigoMarca());
            stmt.setString(2, seccion.getNombreMarca());
            stmt.setString(3, seccion.getEstatusMarca());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaMarcas(clsLineas seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, seccion.getNombreMarca());
            stmt.setString(2, seccion.getEstatusMarca());
            stmt.setString(3, seccion.getCodigoMarca());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarMarcas(clsLineas seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, seccion.getCodigoMarca());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsLineas consultaMarcasPorNombre(clsLineas seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + seccion);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, seccion.getNombreMarca());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("codigo_marca");
                String nombre = rs.getString("nombre_marca");
                String estatus = rs.getString("estatus_marca");

                //usuario = new clsUsuario();
                seccion.setCodigoMarca(id);
                seccion.setNombreMarca(nombre);
                seccion.setEstatusMarca(estatus);
                System.out.println(" registro consultado: " + seccion);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return seccion;
    }
    public clsLineas consultaMarcasPorId(clsLineas seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + seccion);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setString(1, seccion.getCodigoMarca());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("codigo_marca");
                String nombre = rs.getString("nombre_marca");
                String estatus = rs.getString("estatus_marca");

                //usuario = new clsUsuario();
                seccion.setCodigoMarca(id);
                seccion.setNombreMarca(nombre);
                seccion.setEstatusMarca(estatus);
                System.out.println(" registro consultado: " + seccion);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return seccion;
    }    
}
