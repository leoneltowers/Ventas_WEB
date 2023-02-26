package com.app.productos.modeloDAO;

import com.app.productos.config.ConectarBD;
import com.app.productos.interfaces.ICategoria;
import com.app.productos.modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CategoriaDAO implements ICategoria {

    private static final Logger LOG = Logger.getGlobal();

    @Override
    public List<Categoria> getCategoria() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "select * from categoria";
        try {
            Connection con = ConectarBD.Conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setIdcat(rs.getInt(1));
                c.setCategoria(rs.getString(2));
                c.setEstadocat("1".equals(rs.getString(3)) ? "ACTIVO" : "INACTIVO");
                categorias.add(c);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            LOG.info("Error getEmpleadoUserPass:".concat(e.toString()));
        }
        return categorias;
    }

    @Override
    public Categoria getCategoriaId(int id) {
        Categoria categoria = null;
        String sql = "select * from categoria where i_num_id_cat=?";
        try {
            Connection con = ConectarBD.Conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categoria = new Categoria(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            LOG.info("Error getEmpleadoUserPass:".concat(e.toString()));
        }
        return categoria;
    }

    @Override
    public int saveCategoria(Categoria c) {
        int r = 0;
        String sqlInsert = "INSERT INTO categoria(c_descripcion,c_estado)values(?,?)";
        String sqlUpdate = "update categoria set c_descripcion=?,c_estado=? where i_num_id_cat=?";
        try {
            Connection con = ConectarBD.Conectar();
            PreparedStatement ps;
            if (c.getIdcat() != 0) {
                ps = con.prepareStatement(sqlUpdate);
                ps.setString(1, c.getCategoria());
                ps.setString(2, c.getEstadocat());
                ps.setInt(3, c.getIdcat());
                r = ps.executeUpdate();
                ps.close();
            } else {
                ps = con.prepareStatement(sqlInsert);
                ps.setString(1, c.getCategoria());
                ps.setString(2, c.getEstadocat());
                r = ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            r=0;
            LOG.info("Error getEmpleadoUserPass:".concat(e.toString()));
        }
        return r;
    }

    @Override
    public int deleteCategoriaId(int id) {
        int r = 0;
        String sql = "delete from categoria where i_num_id_cat=?";
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
