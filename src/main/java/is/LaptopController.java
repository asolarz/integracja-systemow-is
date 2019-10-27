package is;


import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/laptops")
public class LaptopController {

    @GetMapping
    List<LaptopSpecification> list() throws IOException {
        LaptopSpecificationCollection laptopSpecificationCollection = new LaptopSpecificationCollection();
        laptopSpecificationCollection.readFromFile("katalog.txt");
        return laptopSpecificationCollection.getLaptopSpecificationList();
    }

    @PostMapping
    void save(@RequestBody List<String[]> laptopSpecifications) {

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
