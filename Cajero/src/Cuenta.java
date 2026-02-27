import java.util.ArrayList;

public class Cuenta {
    private String noCuenta;
    private Usuario titular;
    private TipoCuenta tipoCuenta;
    private double saldo;
    private ArrayList<Tarjeta> tarjetas;
    private ArrayList<StringBuilder> movimientos;

    public Cuenta(String noCuenta, Usuario titular, TipoCuenta tipoCuenta, double monto){
        this.noCuenta = noCuenta;
        this.titular = titular;
        this.tipoCuenta = tipoCuenta;
        this.saldo = monto;
        tarjetas = new ArrayList<>();
        movimientos = new ArrayList<>();
    }

    public double getSaldo(){
        return saldo;
    }

    public String getTitular() {
        return titular.getNombre() + titular.getApellido();
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public boolean deposito(double monto){
        if (monto > 0){
            this.saldo += monto;
            return true;
        }

        return false;
    }   

    public boolean retiro(double monto){
        if (monto <= 0) {
            System.out.println("Monto invalido. Retira una cantidad mayor a 0");
            return false;
        }
        
        if (monto > this.saldo){
            System.out.println("Saldo insuficiente: $" + saldo);
            return false;
        }
        
        this.saldo -= monto;
        return true;
    }

    public void agregarTarjeta(Tarjeta tarjeta){
        tarjetas.add(tarjeta);
        
    }

    public void registroMovimiento(StringBuilder movimiento){
        movimientos.add(movimiento);
    }

    @Override
    public String toString(){
        return String.format("| %-10s | %-9s | %-15s | %-8.2f |", titular.getNombre() + titular.getApellido(), noCuenta, tipoCuenta, saldo);
    }
}
