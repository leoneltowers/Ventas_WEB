
<%@ include file="commons/header.jspf"%>
<%@ include file="commons/navigate.jspf"%>
<c:if test="${Empleado!=null&&Empleado.perfil=='ADMINISTRADOR'}">
<div class="ml-4 mt-4 mr-4 mb-4">
    <div class="row">
        <div class="col-sm-3">
            <div class="card">
                <div class="card-body">
                    <form action="Controlador?menu=Categoria" method="POST">
                        <div class="form-group">
                            <label>Producto</label>
                            <input type="hidden"  value="${categoria.idcat}" name="txtId">
                            <input type="text" value="${categoria.categoria}" name="txtNombre" class="form-control">
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
                                <th>DESCRIPCION</th>                                   
                                <th>ESTADO</th>                                    
                                <th></th>
                            </tr>
                        </thead>
                        <tbody> 
                            <c:forEach var="c" items="${categorias}" varStatus="ca">
                                <tr>
                                    <td class="text-center">${ca.index+1}</td>                                      
                                    <td>${c.categoria}</td>
                                    <td class="text-center">${c.estadocat}</td>
                                    <td class="d-flex">
                                        <form action="Controlador?menu=Categoria" method="POST" class="text-center">
                                            <input type="hidden" value="${c.idcat}" name="id">
                                            <button class="btn btn-outline-warning btn-sm" type="submit" name="accion" value="Editar"><i class="bi bi-pencil-square"></i></button>
                                        </form>
                                        <form action="Controlador?menu=Categoria" class="ml-1" method="POST">
                                            <input type="hidden" value="${c.idcat}" name="iddel">
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


