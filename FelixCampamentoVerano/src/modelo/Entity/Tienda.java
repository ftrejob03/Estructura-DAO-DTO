package modelo.Entity;
public class Tienda {
    private Integer numeroTienda;
    private Integer capacidad = 4;

    public Tienda() {}

    public Tienda(Integer numeroTienda, Integer capacidad) {
        this.numeroTienda = numeroTienda;
        this.capacidad = capacidad;
    }

    public Integer getNumeroTienda() { return numeroTienda; }
    public void setNumeroTienda(Integer numeroTienda) { this.numeroTienda = numeroTienda; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }
}