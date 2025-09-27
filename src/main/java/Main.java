
import Entidades.*;
import Gestiones.*;
import Persistencia.GestorJSON;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Gestor_Atletas gestor = new Gestor_Atletas();
    GestorEstadistica estadisticas = new GestorEstadistica();
    GestorJSON json = new GestorJSON();

    // cargar datos previos
        var atletascargados = json.cargar();
        if (atletascargados != null) {
            atletascargados.forEach(gestor :: agregar);
        }
        Scanner leer = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("\n---sistema de control de rendimiento de atletas---");
            System.out.println("1. registrar nuevo atleta");
            System.out.println("2. registrar entrenamiento");
            System.out.println("3. Mostrar historial de un atleta");
            System.out.println("4. Mostrar estadisticas de un atleta");
            System.out.println("5. Mostrar Rendimiento Nacional VS Internacional");
            System.out.println("6. Guardar y salir");
            System.out.print("seleccione una opcion: ");
            opcion = leer.nextInt();
            switch(opcion) {
                case 1:
                    leer.nextLine();
                    System.out.println("Ingresa el nombre del atleta: ");
                    String nombreregistro = leer.nextLine();
                    System.out.println("ingrese la edad del atleta: ");
                    int edad = leer.nextInt();
                    leer.nextLine();
                    System.out.println("ingrese departamento del atleta: ");
                    String depart = leer.nextLine();
                    System.out.println("ingrese disciplina del atleta: ");
                    String disc = leer.nextLine();
                    System.out.println("ingrese nacionalidad del atleta: ");
                    String nacionalidad = leer.nextLine();
                    System.out.println("ingrese fechaingreso del atleta Formato (ddmmaaaa):  ");
                    String fechaingreso = atleta.leerfecha(leer);

                    atleta atleta1 = new atleta(nombreregistro, edad, depart, new Disciplina(disc),
                            nacionalidad, fechaingreso);
                    gestor.agregar(atleta1);
                    System.out.println("atleta registrado exitosamente");

                    break;
                case 2:
                    leer.nextLine();
                    System.out.println("Ingresa el nombre del atleta: ");
                    String nombreatleta = leer.nextLine();
                    atleta a = gestor.buscar(nombreatleta);
                    if (nombreatleta != null) {
                        System.out.println("ingrese tipo de entrenamiento del atleta: ");
                        String tipo = leer.nextLine();
                        System.out.println("Ingrese valor del entrenamiento del atleta:(digito) ");
                        double datoentreno = leer.nextDouble();
                        leer.nextLine();
                        System.out.println("Ingrese la unidad de medida del entrenamiento");
                        String unidad = leer.nextLine();
                        System.out.println("ingrese la ubicacion del entrenanmiento\n" +
                                "1. Nacional\n" +
                                "2. Internacional (indicar pais)\n");
                        String ubicacion = Entrenamientos.paisubicacion(leer);
                        leer.nextLine();
                        System.out.println("Ingrese pais del entrenamiento");
                        String pais = leer.nextLine();
                        a.agregarEntrenamiento(new Entrenamientos(LocalDate.now(), tipo, datoentreno,
                                unidad, ubicacion, pais));
                        System.out.println("entrenamiento agregado exitosamente");
                    } else {
                        System.out.println("ateleta no existe");

                    }
                    break;
                case 3:
                    leer.nextLine();
                    System.out.println("Ingresa el nombre del atleta: ");
                    String nombrehistorial = leer.nextLine();
                    atleta h = gestor.buscar(nombrehistorial);
                    if (h != null) {
                        h.mostrarhistorial();
                    } else {
                        System.out.println("Lista vacia, imposible buscar atleta");

                    }

                    break;
                case 4:
                    leer.nextLine();
                    System.out.println("Ingresa el nombrere del atleta: ");
                    String nombreestadistica = leer.nextLine();
                    atleta s = gestor.buscar(nombreestadistica);
                    if (s != null) {
                        System.out.println("-- Estadisticas del atleta-- :" + nombreestadistica);
                        System.out.println("Promedio: " + estadisticas.promedio(s) + " " + s.getEntrenamientos().get(0));
                        System.out.println("Mejor Marca: " + estadisticas.mejormarca(s) + ": " + s.getEntrenamientos().get(0).getUnidad());
                        s.mostrarhistorial();

                    } else {
                        System.out.println("atleta no existe");

                    }
                    break;
                case 5:
                    leer.nextLine();
                    System.out.println("---------------------------------------");
                    if (gestor.getAtletas().isEmpty()){
                        System.out.println("Lista vacia, imposible buscar atleta");
                        break;
                    }
                    // Mostrar Listado de atletas
                    System.out.println("Lista de atletas registrados");
                    for (int posicion = 0; posicion < gestor.getAtletas().size(); posicion++) {
                        System.out.println((posicion + 1) + "." + gestor.getAtletas().get(posicion).getNombre());
                    }
                    System.out.println("----------------------------------------");
                    System.out.println("Elige un atleta (numero) : ");
                    int opcionatleta = leer.nextInt();
                    if (opcionatleta >= 1 && opcionatleta <= gestor.getAtletas().size()) {
                        atleta seleccionado = gestor.getAtletas().get(opcionatleta - 1);
                        System.out.println("Seleccionaste : " + seleccionado.getNombre());
                        //llamamos a metodo compararrendimiento
                        GestorEstadistica.compararrendimiento(seleccionado);

                        System.out.println("----- Historial Nacional -----");
                        seleccionado.MostrarNacional();
                        System.out.println("----- Historial Internacional -----");
                        seleccionado.mostrarInternacionall();
                    } else {
                        System.out.println("opcion invalida");
                    }


                    break;
                case 6:
                    json.guardar(gestor.getAtletas());
                    System.out.println("datos guardados exitosamente");
                    break;
                default:
                    System.out.println("opcion invalida");

            }

        }while(opcion!=6);

    }
}
