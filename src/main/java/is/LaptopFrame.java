package is;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class LaptopFrame  {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(LaptopFrame.class,args);
        LaptopSpecificationCollection laptopSpecificationCollection = new LaptopSpecificationCollection();
//        laptopSpecificationCollection.readFromFile("katalog.txt");

    }





}
