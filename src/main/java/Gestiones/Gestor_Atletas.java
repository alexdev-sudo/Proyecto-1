package Gestiones;
import Entidades.Entrenamientos;
import Entidades.atleta;
import java.util.ArrayList;
import java.util.List;

public class Gestor_Atletas implements  Igestor<atleta>{

    private List<atleta> atletas = new ArrayList<>();
    @Override
    public void agregar (atleta a){
        atletas.add(a);
    }

    @Override
public atleta buscar (String nombre) {
    return atletas.stream().filter(a -> a.getNombre().equalsIgnoreCase(nombre))
            .findFirst().orElse(null);
    }
public List<atleta> getAtletas() {
        return atletas;
}
}