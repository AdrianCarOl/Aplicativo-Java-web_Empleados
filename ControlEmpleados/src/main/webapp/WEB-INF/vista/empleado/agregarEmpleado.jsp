
<div class="modal fade" id="agregarEmpleadoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Empleado</h5>
                <button clase="clse" data-dismiss="modal">
                    <span>&times;</span>
                </button>
        </div>
            
          <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" 
  
                  method="POST" class="was-validated">
                <div class="modal-body">
                    
                       <div class="form-group">
                        <label for="iden">Identificacion</label>
                        <input type="number" class="form-control" name="iden" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="nom">Nombre</label>
                        <input type="text" class="form-control" name="nom" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="apell">Apellido</label>
                        <input type="text" class="form-control" name="apell" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="tel">Telefono</label>
                        <input type="text" class="form-control" name="tel" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="direccion">Direccion</label>
                        <input type="text" class="form-control" name="direccion" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="fecha_ini">Fecha Inicio</label>
                        <input type="date" class="form-control" name="fecha_ini" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn-primary" type="submit">Guardar Empleado</button>
                   
                    </div>
            </form>  
        </div>
    </div>
</div>
