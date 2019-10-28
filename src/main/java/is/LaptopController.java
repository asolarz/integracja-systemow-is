package is;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/laptops")
@AllArgsConstructor
public class LaptopController {

    private final LaptopSpecificationService laptopSpecificationService;

    @GetMapping("/file")
    List<LaptopSpecification> fileList() throws IOException {
        return laptopSpecificationService.fileList();
    }

    @GetMapping("/database")
    List<LaptopSpecification> databaseList() {
        return laptopSpecificationService.databaseList();

    }

    @PostMapping
    void saveToFile(@RequestBody List<String[]> laptopSpecifications) {

       laptopSpecificationService.saveToFile(laptopSpecifications);

    }

}
