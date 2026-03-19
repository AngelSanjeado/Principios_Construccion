import java.util.ArrayList;

public class Tarjeta { 
    private String noTarjeta;
    private String fechaVencimiento;
    private String cvv;
    private String nip;
    private ArrayList<Cuenta> cuentas;

    public Tarjeta(String noTarjeta, String fechaVencimiento, String cvv, String nip){
        this.noTarjeta = noTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.nip = nip;
        cuentas = new ArrayList<>();
    }

    public String getNoTarjeta(){
        return noTarjeta;
    }

    public boolean validarNIP(String nip){
        return (this.nip.equals(nip)? true : false);
    }

    public void asociarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
        cuenta.agregarTarjeta(this);
    }

    public void mostrarCuentas(){
        int i = 1;
        for (Cuenta cuenta : cuentas) {
            System.out.println(i++ + ". " + cuenta.getTipoCuenta());
        }
    }

    public Cuenta seleccionarCuenta(int i){
        return cuentas.get( - 1);
    }
        
    @Override
    public String toString(){
        return String.format("Tarjeta: %s \nCuentas asociadas: %s", noTarjeta, cuentas);
    }
}