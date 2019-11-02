package is;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LaptopSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
                name + "\t" + "\t" +
                        displaySize + "\t" + "\t" +
                        resolution + "\t" + "\t" +
                        screenType + "\t" + "\t" +
                        touchpad + "\t" + "\t" +
                        cpu + "\t" + "\t" +
                        cores + "\t" + "\t" +
                        freq + "\t" + "\t" +
                        ram + "\t" + "\t" +
                        space + "\t" + "\t" +
                        discType + "\t" + "\t" +
                        gpu + "\t" + "\t" +
                        gpuRam + "\t" + "\t" +
                        os + "\t" + "\t" +
                        dvd + "\t";
    }


    public static LaptopSpecification getLaptopSpecification(String[] split) {
        return LaptopSpecification.builder()
                .id(Long.valueOf((split[0])))
                .name((split[1]))
                .displaySize((split[2]))
                .resolution((split[3]))
                .screenType((split[4]))
                .touchpad((split[5]))
                .cpu((split[6]))
                .cores((split[7]))
                .freq((split[8]))
                .ram((split[9]))
                .space((split[10]))
                .discType((split[11]))
                .gpu((split[12]))
                .gpuRam((split[13]))
                .os((split[14]))
                .dvd((split[15]))
                .build();
    }
}
