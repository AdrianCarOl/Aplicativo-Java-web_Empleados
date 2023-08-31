
package modelo;

// Importar clases necesarias para conectarse a la base de datos
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDaoJDBC {
    
      // Consultas SQL para hacer las operaciones CRUD
    private static final String SQL_SELECT
            = "SELECT iden, nom, apell, tel, direccion, fecha_ini FROM empleado";
    private static final String SQL_SELECT_BY_ID
            = "SELECT iden, nom, apell, tel, direccion, fecha_ini FROM empleado WHERE iden=?";
    private static final String SQL_INSERT
            = "INSERT INTO empleado(iden, nom, apell, tel, direccion, fecha_ini) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE
            = "UPDATE empleado SET nom=?, apell=?, tel=?, direccion=?, fecha_ini=? WHERE iden=?";
    private static final String SQL_DELETE
            = "DELETE FROM empleado WHERE iden=?";
    
    
    // Método para obtener la lista completa de empleados
    public List<Empleado> listar() {
        List<Empleado> empleados = new ArrayList<>();
        // Conexión a la base de datos y consulta SQL
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_SELECT); ResultSet rs = stmt.executeQuery()) {
            // Recorrido de resultados y creación de objetos Empleado
            while (rs.next()) {
                int iden = rs.getInt("iden");
                String nom = rs.getString("nom");
                String apell = rs.getString("apell");
                int tel = rs.getInt("tel");
                String direccion = rs.getString("direccion");
                String fecha_ini = rs.getString("fecha_ini");

                Empleado empleado = new Empleado(iden, nom, apell, tel, direccion, fecha_ini);
                empleados.add(empleado);
            }
        } catch (Exception e) {
            System.out.println("Error al listar los empleados: " + e.getMessage());
        }
        return empleados;
        
    }
         // Método para buscar un empleados por su identificacion (iden)
    public Empleado buscar(Empleado empleado) {
        // Conexión a la base de datos y consulta SQL
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_ID)) {
            stmt.setInt(1, empleado.getIden());
            // Recorrido de resultados y actualización del objeto Empleado pasado como parámetro
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nom = rs.getString("nom");
                    String apell = rs.getString("apell");
                    int tel = rs.getInt("tel");
                    String direccion = rs.getString("direccion");
                    String fecha_ini = rs.getString("fecha_ini");
                    empleado.setNom(nom);
                    empleado.setApell(apell);
                    empleado.setTel(tel);
                    empleado.setDireccion(direccion);
                    empleado.setFecha_ini(fecha_ini);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el Empleado: " + e.getMessage());
        }
        return empleado;
    }
    
    
      // Método para insertar un nuevo estudiante en la base de datos
    public int insertar(Empleado empleado) {
        int rows = 0;
        // Conexión a la base de datos y consulta SQL
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
            // Se establecen los parámetros de la consulta preparada
            stmt.setInt(1, empleado.getIden());
            stmt.setString(2, empleado.getNom());
            stmt.setString(3, empleado.getApell());
            stmt.setInt(4, empleado.getTel());
            stmt.setString(5, empleado.getDireccion());
            stmt.setString(6, empleado.getFecha_ini());
            // Se ejecuta la consulta y se obtiene el número de filas afectadas
            rows = stmt.executeUpdate();
        } catch (Exception e) {
            // Se maneja cualquier excepción que se produzca durante la ejecución de la consulta
            System.out.println("Error al insertar el empleado: " + e.getMessage());
        }

        return rows;
    }
    
    // Método para actualizar un empleado existente en la base de datos
public int actualizar(Empleado empleado) {
    int rows = 0;
    try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {
        // Se establecen los parámetros de la consulta preparada
        stmt.setString(1, empleado.getNom());
        stmt.setString(2, empleado.getApell());
        stmt.setInt(3, empleado.getTel());
        stmt.setString(4, empleado.getDireccion());
        stmt.setString(5, empleado.getFecha_ini());

        stmt.setInt(6, empleado.getIden()); // Aquí se establece el ID como último parámetro
        // Se ejecuta la consulta y se obtiene el número de filas afectadas
        rows = stmt.executeUpdate();
    } catch (Exception e) {
        // Se maneja cualquier excepción que se produzca durante la ejecución de la consulta
        System.out.println("Error al actualizar el empleado: " + e.getMessage());
    }
    return rows;
}

    
      // Método para eliminar un estudiante existente en la base de datos
    public int eliminar(Empleado empleado) {
        int rows = 0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {
            // Se establecen los parámetros de la consulta preparada
            stmt.setInt(1, empleado.getIden());
            // Se ejecuta la consulta y se obtiene el número de filas afectadas
            rows = stmt.executeUpdate();
        } catch (Exception e) {
            // Se maneja cualquier excepción que se produzca durante la ejecución de la consulta
            System.out.println("Error al eliminar el empleado: " + e.getMessage());
        }
        return rows;
    }
}

    

        
    
    

