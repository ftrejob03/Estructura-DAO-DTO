package modelo.Entity;
public class Grupo {
    private Integer numeroGrupo;
    private String informaciones;

    public Grupo() {}

    public Grupo(Integer numeroGrupo, String informaciones) {
        this.numeroGrupo = numeroGrupo;
        this.informaciones = informaciones;
    }

    public Integer getNumeroGrupo() { return numeroGrupo; }
    public void setNumeroGrupo(Integer numeroGrupo) { this.numeroGrupo = numeroGrupo; }

    public String getInformaciones() { return informaciones; }
    public void setInformaciones(String informaciones) { this.informaciones = informaciones; }
}