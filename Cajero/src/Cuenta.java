import java.util.ArrayList;

public class Cuenta {
    private Usuario titular;
    private String noCuenta;
    private TipoCuenta tipoCuenta;
    private double saldo;
    private ArrayList<Tarjeta> tarjetas;
    private ArrayList<Movimiento> movimientos;

    public Cuenta(Usuario titular, String noCuenta, TipoCuenta tipoCuenta, double monto){
        this.titular = titular;
        this.noCuenta = noCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = monto;
        tarjetas = new ArrayList<>();
        movimientos = new ArrayList<>();
    }

    public double getSaldo(){
        return saldo;
    }

    public Usuario getTitular() {
        return titular;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public boolean deposito(double monto, Tarjeta tarjeta){
        if (monto <= 0){
            System.out.println("Monto invalido. Deposita minimo $1");
            return false;
        }
        
        this.saldo += monto;
        System.out.println("Deposito exitoso");
        movimientos.add(new Movimiento(titular, tarjeta, this, TipoMovimiento.DEPOSITO, monto));
        return true;
    }   

    public boolean retiro(double monto, Tarjeta tarjeta){
        if (monto <= 0) {
            System.out.println("Monto invalido. Retira una cantidad mayor a 0");
            return false;
        }
        
        if (monto > this.saldo){
            System.out.println("Saldo insuficiente: $" + saldo);
            return false;
        }
        
        this.saldo -= monto;
        System.out.println("Retiro exitoso");
        movimientos.add(new Movimiento(titular, tarjeta, this, TipoMovimiento.RETIRO, monto));
        return true;
    }

    public boolean pagarServicio(double monto, Tarjeta tarjeta){
        if (monto <= 0) {
            System.out.println("Monto invalido");
            return false;
        }

        saldo -= monto;
        System.out.println("Pago exitoso");
        movimientos.add(new Movimiento(titular, tarjeta, this, TipoMovimiento.PAGO_SERVICIO, monto));
        return true;
    }

    public void agregarTarjeta(Tarjeta tarjeta){
        tarjetas.add(tarjeta);
    }

    @Override
    public String toString(){
        return String.format("| %-10s | %-9s | %-15s | %-8.2f |", titular.getNombre() + " " + titular.getApellido(), noCuenta, tipoCuenta, saldo);
    }
}
