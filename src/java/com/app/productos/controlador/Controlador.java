package com.app.productos.controlador;

import com.app.productos.interfaces.ICategoria;
import com.app.productos.interfaces.IProducto;
import com.app.productos.modelo.Categoria;
import com.app.productos.modelo.Producto;
import com.app.productos.modeloDAO.CategoriaDAO;
import com.app.productos.modeloDAO.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {

    private final IProducto prodDAO;
    private final ICategoria catDAO;

    public Controlador() {
        prodDAO = new ProductoDAO();
        catDAO = new CategoriaDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List<Producto> productos = prodDAO.getProductos();
                    request.setAttribute("productos", productos);
                    Producto producto = (Producto) request.getAttribute("producto");
                    request.setAttribute("producto", producto != null ? producto : new Producto());
                    request.setAttribute("categorias", catDAO.getCategoria());
                    request.getRequestDispatcher("producto.jsp").forward(request, response);
                    break;
                case "Guardar":
                    int idProd = Integer.valueOf(request.getParameter("txtId"));
                    String nom = request.getParameter("txtNombre");
                    String des = request.getParameter("txtDescripcion");
                    double precio = Double.valueOf(request.getParameter("txtPrecio"));
                    int idCategoria = Integer.valueOf(request.getParameter("txtCategoria"));
                    String estado = request.getParameter("txtEstado");
                    Producto p = new Producto();
                    p.setId(idProd);
                    p.setNombre(nom);
                    p.setDescripcion(des);
                    p.setPrecio(precio);
                    p.setIdcat(idCategoria);
                    p.setEstado(estado);
                    int r = prodDAO.saveProducto(p);
                    if (r == 1) {
                        request.setAttribute("Mensaje", "Error al guardar Producto");
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    } else {
                        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                    }
                    break;
                case "Editar":
                    int idpr = Integer.parseInt(request.getParameter("id"));
                    Producto product = prodDAO.getProductoId(idpr);
                    request.setAttribute("producto", product);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    int ide = Integer.parseInt(request.getParameter("id"));
                    int res = prodDAO.deleteProductoId(ide);
                    if (res == 1) {
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    } else {
                        request.setAttribute("Mensaje", "Error o No se puede Eliminar Producto");
                        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                    }
                    break;
                default:
                    throw new AssertionError();
            }

        }
        if (menu.equals("Categoria")) {
            switch (accion) {
                case "Listar":
                    List<Categoria> categorias = catDAO.getCategoria();
                    request.setAttribute("Categorias", categorias);
                    Categoria cat = (Categoria) request.getAttribute("categoria");
                    request.setAttribute("categoria", cat != null ? cat : new Categoria());
                    request.setAttribute("categorias", categorias);
                    request.getRequestDispatcher("categoria.jsp").forward(request, response);
                    break;
                case "Guardar":
                    String idca = request.getParameter("txtId");
                    String nom = request.getParameter("txtNombre");
                    String est = request.getParameter("txtEstado");
                    Categoria cate = new Categoria(Integer.valueOf(idca), nom, est);
                    int res1 = catDAO.saveCategoria(cate);
                    if (res1 == 1) {
                        request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                    } else {
                        request.setAttribute("menu", "Categoria");
                        request.setAttribute("accion", "Listar");
                        request.setAttribute("Mensaje", "Error al guardar Categoría");
                        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                    }

                    break;
                case "Editar":
                    int idpc = Integer.parseInt(request.getParameter("id"));
                    Categoria cl = catDAO.getCategoriaId(idpc);
                    request.setAttribute("categoria", cl);
                    request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    String id_cat = request.getParameter("iddel");
                    int ress = catDAO.deleteCategoriaId(Integer.valueOf(id_cat));
                    if (ress == 1) {
                        request.getRequestDispatcher("Controlador?menu=Categoria&accion=Listar").forward(request, response);
                    } else {
                        request.setAttribute("Mensaje", "Error o No se puede Eliminar Categoría");
                        request.setAttribute("menu", "Categoria");
                        request.setAttribute("accion", "Listar");
                        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
