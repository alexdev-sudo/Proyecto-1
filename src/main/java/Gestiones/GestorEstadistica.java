package Gestiones;
import Entidades.atleta;
import Entidades.Entrenamientos;
import java.util.Comparator;
public class GestorEstadistica {
    public double promedio(atleta atleta1){
        return atleta1.getEntrenamientos()
                .stream().mapToDouble(Entrenamientos::getValor)
                .average().orElse(0);

    }

    public double mejormarca(atleta atleta1){
        return atleta1.getEntrenamientos()
                .stream().mapToDouble(Entrenamientos::getValor)
                .max().orElse(0);
    }
    public void mostrarHistorial(atleta atleta1){
        atleta1.getEntrenamientos()
                .stream().sorted(Comparator.comparing(Entrenamientos::getFecha))
                .forEach( e -> System.out.println(e.getFecha() + " | "+e.getTipo() + " | "+e.getValor()));
    }
}
