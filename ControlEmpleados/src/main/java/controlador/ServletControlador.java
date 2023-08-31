
package controlador;

// Importación de clases necesarias
import modelo.EmpleadoDaoJDBC;
import modelo.Empleado;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

   
    // Declaración del servlet y la URL asociada
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {
    
   // Método para la edición de un empleado
    protected void editarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int iden = Integer.parseInt(request.getParameter("iden"));
        Empleado empleado = new EmpleadoDaoJDBC().buscar(new Empleado(iden));
        request.setAttribute("empleado", empleado);
        String jspEditar = "/WEB-INF/vista/empleado/editarEmpleado.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    // Método para la acción por defecto
    protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Se lista la información de todos los empleados
        List<Empleado> empleados = new EmpleadoDaoJDBC().listar();
        System.out.println("empleados = " + empleados);
        // Se crea una sesión y se establecen los atributos "empleados" y "totalEmpleados"
        HttpSession sesion = request.getSession();
        sesion.setAttribute("empleados", empleados);
        sesion.setAttribute("totalEmpleados", empleados.size());

        // Se redirige al archivo "empleados.jsp"
        response.sendRedirect("empleados.jsp");
    }

    protected void modificarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int iden = Integer.parseInt(request.getParameter("iden"));
        String nom = request.getParameter("nom");
        String apell = request.getParameter("apell");
        int tel = Integer.parseInt(request.getParameter("tel"));
        String direccion = request.getParameter("direccion");
        String fecha_ini = request.getParameter("fecha_ini");
        
        
        String idenString = request.getParameter("iden");
        if (idenString != null && !"".equals(idenString)) {
            iden = Integer.parseInt(idenString);
        }
     /*
        if (idenString != null && !"".equals(idenString)) {
            iden = Integer.parseInt(idenString);
        }
        
      */
        Empleado empleado = new Empleado(iden, nom, apell, tel, direccion, fecha_ini);
        int registrosModificados = new EmpleadoDaoJDBC().actualizar(empleado);
        this.accionDefault(request, response);
    }
    
    protected void eliminarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int iden = Integer.parseInt(request.getParameter("iden"));
        Empleado empleado = new Empleado(iden);
        int registrosModificados = new EmpleadoDaoJDBC().eliminar(empleado);
        this.accionDefault(request, response);
    }
    
    protected void insertarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int iden = Integer.parseInt(request.getParameter("iden"));       
        String nom = request.getParameter("nom");
        String apell = request.getParameter("apell");
        int tel = Integer.parseInt(request.getParameter("tel"));
        String direccion = request.getParameter("direccion");
        String fecha_ini = request.getParameter("fecha_ini");

        
        String idenString = request.getParameter("iden");
        if (idenString != null && !"".equals(idenString)) {
            iden = Integer.parseInt(idenString);
        }
        
               

        Empleado empleado = new Empleado( iden, nom, apell, tel, direccion, fecha_ini);
        int registrosModificados = new EmpleadoDaoJDBC().insertar(empleado);
        this.accionDefault(request, response);
    }
    
     // Método para el manejo de solicitudes GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            // Selección de la acción a realizar según el parámetro "accion" enviado
            switch (accion) {
                // En caso de que la acción sea "editar", se llama al método correspondiente
                case "editar":
                    this.editarEmpleado(request, response);
                    break;
                // En caso de que la acción sea "eliminar", se llama al método correspondiente
                case "eliminar":
                    this.eliminarEmpleado(request, response);
                    break;
                // Si no se encuentra una acción válida, se llama al método por defecto
                default:
                    this.accionDefault(request, response);
            }

        } else {
            // Si no se especifica una acción, se llama al método por defecto
            this.accionDefault(request, response);
        }
    }
    
    // Método para el manejo de solicitudes POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            // Selección de la acción a realizar según el parámetro "accion" enviado
            switch (accion) {
                // En caso de que la acción sea "insertar", se llama al método correspondiente
                case "insertar":
                    this.insertarEmpleado(request, response);
                    break;
                // En caso de que la acción sea "modificar", se llama al método correspondiente
                case "modificar":
                    this.modificarEmpleado(request, response);
                    break;
                // En caso de que la acción sea "eliminar", se llama al método correspondiente
                case "eliminar":
                    this.eliminarEmpleado(request, response);
                    break;
                // Si no se encuentra una acción válida, se llama al método por defecto
                default:
                    this.accionDefault(request, response);
            }
 
        } else {
            // Si no se especifica una acción, se llama al método por defecto
            this.accionDefault(request, response);
        }
    }
    
}  

        
    


    

