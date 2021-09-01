package pl.beda.okHttp;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Note {
    @Getter @Setter
    private String to;
    @Getter @Setter
    private String from;
    @Getter @Setter
    private String heading;
    @Getter @Setter
    private String body;
}
