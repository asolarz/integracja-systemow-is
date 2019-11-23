package core.is;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LaptopSpecificationData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlAttribute
    private Long id;
    private String name;
    @Embedded
    private Screen screen;
    private String touchpad;
    @Embedded
    private Processor processor;
    private String ram;
    private String space;
    private String discType;
    private String gpu;
    private String gpuRam;
    private String os;
    private String dvd;


    String toSemiColonSeparatedSpec() {
        return
                id + ";" +
                        name + ";" +
                        screen.getDisplaySize() + ";" +
                        screen.getResolution() + ";" +
                        screen.getScreenType() + ";" +
                        touchpad + ";" +
                        processor.getCpu() + ";" +
                        processor.getCores() + ";" +
                        processor.getFreq() + ";" +
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
                        screen.getDisplaySize() + "\t" + "\t" +
                        screen.getResolution() + "\t" + "\t" +
                        screen.getScreenType() + "\t" + "\t" +
                        touchpad + "\t" + "\t" +
                        processor.getCpu() + "\t" + "\t" +
                        processor.getCores() + "\t" + "\t" +
                        processor.getFreq() + "\t" + "\t" +
                        ram + "\t" + "\t" +
                        space + "\t" + "\t" +
                        discType + "\t" + "\t" +
                        gpu + "\t" + "\t" +
                        gpuRam + "\t" + "\t" +
                        os + "\t" + "\t" +
                        dvd + "\t";
    }


    public static LaptopSpecificationData getLaptopSpecification(String[] split) {
        return LaptopSpecificationData.builder()
                .id(Long.valueOf((split[0])))
                .name((split[1]))
                .screen(Screen.builder()
                        .displaySize((split[2]))
                        .resolution((split[3]))
                        .screenType((split[4]))
                        .build())
                .touchpad((split[5]))
                .processor(Processor.builder()
                        .cpu((split[6]))
                        .cores((split[7]))
                        .freq((split[8]))
                        .build())
                .ram((split[9]))
                .space((split[10]))
                .discType((split[11]))
                .gpu((split[12]))
                .gpuRam((split[13]))
                .os((split[14]))
                .dvd((split[15]))
                .build();
    }

    LaptopSpecificationResponse toResponse() {
        return LaptopSpecificationResponse.builder()
                .id(id)
                .name(name)
                .displaySize(screen.getDisplaySize())
                .resolution(screen.getResolution())
                .screenType(screen.getScreenType())
                .touchpad(touchpad)
                .cpu(processor.getCpu())
                .cores(processor.getCores())
                .freq(processor.getFreq())
                .ram(ram)
                .space(space)
                .discType(discType)
                .gpu(gpu)
                .gpuRam(gpuRam)
                .os(os)
                .dvd(dvd)
                .build();


    }
}
