package core.is;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@XmlRootElement(name = "Laptops")
@XmlAccessorType(XmlAccessType.FIELD)
class LaptopSpecificationCollection {
    @XmlElement(name = "Laptop")
    private List<LaptopSpecificationData> laptopSpecificationDataList;

    public LaptopSpecificationCollection(List<LaptopSpecificationData> laptopSpecificationDataList) {
        this.laptopSpecificationDataList = laptopSpecificationDataList;
    }

    public LaptopSpecificationCollection() {
        laptopSpecificationDataList = new ArrayList<LaptopSpecificationData>();
    }

    void print() {
        for (LaptopSpecificationData specification : laptopSpecificationDataList) {

            System.out.println(specification.toString());
        }
    }

    void readFromFile(String filename) throws IOException {
        InputStream inputStream = new FileInputStream(new File(filename));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(";", 17);
            LaptopSpecificationData pc = LaptopSpecificationData.getLaptopSpecification(split);
            laptopSpecificationDataList.add(pc);
        }
    }

    List<LaptopSpecificationResponse> toResponse() {
        return laptopSpecificationDataList
                .stream()
                .map(ls -> ls.toResponse())
                .collect(Collectors.toList());
    }

    public List<LaptopSpecificationData> getLaptopSpecificationDataList() {
        return laptopSpecificationDataList;
    }

    public void setLaptopSpecificationDataList(List<LaptopSpecificationData> laptopSpecificationDataList) {
        this.laptopSpecificationDataList = laptopSpecificationDataList;
    }
}
