import javafx.beans.property.SimpleStringProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
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
}
