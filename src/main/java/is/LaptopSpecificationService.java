package is;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class LaptopSpecificationService {

    private final LaptopSpecificationRepository laptopSpecificationRepository;


    List<LaptopSpecificationResponse> databaseList() {
        return new LaptopSpecificationCollection(laptopSpecificationRepository
                .findAllByOrderByIdAsc())
                .toResponse();

    }

    List<LaptopSpecificationResponse> fileList() throws IOException {
        LaptopSpecificationCollection laptopSpecificationCollection = new LaptopSpecificationCollection();
        laptopSpecificationCollection.readFromFile("katalog.txt");
        return laptopSpecificationCollection.toResponse();
    }

    void saveToFile(List<String[]> laptopSpecifications) {
        List<LaptopSpecification> specifications = getLaptopSpecifications(laptopSpecifications);
        FileWriter.exportToFile(specifications
                .stream()
                .map(LaptopSpecification::toSemiColonSeparatedSpec)
                .collect(Collectors.joining("")));
    }

    void saveToDatabase(List<String[]> laptopSpecifications) {
        List<LaptopSpecification> specifications = getLaptopSpecifications(laptopSpecifications);
        laptopSpecificationRepository.saveAll(specifications);

    }

    private List<LaptopSpecification> getLaptopSpecifications(List<String[]> laptopSpecifications) {
        List<LaptopSpecification> specifications = new ArrayList<>();
        for (String[] line : laptopSpecifications
        ) {
            LaptopSpecification pc = LaptopSpecification.getLaptopSpecification(line);
            specifications.add(pc);
        }
        return specifications;
    }

    void saveToXml(List<String[]> laptopSpecifications) throws JAXBException {
        LaptopSpecificationCollection laptopSpecificationCollection =
                new LaptopSpecificationCollection(getLaptopSpecifications(laptopSpecifications));
        JAXBContext jaxbContext = JAXBContext.newInstance(LaptopSpecificationCollection.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        File file = new File("katalog.xml");
        marshaller.marshal(laptopSpecificationCollection, file);
    }
}
