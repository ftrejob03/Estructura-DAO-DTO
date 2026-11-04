package modelo.Entity;
public class Cabana {
    private String codigoCabana;
    private Integer capacidad = 6;

    public Cabana() {}

    public Cabana(String codigoCabana, Integer capacidad) {
        this.codigoCabana = codigoCabana;
        this.capacidad = capacidad;
    }

    public String getCodigoCabana() { return codigoCabana; }
    public void setCodigoCabana(String codigoCabana) { this.codigoCabana = codigoCabana; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }
}