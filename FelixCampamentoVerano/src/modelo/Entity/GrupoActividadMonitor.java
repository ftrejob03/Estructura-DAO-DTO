package modelo.Entity;
public class GrupoActividadMonitor {
    private Grupo grupo;
    private Actividad actividad;
    private Monitor monitor;

    public GrupoActividadMonitor() {}

    public GrupoActividadMonitor(Grupo grupo, Actividad actividad, Monitor monitor) {
        this.grupo = grupo;
        this.actividad = actividad;
        this.monitor = monitor;
    }

    public Grupo getGrupo() { return grupo; }
    public void setGrupo(Grupo grupo) { this.grupo = grupo; }

    public Actividad getActividad() { return actividad; }
    public void setActividad(Actividad actividad) { this.actividad = actividad; }

    public Monitor getMonitor() { return monitor; }
    public void setMonitor(Monitor monitor) { this.monitor = monitor; }
}