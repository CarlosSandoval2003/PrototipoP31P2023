/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsClientes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoClientes {

    private static final String SQL_SELECT = "SELECT codigo_cliente, nombre_cliente, direccion_cliente, telefono_cliente, nit_cliente, estatus_cliente FROM clientes";
    private static final String SQL_INSERT = "INSERT INTO clientes (codigo_cliente, nombre_cliente, direccion_cliente, telefono_cliente, nit_cliente, estatus_cliente) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET nombre_cliente=?, direccion_cliente=?, telefono_cliente=?, nit_cliente=?, estatus_cliente=? WHERE codigo_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE codigo_cliente=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_cliente, nombre_cliente, direccion_cliente, telefono_cliente, nit_cliente, estatus_cliente FROM clientes WHERE nombre_cliente = ?";
    private static final String SQL_SELECT_CODIGO = "SELECT codigo_cliente, nombre_cliente, direccion_cliente, telefono_cliente, nit_cliente, estatus_cliente FROM clientes WHERE codigo_cliente = ?";    

    public List<clsClientes> consultaVendedor() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsClientes> vendedoress = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_vendedor");
                String nombre = rs.getString("nombre_vendedor");
                String direccion = rs.getString("direccion_vendedor");
                String telefono = rs.getString("telefono_vendedor");
                String nit = rs.getString("nit_vendedor");
                String estatus = rs.getString("estatus_vendedor");
                clsClientes vendedores = new clsClientes();
                vendedores.setCodigoVendedores(codigo);
                vendedores.setNombreVendedores(nombre);
                vendedores.setDireccionVendedores(direccion);
                vendedores.setTelefonoVendedores(telefono);
                vendedores.setNitVendedores(nit);
                vendedores.setEstatusVendedores(estatus);
                vendedoress.add(vendedores);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return vendedoress;
    }

    public int ingresaVendedor(clsClientes vendedores) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vendedores.getCodigoVendedores());
            stmt.setString(2, vendedores.getNombreVendedores());
            stmt.setString(3, vendedores.getDireccionVendedores());
            stmt.setString(4, vendedores.getTelefonoVendedores());
            stmt.setString(5, vendedores.getNitVendedores());
            stmt.setString(6, vendedores.getEstatusVendedores());

            
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

    public int actualizaVendedor(clsClientes vendedores) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vendedores.getNombreVendedores());
            stmt.setString(2, vendedores.getDireccionVendedores());
            stmt.setString(3, vendedores.getTelefonoVendedores());
            stmt.setString(4, vendedores.getNitVendedores());
            stmt.setString(5, vendedores.getEstatusVendedores());
            stmt.setString(6, vendedores.getCodigoVendedores());

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

    public int borrarVendedor(clsClientes vendedores) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, vendedores.getCodigoVendedores());
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

    public clsClientes consultaVendedorPorNombre(clsClientes vendedores) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + vendedores);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, vendedores.getNombreVendedores());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_vendedor");
                String nombre = rs.getString("nombre_vendedor");
                String direccion = rs.getString("direccion_vendedor");
                String telefono = rs.getString("telefono_vendedor");
                String nit = rs.getString("nit_vendedor");
                String estatus = rs.getString("estatus_vendedor");

                //usuario = new clsUsuario();
                vendedores.setCodigoVendedores(codigo);
                vendedores.setNombreVendedores(nombre);
                vendedores.setDireccionVendedores(direccion);
                vendedores.setTelefonoVendedores(telefono);
                vendedores.setNitVendedores(nit);
                vendedores.setEstatusVendedores(estatus);
                System.out.println(" registro consultado: " + vendedores);                
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
        return vendedores;
    }
    public clsClientes consultaVendedorPorCodigo(clsClientes vendedores) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + vendedores);
            stmt = conn.prepareStatement(SQL_SELECT_CODIGO);
            stmt.setString(1, vendedores.getCodigoVendedores());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_vendedor");
                String nombre = rs.getString("nombre_vendedor");
                String direccion = rs.getString("direccion_vendedor");
                String telefono = rs.getString("telefono_vendedor");
                String nit = rs.getString("nit_vendedor");
                String estatus = rs.getString("estatus_vendedor");

                //usuario = new clsUsuario();
                vendedores.setCodigoVendedores(codigo);
                vendedores.setNombreVendedores(nombre);
                vendedores.setDireccionVendedores(direccion);
                vendedores.setTelefonoVendedores(telefono);
                vendedores.setNitVendedores(nit);
                vendedores.setEstatusVendedores(estatus);
                System.out.println(" registro consultado: " + vendedores);                 
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
        return vendedores;
    }    
}
