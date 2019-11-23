package core.is;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class LaptopSpecificationService {

    private final LaptopSpecificationRepository laptopSpecificationRepository;
    private final Configuration config;


    List<LaptopSpecificationResponse> databaseList() {
        return new LaptopSpecificationCollection(laptopSpecificationRepository
                .findAllByOrderByIdAsc())
                .toResponse();
    }

    List<LaptopSpecificationResponse> fileList() throws IOException {
        LaptopSpecificationCollection laptopSpecificationCollection = new LaptopSpecificationCollection();
        laptopSpecificationCollection.readFromFile(config.getTextFilename());
        return laptopSpecificationCollection.toResponse();
    }

    void saveToFile(List<String[]> laptopSpecifications) {
        List<LaptopSpecificationData> specifications = getLaptopSpecifications(laptopSpecifications);
        String formattedData = specifications
                .stream()
                .map(LaptopSpecificationData::toSemiColonSeparatedSpec)
                .collect(Collectors.joining(""));

        FileWriter.exportToFile(formattedData, config.getTextFilename());
    }

    void saveToDatabase(List<String[]> laptopSpecifications) {
        List<LaptopSpecificationData> specifications = getLaptopSpecifications(laptopSpecifications);
        laptopSpecificationRepository.saveAll(specifications);

    }

    void saveToXml(List<String[]> laptopSpecifications) throws JAXBException {
        LaptopSpecificationCollection laptopSpecificationCollection =
                new LaptopSpecificationCollection(getLaptopSpecifications(laptopSpecifications));
        JAXBContext jaxbContext = JAXBContext.newInstance(LaptopSpecificationCollection.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(laptopSpecificationCollection, new File(config.getXmlFilename()));
    }

    List<LaptopSpecificationResponse> xmlList() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(LaptopSpecificationCollection.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        LaptopSpecificationCollection laptopSpecificationCollection =
                (LaptopSpecificationCollection) unmarshaller.unmarshal(new File(config.getXmlFilename()));
        return laptopSpecificationCollection.toResponse();
    }


    private List<LaptopSpecificationData> getLaptopSpecifications(List<String[]> laptopSpecifications) {
        List<LaptopSpecificationData> specifications = new ArrayList<>();
        for (String[] line : laptopSpecifications
        ) {
            LaptopSpecificationData pc = LaptopSpecificationData.getLaptopSpecification(line);
            specifications.add(pc);
        }
        return specifications;
    }
}
