
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" 
              crossorigin="anonymous"> 

        <script src="https://kit.fontawesome.com/3556f97ea7.js" crossorigin="anonymous"></script>


        <title>EDITAR EMPLEADO</title>
    </head>
    <body>
        <jsp:include page="../componentes/cabecero.jsp" />

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&iden=${empleado.iden}"
              method="POST" class="was-validated">
            <jsp:include page="../componentes/botonesNavegacionEdicion.jsp" /> 
            <section id="details"> 
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Empleado</h4>
                                </div>
                                <div class="card-body">
                                    
                                    <div class="form-group">
                                        <label for="iden">Identificacion</label>
                                        <input type="number" class="form-control" name="iden" required value="${empleado.iden}">
                                    </div>
                                    
                                    
                                    <div class="form-group">
                                        <label for="nom">Nombre</label>
                                        <input type="text" class="form-control" name="nom" required value="${empleado.nom}">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="apell">Apellido</label>
                                        <input type="text" class="form-control" name="apell" required value="${empleado.apell}">
                                    </div><!-- comment -->
                                                                       
                                    <div class="form-group">
                                        <label for="tel">Telefono</label>
                                        <input type="number" class="form-control" name="tel" required value="${empleado.tel}">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="direccion">Direccion</label>
                                        <input type="text" class="form-control" name="direccion" required value="${empleado.direccion}">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="fecha_ini">Fecha Inicio</label>
                                        <input type="date" class="form-control" name="fecha_ini" required value="${empleado.fecha_ini}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>
    </body>
</html>

