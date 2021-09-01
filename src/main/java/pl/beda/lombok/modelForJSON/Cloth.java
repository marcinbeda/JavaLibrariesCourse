package pl.beda.lombok.modelForJSON;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cloth {
    private String color;
    private Boolean isNew;
}
