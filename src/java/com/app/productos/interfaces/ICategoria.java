
package com.app.productos.interfaces;

import com.app.productos.modelo.Categoria;
import java.util.List;

public interface ICategoria {
    public List<Categoria>getCategoria();
    public Categoria getCategoriaId(int id);
    public int saveCategoria(Categoria c);
    public int deleteCategoriaId(int id);
}
