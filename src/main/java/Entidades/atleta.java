package Entidades;
import java.util.ArrayList;
import java.util.List;
public class atleta {
private String nombre;
private int edad;
private String departamento;
private Disciplina disciplina;
private List<Entrenamientos> entrenamientos;

public atleta(String nombre,int edad,String departamento,Disciplina disciplina) {
    this.nombre = nombre;
    this.edad = edad;
    this.departamento = departamento;
    this.disciplina = disciplina;
    this.entrenamientos = new ArrayList<>();
}

public void agregarEntrenamiento(Entrenamientos e){
    entrenamientos.add(e);
}
public List <Entrenamientos> getEntrenamientos(){
    return entrenamientos;
}

public String getNombre() {return nombre;}
public int getEdad() {return edad;}

}
