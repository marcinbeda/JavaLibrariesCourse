package pl.beda.lombok.modelForJSON;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExampleModel {
    private String hairColor;
    private int height;
    private int width;
    private boolean isMale;
    private int age;
    private List<Cloth> cloths;
}
