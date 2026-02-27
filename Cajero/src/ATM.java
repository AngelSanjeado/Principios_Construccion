public class ATM { 

    public boolean validarNIP(Tarjeta tarjeta, String nip){
       return tarjeta.validarNIP(nip);
    }

    public boolean depositar(Cuenta cuenta, double monto, String noTarjeta){ 
        
        if(monto <= 0) { 
            System.out.println("Monto invalido");
            return false;
        }

        cuenta.deposito(monto); 
        System.out.println("Deposito realizado con éxito :)");
        
        StringBuilder movimiento = new StringBuilder();
        cuenta.registroMovimiento(movimiento.append("| ").append(cuenta.getTitular() + " | ").append(noTarjeta + " | ").append(cuenta.getTipoCuenta() + " | ").append("Deposito | ").append(monto + " |"));
        return true;
    }

    public boolean retirar(Cuenta cuenta, double monto, String noTarjeta){
        
        if (monto < 200) {
            System.out.println("El monto minimo de retiro es de $200");
            return false;
        }

        if (monto % 100 != 0) {
            System.out.println("El monto a retirar debe ser multiplo de $100");
            return false;
        }

        cuenta.retiro(monto);
        System.out.println("Retiro realizado con exitoso :)");

        StringBuilder movimiento = new StringBuilder();
        cuenta.registroMovimiento(movimiento.append("| ").append(cuenta.getTitular() + " | ").append(noTarjeta + " | ").append(cuenta.getTipoCuenta() + " | ").append("Retiro | ").append(monto + " | "));
          return true; 
    }
    
    public boolean pagarServicioTarjeta(Cuenta cuenta, Servicio servicio, String lineaCaptura, String tarjeta, Usuario titular){ 
        if (servicio.getMontoBase() > cuenta.getSaldo()){ 
            System.out.println("Fondos insuficiente");
            return false;
        }
        
        cuenta.retiro(servicio.getMontoBase());
        
        StringBuilder movimiento = new StringBuilder();
        cuenta.registroMovimiento(movimiento.append("| ").append(cuenta.getTitular() + " | ").append(tarjeta + " | ").append(cuenta.getTipoCuenta() + " | ").append("Pago de servicio: ").append(servicio.getTipoServicio() + " | ").append(servicio.getMontoBase() + " |"));
        return true; 
    }

    public boolean pagarServicioEfectivo(Servicio servicio, String lineaCaptura, double monto){
        if (monto <= 10 && monto % 10 != 0) {
            System.out.println("Solo puedes ingresar bielletes");
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