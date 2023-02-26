<%@ include file="commons/header.jspf"%>
<%@ include file="commons/navigate.jspf"%>

<c:if test="${Empleado!=null&&Empleado.perfil=='ADMINISTRADOR'}">
<div class="ml-4 mt-4 mr-4 mb-4">
    <div class="row">
        <div class="col-sm-3">
            <div class="card">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="form-group">
                            <label>Producto</label>
                            <input type="hidden"  value="${producto.id}" name="txtId">
                            <input type="text" value="${producto.nombre}" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Descripcion</label>
                            <textarea name="txtDescripcion" class="form-control">${producto.descripcion}</textarea>
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" value="${producto.precio}" name="txtPrecio" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Categoria</label>
                            <select class="form-control" name="txtCategoria">
                                <option value="0">SELECCIONAR</option>
                                <c:forEach var="c" items="${categorias}" >
                                    <c:if test="${producto.idcat==c.idcat}">
                                        <option selected value="${c.idcat}">${c.categoria}</option>
                                    </c:if>                                    
                                    <c:if test="${producto.idcat!=c.idcat}">
                                        <option value="${c.idcat}">${c.categoria}</option>
                                    </c:if>                                    
                                </c:forEach>                                
                            </select>
                        </div>                        
                        <div class="form-group">
                            <label>Estado</label>
                            <select class="form-control" name="txtEstado">
                                <option value="1">ACTIVO</option>
                                <option value="0">INACTIVO</option>                              
                            </select>
                        </div>                        
                        <input type="submit" name="accion" value="Guardar" class="btn btn-primary">
                    </form>
                </div>                         
            </div>
        </div>                     
        <div class="col-sm-9">
            <div class="card">
                <div class="card-body">
                    <table class="table table-hover" style="width: 100%" id="example">
                        <thead>
                            <tr class="text-center">
                                <th>#</th>
                                <th>NOMBRE</th>
                                <th>DESCRIPCION</th>
                                <th>PRECIO</th>                                    
                                <th>PRECIO</th>                                    
                                <th>ESTADO</th>                                    
                                <th>ACCION</th>
                            </tr>
                        </thead>
                        <tbody> 
                            <c:forEach var="p" items="${productos}" varStatus="pr">
                                <tr>
                                    <td class="text-center">${pr.index+1}</td>                                      
                                    <td>${p.nombre}</td>
                                    <td>${p.descripcion}</td>
                                    <td>${p.precio}</td>
                                    <td>${p.categoria}</td>
                                    <td class="text-center">${p.estado}</td>
                                    <td class="text-center d-flex">
                                        <form action="Controlador?menu=Producto" method="POST">
                                            <input type="hidden" value="${p.id}" name="id">
                                            <button class="btn btn-outline-warning btn-sm" type="submit" name="accion" value="Editar"><i class="bi bi-pencil-square"></i></button>
                                        </form>
                                        <form action="Controlador?menu=Producto" class="ml-1" method="POST">
                                            <input type="hidden" value="${p.id}" name="id">
                                            <button class="btn btn-outline-danger btn-sm" type="submit" name="accion" value="Delete"><i class="bi bi-trash"></i></button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>      
</div>     
</c:if>
<%@ include file="commons/footer.jspf"%>


