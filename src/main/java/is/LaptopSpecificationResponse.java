package is;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LaptopSpecificationResponse {
    Long id;
    String name;
    String displaySize;
    String resolution;
    String screenType;
    String touchpad;
    String cpu;
    String cores;
    String freq;
    String ram;
    String space;
    String discType;
    String gpu;
    String gpuRam;
    String os;
    String dvd;
}
