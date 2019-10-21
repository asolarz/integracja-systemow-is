import javafx.beans.property.SimpleStringProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
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

   /* @Override
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
    }*/
}
