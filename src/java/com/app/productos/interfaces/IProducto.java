
package com.app.productos.interfaces;

import com.app.productos.modelo.Producto;
import java.util.List;

public interface IProducto{
    public List<Producto>getProductos();
    public Producto getProductoId(int id);
    public int saveProducto(Producto p);
    public int deleteProductoId(int id);
}
