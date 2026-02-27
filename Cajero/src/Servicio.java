public class Servicio { 
    private TipoServicio tipoServicio;
    private String lineaCaptura;
    private double montoBase;

    public Servicio(TipoServicio tipoServicio, String lineaCaptura, double montoBase){
        this.tipoServicio = tipoServicio;
        this.lineaCaptura = lineaCaptura;
        this.montoBase = montoBase;
    }

    public double getMontoBase(){
        return montoBase;
    }

    public TipoServicio getTipoServicio(){
        return tipoServicio;
    }
}