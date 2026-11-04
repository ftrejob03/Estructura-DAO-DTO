package modelo.Entity;
public class Actividad {
    private String codigoActividad;
    private String nombreActividad;
    private String descripcion;

    public Actividad() {}

    public Actividad(String codigoActividad, String nombreActividad, String descripcion) {
        this.codigoActividad = codigoActividad;
        this.nombreActividad = nombreActividad;
        this.descripcion = descripcion;
    }

    public String getCodigoActividad() { return codigoActividad; }
    public void setCodigoActividad(String codigoActividad) { this.codigoActividad = codigoActividad; }

    public String getNombreActividad() { return nombreActividad; }
    public void setNombreActividad(String nombreActividad) { this.nombreActividad = nombreActividad; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}