import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Getter
class LaptopSpecificationCollection {
    ObservableList<LaptopSpecification> laptopSpecificationList;

    public LaptopSpecificationCollection() {
        laptopSpecificationList = FXCollections.observableArrayList();
    }

    void print() {
        for (LaptopSpecification specification : laptopSpecificationList) {

            System.out.println(specification.toString());
        }
    }

    void readFromFile(String filename) throws IOException {
//        InputStream inputStream = LaptopSpecificationCollection.class.getResourceAsStream(filename);
        InputStream inputStream = new FileInputStream(new File(filename));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(";", 16);
            LaptopSpecification pc = LaptopSpecification.builder()
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
            laptopSpecificationList.add(pc);
        }
    }


}
