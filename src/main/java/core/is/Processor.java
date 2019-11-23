package core.is;

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

    public com.example.Processor toCpu() {
        com.example.Processor processor = new com.example.Processor();
        processor.setCpu(cpu);
        processor.setCores(cores);
        processor.setFreq(freq);
        return processor;
    }
}
