package is;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Processor {
    String cpu;
    String cores;
    String freq;

}
