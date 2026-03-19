import java.util.ArrayList;

public class ATM { 

    public Tarjeta buscarTarjeta(ArrayList<Tarjeta> tarjetas, String noTarjeta){

        for (Tarjeta t : tarjetas) {
            if (t.getNoTarjeta().equals(noTarjeta)) {
                return t;
            }
        }

        return null;
    }

    public boolean validarNIP(Tarjeta tarjeta, String nip){
       return tarjeta.validarNIP(nip);
    }

    public boolean depositar(Cuenta cuenta, double monto, Tarjeta tarjeta){ 
        
        if(monto <= 0) { 
            System.out.println("Monto invalido");
            return false;
        }

        return cuenta.deposito(monto, tarjeta); 
    }

    public boolean retirar(Cuenta cuenta, double monto, Tarjeta tarjeta){
        
        if (monto < 200) {
            System.out.println("El monto minimo de retiro es de $200");
            return false;
        }

        if (monto % 100 != 0) {
            System.out.println("El monto a retirar debe ser multiplo de $100");
            return false;
        }

        return cuenta.retiro(monto, tarjeta);
    }
    
    public boolean pagarServicioTarjeta(Cuenta cuenta, Servicio servicio, Tarjeta tarjeta){

        if (servicio.getMontoBase() > cuenta.getSaldo()){ 
            System.out.println("Fondos insuficiente");
            return false;
        }
        
        return cuenta.pagarServicio(servicio.getMontoBase(), tarjeta);
    }

    public boolean pagarServicioEfectivo(Servicio servicio, String lineaCaptura, double monto){

        if (monto < 20) {
            System.out.println("Solo puedes ingresar billetes");
            return false;
        }

        boolean combinacionValida = false;

        for(int i = 0; i <= monto / 50; i++){
            double resto = monto - (i * 50);

            if(resto % 20 == 0){
                combinacionValida = true;
                break;
            }
        }

        if(!combinacionValida){
            System.out.println("Monto invalido");
            return false;
        }

        if (monto < servicio.getMontoBase()) {
            System.out.println("Falta dinero");
            return false;
        }

        double cambio = monto - servicio.getMontoBase();
        System.out.println("Cambio: $" + cambio);
        return true;
    }
    
}