package com.app.productos.modeloDAO;

import com.app.productos.config.ConectarBD;
import com.app.productos.interfaces.IProducto;
import com.app.productos.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductoDAO implements IProducto {

    private static final Logger LOG = Logger.getGlobal();

    @Override
    public List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT p.i_num_id_prod,p.c_nombre,p.c_descripcion,p.n_precio,c.c_descripcion,p.c_estado,c.i_num_id_cat \n"
                + "FROM producto p INNER JOIN categoria c \n"
                + "ON p.i_num_id_cat=c.i_num_id_cat;";
        try {
            Connection con = ConectarBD.Conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("p.i_num_id_prod"));
                p.setNombre(rs.getString("p.c_nombre"));
                p.setDescripcion(rs.getString("p.c_descripcion"));
                p.setPrecio(rs.getDouble("p.n_precio"));
                p.setCategoria(rs.getString("c.c_descripcion"));
                p.setEstado("1".equals(rs.getString("p.c_estado")) ? "ACTIVO" : "INACTIVO");
                p.setIdcat(rs.getInt("c.i_num_id_cat"));
                productos.add(p);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            LOG.info("Error getEmpleadoUserPass:".concat(e.toString()));
        }
        return productos;
    }

    @Override
    public Producto getProductoId(int id) {
        Producto p = null;
        String sql = "SELECT p.i_num_id_prod,p.c_nombre,p.c_descripcion,p.n_precio,c.c_descripcion,p.c_estado,c.i_num_id_cat \n"
                + "FROM producto p INNER JOIN categoria c \n"
                + "ON p.i_num_id_cat=c.i_num_id_cat WHERE p.i_num_id_prod=?";
        try {
            Connection con = ConectarBD.Conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p = new Producto();
                p.setId(rs.getInt("p.i_num_id_prod"));
                p.setNombre(rs.getString("p.c_nombre"));
                p.setDescripcion(rs.getString("p.c_descripcion"));
                p.setPrecio(rs.getDouble("p.n_precio"));
                p.setCategoria(rs.getString("c.c_descripcion"));
                p.setEstado(rs.getString("p.c_estado"));
                p.setIdcat(rs.getInt("c.i_num_id_cat"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            LOG.info("Error getEmpleadoUserPass:".concat(e.toString()));
        }
        return p;

    }

    @Override
    public int saveProducto(Producto p) {
        int r = 0;
        PreparedStatement ps;
        String sql;
        try {
            Connection con = ConectarBD.Conectar();            
            if (p.getId() == 0) {
                sql="INSERT INTO producto(c_nombre,c_descripcion,n_precio,i_num_id_cat,c_estado)values(?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, p.getNombre());
                ps.setString(2, p.getDescripcion());
                ps.setDouble(3, p.getPrecio());
                ps.setInt(4, p.getIdcat());
                ps.setString(5, p.getEstado());                
                r = ps.executeUpdate();
                ps.close();
            } else {
                sql="update producto set c_nombre=?, c_descripcion=?,n_precio=?,i_num_id_cat=?, c_estado=? where i_num_id_prod=?";
                ps = con.prepareStatement(sql);
                if (ps != null) {                    
                    ps.setString(1, p.getNombre());
                    ps.setString(2, p.getDescripcion());
                    ps.setDouble(3, p.getPrecio());
                    ps.setInt(4, p.getIdcat());
                    ps.setString(5, p.getEstado());
                    ps.setInt(6, p.getId());
                    r = ps.executeUpdate();
                    ps.close();
                }
            }
            con.close();
        } catch (SQLException e) {
            r=0;
            LOG.info("Error getEmpleadoUserPass:".concat(e.toString()));
        }
        return r;
    }

    @Override
    public int deleteProductoId(int id) {
         int r = 0;
        String sql = "delete from producto where i_num_id_prod=?";
        try {
            Connection con = ConectarBD.Conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            r = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            r=0;
            LOG.info("Error getEmpleadoUserPass:".concat(e.toString()));
        }
        return r;
    }
}
