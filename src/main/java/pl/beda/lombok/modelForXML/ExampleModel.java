package pl.beda.lombok.modelForXML;

import lombok.*;
import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ExampleModel {
    @Getter @Setter
    private String hairColor;
    @Getter @Setter
    private int height;
    @Getter @Setter
    private int width;
    @Getter @Setter
    private boolean isMale;
    @Getter @Setter
    private int age;
    @Getter @Setter
    private List<Cloth> cloths;
}
