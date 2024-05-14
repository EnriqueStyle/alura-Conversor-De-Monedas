public class Cambio {

    private String monedaBase;
    private String monedaObjetivo;
    private Double cantidadAcambiar;
    private Double cantidadEnMonedaObjetiva;


    public Cambio(String monedaBase, String monedaObjetivo, Double cantidadAcambiar, Double cantidadEnMonedaObjetiva) {
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;
        this.cantidadAcambiar = cantidadAcambiar;
        this.cantidadEnMonedaObjetiva = cantidadEnMonedaObjetiva;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public void setMonedaObjetivo(String monedaObjetivo) {
        this.monedaObjetivo = monedaObjetivo;
    }

    public Double getCantidadAcambiar() {
        return cantidadAcambiar;
    }

    public void setCantidadAcambiar(Double cantidadAcambiar) {
        this.cantidadAcambiar = cantidadAcambiar;
    }

    public Double getCantidadEnMonedaObjetiva() {
        return cantidadEnMonedaObjetiva;
    }

    public void setCantidadEnMonedaObjetiva(Double cantidadEnMonedaObjetiva) {
        this.cantidadEnMonedaObjetiva = cantidadEnMonedaObjetiva;
    }
}
