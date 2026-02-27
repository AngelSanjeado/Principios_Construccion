import java.util.ArrayList;

public class CuentaTarjeta {
    
    static ArrayList<Tarjeta> tarjetas = new ArrayList<>();
    static ArrayList<Cuenta> cuentas = new ArrayList<>();

    public static void asociarCuentaTarjeta(Tarjeta tarjeta, Cuenta cuenta){
        tarjeta.agregarCuenta(cuenta);
        cuenta.agregarTarjeta(tarjeta);

        tarjetas.add(tarjeta);
        cuentas.add(cuenta);
    }

    public static ArrayList<Tarjeta> mostrarTarjetas(){
        return tarjetas;
    }
    
    public static ArrayList<Cuenta> mostrarCuentas(){
        return cuentas;
    }
    
}
