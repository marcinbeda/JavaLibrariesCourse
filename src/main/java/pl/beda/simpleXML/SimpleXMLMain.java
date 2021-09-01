package pl.beda.simpleXML;

import lombok.extern.java.Log;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import pl.beda.lombok.modelForXML.Cloth;
import pl.beda.lombok.modelForXML.ExampleModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Log
public class SimpleXMLMain {

    public static void main(String[] args) throws Exception {
        List<Cloth> clothList = new ArrayList<>();
        clothList.add(new Cloth("Green", true));
        clothList.add(new Cloth("Red", false));

        ExampleModel exampleModel1 = new ExampleModel();
        exampleModel1.setCloths(clothList);
        exampleModel1.setHairColor("Blond");
        exampleModel1.setHeight(190);
        exampleModel1.setMale(true);
        exampleModel1.setAge(24);

        ExampleModel exampleModel2 = new ExampleModel();
        exampleModel2.setCloths(clothList);
        exampleModel2.setHairColor("Black");
        exampleModel2.setHeight(195);
        exampleModel2.setMale(false);
        exampleModel2.setAge(22);

        Serializer serializer = new Persister();

        File out = new File("src/main/java/pl/beda/simpleXML/exampleXML.xml");
        serializer.write(exampleModel1, out);

        ExampleModel exampleModel1Read = serializer.read(ExampleModel.class, out);
        log.info(String.valueOf(exampleModel1Read.equals(exampleModel1)));
    }
}
