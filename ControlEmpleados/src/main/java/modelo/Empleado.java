
package modelo;


public class Empleado {
    
     // Atributos
    private int iden; // Identificacion del Empleado
    private String nom; // Nombre del empleado
    private String apell; // Apellido del empleado
    private int tel; // Número de teléfono del empleado
    private String direccion; // Direccion empleado
    private String fecha_ini; //fecha inicio contrato  
    
    
     // Constructor con un parámetro para el id del estudiante
    public Empleado(int iden) {
        this.iden = iden;
    }

    // Constructor sin parámetros
    public Empleado() {
    }

    // Constructor con todos los parámetros
    public Empleado(int iden, String nom, String apell, int tel, String direccion, String fecha_ini) {
        this.iden = iden;
        this.nom = nom;
        this.apell = apell;
        this.tel = tel;
        this.direccion = direccion;
        this.fecha_ini = fecha_ini;
    }

    // Constructor sin identificacion del empleado:
    public Empleado(String nom, String apell, int tel, String direccion, String fecha_ini) {
        
        this.nom = nom;
        this.apell = apell;
        this.tel = tel;
        this.direccion = direccion;
        this.fecha_ini = fecha_ini;
    }

    public int getIden() {
        return iden;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApell() {
        return apell;
    }

    public void setApell(String apell) {
        this.apell = apell;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }
    
    
    
    
}


