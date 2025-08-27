package Entidades;

public class Disciplina {
    private String nombre;
    private String medida;
    public Disciplina(String nombre, String medida) {
        this.nombre = nombre;
        this.medida = medida;

    }
    public String getNombre() {
        return nombre;
    }
    public String getMedida() {
        return medida;
    }
}
