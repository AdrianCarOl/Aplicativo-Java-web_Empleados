
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX" />

<section iden="empleads">
    <div class="container">
        <div class="row">

            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Empleados</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Identificacion</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Telefono</th>
                                <th>Direccion</th>
                                <th>Fecha Inicio</th>
                                <th></th>
                            </tr>

                        </thead>
                        <tbody>

                            <c:forEach var="empleado" items="${empleados}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${empleado.iden} </td>
                                        <td>${empleado.nom}  </td>
                                       <td> ${empleado.apell} </td>
                                       <td> ${empleado.tel} </td>
                                         <td>${empleado.direccion} </td>
                                          <td>${empleado.fecha_ini} </td>
                                                                       
                                    <td>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&iden=${empleado.iden}"
                                           class ="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar

                                        </a>  
                                    </td>    
                                </tr>               
                            </c:forEach>

                        </tbody>
                    </table>
                </div>

            </div>
            <!-- Totales -->
            <div class="col-md-3">


                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Empleados</h3>
                        <h4 class="display-4">
                            <i class="fas fa-graduation-cap  "> </i>${totalEmpleados}
                            
                        </h4>
                    </div>
                </div>
            </div>

        </div>



    </div>    
</div>


</section>
<jsp:include page="agregarEmpleado.jsp" />
