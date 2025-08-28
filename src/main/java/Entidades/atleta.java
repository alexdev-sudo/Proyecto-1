package Entidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
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


    public void mostrarhistorial(){
    // se verifica el nombre completo, si no hay registro en entrenamientos devuelve el string
    if (entrenamientos == null  ||  entrenamientos.isEmpty()){
        System.out.println("no hay entrenamietos registrados para: " + nombre);
        return;
    }
        // se ordena la lista entrenamientos por fecha para cumplir con el requisito
        // orden de redimiento por fecha
        entrenamientos.sort(Comparator.comparing(Entrenamientos::getFecha));
        System.out.println("\nHistorial de entrenamientos: ");
        System.out.println("Atleta: "+nombre);
        System.out.println("Disciplina: "+ disciplina.getNombre()+"\n");

        System.out.printf("%-12s| %-40s| %-10s| %-10s|\n","Fecha","Tipo entreno ","Valor ","Unidad");
        System.out.println("-----------------------------------------------------------------");
        for (Entrenamientos e:entrenamientos){
            System.out.printf("%-12s| %-40s| %-10s| %-10s|\n",e.getFecha(),e.getTipo(),e.getValor(),e.getUnidad());
        }
    }

}
