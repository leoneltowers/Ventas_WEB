
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Mensaje</title>
    </head>
    <body>
        <div class="container mt-4">
            <div class="card text-center">
                <div class="card-header">
                    Mensaje
                </div>
                <div class="card-body">
                    <h5 class="card-title" style="color: red">${Mensaje}</h5>
                    <p class="card-text">Ops! por favor comunicarse con el administrador del sistema.</p>
                    <c:if test="${Empleado!=null&&Empleado.perfil=='ADMINISTRADOR'}">
                        <form action="Controlador?menu=${menu}" method="POST">
                            <button type="submit" name="accion" value="${accion}" class="btn btn-success">Volver a Principal</button>
                        </form>
                    </c:if>

                </div>
                <div class="card-footer text-muted">
                    <form action="ControladorLogin" method="POST">
                        <button type="submit" name="accion" value="Salir" class="btn btn-primary">Volver a Iniciar Session</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
