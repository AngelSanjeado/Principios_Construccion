import java.time.LocalDateTime;

public class Movimiento {
    private Usuario usuario;
    private Tarjeta tarjeta;
    private Cuenta cuenta;
    private TipoMovimiento movimiento;
    private double monto;
    private LocalDateTime fecha;

    public Movimiento(Usuario usuario, Tarjeta tarjeta, Cuenta cuenta, TipoMovimiento movimiento, double monto){
        this.usuario = usuario;
        this.tarjeta = tarjeta;
        this.cuenta = cuenta;
        this.movimiento = movimiento;
        this.monto = monto;
        fecha = LocalDateTime.now();
    }

    @Override
    public String toString(){
        return String.format("| %-10s | %-16s | %-9s | %-13s | %-5.2f | %-10s |", usuario.getNombre() + usuario.getApellido(), tarjeta.getNoTarjeta(), cuenta.getTipoCuenta(), movimiento, monto, fecha);
    }
}