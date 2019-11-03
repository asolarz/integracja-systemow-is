package is;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "Laptops")
@XmlAccessorType(XmlAccessType.FIELD)
class LaptopSpecificationCollection {
    @XmlElement(name = "Laptop")
    List<LaptopSpecification> laptopSpecificationList;

    public LaptopSpecificationCollection(List<LaptopSpecification> laptopSpecificationList) {
        this.laptopSpecificationList = laptopSpecificationList;
    }

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
            String[] split = line.split(";", 17);
            LaptopSpecification pc = LaptopSpecification.getLaptopSpecification(split);
            laptopSpecificationList.add(pc);
        }
    }

    void toXml() throws JAXBException {


    }

    public List<LaptopSpecification> getLaptopSpecificationList() {
        return laptopSpecificationList;
    }

    public void setLaptopSpecificationList(List<LaptopSpecification> laptopSpecificationList) {
        this.laptopSpecificationList = laptopSpecificationList;
    }
}
