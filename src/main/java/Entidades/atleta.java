package Entidades;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class atleta {
private String nombre;
private int edad;
private String departamento;
private String disciplina;
private String nacionalidad;
private String Fechaingreso;
private List<Entrenamientos> entrenamientos;

public atleta(String nombre,int edad,String departamento,String disciplina,
              String nacionalidad,String Fechaingreso) {
    this.nombre = nombre;
    this.edad = edad;
    this.departamento = departamento;
    this.disciplina = disciplina;
    this.nacionalidad = nacionalidad;
    this.Fechaingreso = Fechaingreso;
    this.entrenamientos = new ArrayList<>();
}

public void agregarEntrenamiento(Entrenamientos e){
    entrenamientos.add(e);
}
public List <Entrenamientos> getEntrenamientos(){
    return entrenamientos;
}

public String getNombre() {
    return nombre;
}
public int getEdad() {
    return edad;
}
public String getDepartamento() {
    return disciplina;
}

    public  int getcount(){
        return entrenamientos==null ? 0 : entrenamientos.size();
    }

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
            System.out.println("Disciplina: "+ disciplina+"\n");

            System.out.printf("%-12s| %-40s| %-10s| %-10s| %-15s| %-10s|\n","Fecha","Tipo entreno ","Valor ","Unidad","Ubicacion", "pais");
            System.out.println("---------------------------------------------------------------------------------------------------------");
            for (Entrenamientos e:entrenamientos){
                System.out.printf("%-12s| %-40s| %-10s| %-10s| %-15s| %-10s|\n",e.getFecha(),e.getTipo(),e.getValor(),
                        e.getUnidad(),e.getUbicacion() ,e.getPais());
            }
        }

    public static String leerfecha (Scanner sc){
        LocalDate fechavalida = null;
        DateTimeFormatter entradaFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        DateTimeFormatter salidaFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while(fechavalida == null){

            String input = sc.nextLine();
            try {
                fechavalida = LocalDate.parse(input,entradaFormatter);
            }catch (DateTimeParseException e) {
                System.out.println("Formato invalido o fecha no existente, intente de nuevo");

            }
        }
        return fechavalida.format(salidaFormatter);
    }

    public void mostrarInternacionall(){

        // se verifica el nombre completo, si no hay registro en entrenamientos devuelve el string
        if (entrenamientos == null  ||  entrenamientos.isEmpty()){
            System.out.println("no hay entrenamietos registrados para: " + nombre);
            return;
        }
        List<Entrenamientos> filtrados =  entrenamientos.stream()
                .filter(e -> "Internacional".equalsIgnoreCase(e.getUbicacion())).collect(Collectors.toList());
    if (filtrados.isEmpty()){
        System.out.println("No hay entrenamietos registrados para: " + nombre );
        return;
    }

        // se ordena la lista entrenamientos por fecha para cumplir con el requisito
        // orden de redimiento por fecha
        filtrados.sort(Comparator.comparing(Entrenamientos::getFecha));
        System.out.println("\nHistorial de entrenamientos: ");
        System.out.println("Atleta: "+nombre);
        System.out.println("Disciplina: "+ disciplina+"\n");

        System.out.printf("%-12s| %-40s| %-10s| %-10s| %-15s| %-10s|\n","Fecha","Tipo entreno ","Valor ","Unidad","Ubicacion", "pais");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (Entrenamientos e:filtrados){
            System.out.printf("%-12s| %-40s| %-10s| %-10s| %-15s| %-10s|\n",e.getFecha(),e.getTipo(),e.getValor(),
                    e.getUnidad(),e.getUbicacion() ,e.getPais());
        }
    }

    public void MostrarNacional(){

        // se verifica el nombre completo, si no hay registro en entrenamientos devuelve el string
        if (entrenamientos == null  ||  entrenamientos.isEmpty()){
            System.out.println("no hay entrenamietos registrados para: " + nombre);
            return;
        }
        List<Entrenamientos> filtrados =  entrenamientos.stream()
                .filter(e -> "Nacional".equalsIgnoreCase(e.getUbicacion())).collect(Collectors.toList());
        if (filtrados.isEmpty()){
            System.out.println("No hay entrenamietos registrados para: " + nombre );
            return;
        }

        // se ordena la lista entrenamientos por fecha para cumplir con el requisito
        // orden de redimiento por fecha
        filtrados.sort(Comparator.comparing(Entrenamientos::getFecha));
        System.out.println("\nHistorial de entrenamientos: ");
        System.out.println("Atleta: "+nombre);
        System.out.println("Disciplina: "+ disciplina+"\n");

        System.out.printf("%-12s| %-40s| %-10s| %-10s| %-15s| %-10s|\n","Fecha","Tipo entreno ","Valor ","Unidad","Ubicacion", "pais");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (Entrenamientos e:filtrados){
            System.out.printf("%-12s| %-40s| %-10s| %-10s| %-15s| %-10s|\n",e.getFecha(),e.getTipo(),e.getValor(),
                    e.getUnidad(),e.getUbicacion() ,e.getPais());
        }
    }

}
