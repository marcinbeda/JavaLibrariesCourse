package pl.beda.lombok.modelForXML;

import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cloth {
    @Setter @Getter
    private String color;
    @Setter @Getter
    private Boolean isNew;
}
