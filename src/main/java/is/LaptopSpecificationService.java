package is;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class LaptopSpecificationService {

    private final LaptopSpecificationRepository laptopSpecificationRepository;

    List<LaptopSpecification> databaseList() {
        return laptopSpecificationRepository.findAll();
    }

    List<LaptopSpecification> fileList() throws IOException {
        LaptopSpecificationCollection laptopSpecificationCollection = new LaptopSpecificationCollection();
        laptopSpecificationCollection.readFromFile("katalog.txt");
        return laptopSpecificationCollection.getLaptopSpecificationList();
    }

    void saveToFile(List<String[]> laptopSpecifications) {
        List<LaptopSpecification> specifications = new ArrayList<>();
        for (String[] line : laptopSpecifications
        ) {
            LaptopSpecification pc = LaptopSpecification.getLaptopSpecification(line);
            specifications.add(pc);
        }
        FileWriter.exportToFile(specifications
                .stream()
                .map(LaptopSpecification::toSemiColonSeparatedSpec)
                .collect(Collectors.joining("")));
    }
}
