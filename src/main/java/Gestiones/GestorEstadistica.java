package Gestiones;
import Entidades.atleta;
import Entidades.Entrenamientos;
import java.util.Comparator;
public class GestorEstadistica {
    public double promedio(atleta atleta1){
        return atleta1.getEntrenamientos()
                .stream().mapToDouble(Entrenamientos::getValor)
                .average().orElse(0) ;

    }

        public double mejormarca(atleta atleta1){
        if (atleta1.getEntrenamientos()== null || atleta1.getEntrenamientos().isEmpty()){
        return 0;
        }
        double mejor = (atleta1.getEntrenamientos().get(0).getValor());
         String unidad = atleta1.getEntrenamientos().get(0).getUnidad().toLowerCase();

        for (Entrenamientos e : atleta1.getEntrenamientos()){
            String u = e.getUnidad().toLowerCase();
            if (u.equals("segundos")){// para tiempo menor es mejor
                if (e.getValor()< mejor){
                    mejor = e.getValor();
                    unidad = u ;
                }
            }else if (!u.equals("segundos")){// para las diciplinas donde marca es a mayor marca es mejor
               if (e.getValor() > mejor){
                   mejor = e.getValor();
                   unidad = u ;
               }
            }
        }
            return mejor;
    }
    public void mostrarHistorial(atleta atleta1){
        atleta1.getEntrenamientos()
                .stream().sorted(Comparator.comparing(Entrenamientos::getFecha))
                .forEach( e -> System.out.println(e.getFecha() + " | "+e.getTipo() + " | "+e.getValor()));
    }

}
