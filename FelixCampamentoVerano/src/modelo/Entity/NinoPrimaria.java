package modelo.Entity;
import java.time.LocalDate;

public class NinoPrimaria extends Nino {
    private Cabana cabana;

    public NinoPrimaria() {
        super();
    }

    public NinoPrimaria(Integer numeroNino, String nombre, String apellidos, LocalDate fechaNacimiento, Grupo grupo, Cabana cabana) {
        super(numeroNino, nombre, apellidos, fechaNacimiento, grupo);
        this.cabana = cabana;
    }

    public Cabana getCabana() { return cabana; }
    public void setCabana(Cabana cabana) { this.cabana = cabana; }
}