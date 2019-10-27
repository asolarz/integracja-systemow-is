package is;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaptopSpecification {
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


    String toSemiColonSeparatedSpec() {
        return name + ";" +
                displaySize + ";" +
                resolution + ";" +
                screenType + ";" +
                touchpad + ";" +
                cpu + ";" +
                cores + ";" +
                freq + ";" +
                ram + ";" +
                space + ";" +
                discType + ";" +
                gpu + ";" +
                gpuRam + ";" +
                os + ";" +
                dvd + ";\n"
                ;
    }

   @Override
    public String toString() {
        return
                name +"\t"+"\t"+
        displaySize +"\t"+"\t"+
        resolution +"\t"+"\t"+
        screenType +"\t"+"\t"+
        touchpad +"\t"+"\t"+
        cpu +"\t"+"\t"+
        cores +"\t"+"\t"+
        freq +"\t"+"\t"+
        ram +"\t"+"\t"+
        space +"\t"+"\t"+
        discType +"\t"+"\t"+
        gpu +"\t"+"\t"+
        gpuRam +"\t"+"\t"+
        os +"\t"+"\t"+
        dvd +"\t";
    }


    public static LaptopSpecification getLaptopSpecification(String[] split) {
        return LaptopSpecification.builder()
                .name((split[0]))
                .displaySize((split[1]))
                .resolution((split[2]))
                .screenType((split[3]))
                .touchpad((split[4]))
                .cpu((split[5]))
                .cores((split[6]))
                .freq((split[7]))
                .ram((split[8]))
                .space((split[9]))
                .discType((split[10]))
                .gpu((split[11]))
                .gpuRam((split[12]))
                .os((split[13]))
                .dvd((split[14]))
                .build();
    }
}
