public enum TipoServicio{ 
    LUZ, 
    AGUA, 
    INTERNET;    

    public static TipoServicio getTipoServicio(int i){
        return TipoServicio.values()[i];
    }
}