import java.util.ArrayList;

public class Usuario { 
    private String nombre; 
    private String apellido; 
    private String domicilio; 
    private String telefono; 
    private String correo;
    private ArrayList<Cuenta> cuentas;
    
    Usuario(String nombre, String apellido, String domicilio, String telefono, String correo){
        this.nombre = nombre;
        this.apellido = apellido; 
        this.domicilio = domicilio; 
        this.telefono = telefono; 
        this.correo = correo; 
        cuentas = new ArrayList<>();
     }

    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }

    public void mostrarCuentas(){
        for (Cuenta cuenta2 : cuentas) {
            System.out.println(cuenta2.toString());
        }
    }

    public String getNombre(){ 
        return nombre; 
    }

    public String getApellido() { 
        return apellido; 
    }

    public String getDomicilio() { 
        return domicilio;
    }

    public String getTelefono() { 
        return telefono;
    }

    public String getCorreo() { 
        return correo; 
    }
    
    public void setNombre(String nombre){ 
        this.nombre = nombre;
    }

    public void setApellido(String apellido){ 
        this.apellido = apellido; 
    }

    public void setDomicilio(String domicilio) { 
        this.domicilio = domicilio;
    }

    public void setTelefono(String telefono){ 
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString(){
        return String.format("Titular: %s \nDomicilio: %s \nTelefono: %s \nCorreo: %s", nombre + apellido, domicilio, telefono, correo);
    }
}
