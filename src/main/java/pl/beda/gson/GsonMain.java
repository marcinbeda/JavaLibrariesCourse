package pl.beda.gson;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.extern.java.Log;
import pl.beda.lombok.modelForJSON.Cloth;
import pl.beda.lombok.modelForJSON.ExampleModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Log
public class GsonMain {

    private static Gson gson = new Gson();

    public static void main(String[] vararg) throws IOException {
        List<Cloth> clothList = Arrays.asList(new Cloth("green", true), new Cloth("Red", false));

        ExampleModel exampleModel1 = ExampleModel.builder()
                .cloths(clothList)
                .hairColor("Blond")
                .height(190)
                .isMale(true)
                .age(24)
                .build();

        ExampleModel exampleModel2 = ExampleModel.builder()
                .cloths(clothList)
                .hairColor("Black")
                .height(195)
                .isMale(false)
                .age(22)
                .build();

        List<ExampleModel> listOld = Arrays.asList(exampleModel1, exampleModel2);

        String json = gson.toJson(listOld);
        log.info(json);

        File out = new File("src/main/java/pl/beda/gson/exampleJSON.json");
        FileWriter fileWriter = new FileWriter(out);
        fileWriter.write(json);
        fileWriter.close();

        List<ExampleModel> newList = gson.fromJson(json, new TypeToken<List<ExampleModel>>() {
        }.getType());

        System.out.println(listOld.equals(newList));
    }
}
