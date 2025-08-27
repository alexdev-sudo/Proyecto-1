package Persistencia;
import Entidades.atleta;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.*;
import java.io.IOException;
import java.util.List;
public class GestorJSON {
    private static final String ARCHIVO = "atletas.json";
    private final Gson gson;

    public GestorJSON() {
        gson = new GsonBuilder().registerTypeAdapter(
                LocalDate.class, new JsonSerializer<LocalDate>() {
                    @Override
                    public JsonElement serialize(LocalDate src, java.lang.reflect.Type typeOfSrc,
                                                 JsonSerializationContext context) {
                        return new JsonPrimitive(src.format(DateTimeFormatter.ISO_DATE));
                    }
                }).registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE);
            }
        }).setPrettyPrinting().create();

    }
    public void guardar(List<atleta> atletas1) {
        try (Writer writer = new FileWriter(ARCHIVO)) {
        new Gson().toJson(atletas1, writer);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public List<atleta> cargar() {
    try(Reader reader = new FileReader(ARCHIVO)){
        atleta [] atleta1 = gson.fromJson(reader, atleta[].class);
        if (atleta1 != null){
            List<atleta> lista   = new ArrayList<>();
            for (atleta a : atleta1) {
                lista.add(a);
            }
            return lista;
        }

    } catch (IOException e) {
        System.out.println("no se encontro archivo JSON iniciando vacio ");
    }
    return new ArrayList<>();
    }
}
