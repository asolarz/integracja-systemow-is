package is;

import lombok.Getter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Getter
class LaptopSpecificationCollection {
    List<LaptopSpecification> laptopSpecificationList;

    public LaptopSpecificationCollection() {
        laptopSpecificationList = new ArrayList<LaptopSpecification>();
    }

    void print() {
        for (LaptopSpecification specification : laptopSpecificationList) {

            System.out.println(specification.toString());
        }
    }

    void readFromFile(String filename) throws IOException {
//        InputStream inputStream = is.LaptopSpecificationCollection.class.getResourceAsStream(filename);
        InputStream inputStream = new FileInputStream(new File(filename));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(";", 16);
            LaptopSpecification pc = LaptopSpecification.getLaptopSpecification(split);
            laptopSpecificationList.add(pc);
        }
    }




}
