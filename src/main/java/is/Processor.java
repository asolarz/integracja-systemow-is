package is;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Processor {
    private String cpu;
    private String cores;
    private String freq;

}
