package modelo.Entity;
import java.time.LocalDate;

public abstract class Nino {
    private Integer numeroNino;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private Grupo grupo; // Relación con el Grupo asignado

    public Nino() {}

    public Nino(Integer numeroNino, String nombre, String apellidos, LocalDate fechaNacimiento, Grupo grupo) {
        this.numeroNino = numeroNino;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.grupo = grupo;
    }

    public Integer getNumeroNino() { return numeroNino; }
    public void setNumeroNino(Integer numeroNino) { this.numeroNino = numeroNino; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Grupo getGrupo() { return grupo; }
    public void setGrupo(Grupo grupo) { this.grupo = grupo; }
}