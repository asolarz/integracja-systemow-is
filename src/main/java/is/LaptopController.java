package is;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/laptops")
@AllArgsConstructor
public class LaptopController {

    private final LaptopSpecificationService laptopSpecificationService;

    @GetMapping("/file")
    List<LaptopSpecificationResponse> fileList() throws IOException {
        return laptopSpecificationService.fileList();
    }

    @GetMapping("/database")
    List<LaptopSpecificationResponse> databaseList() {
        return laptopSpecificationService.databaseList();
    }

    @GetMapping("/xml")
    List<LaptopSpecificationResponse> xmlList() throws JAXBException {
        return laptopSpecificationService.xmlList();
    }

    @PostMapping("/file")
    void saveToFile(@RequestBody List<String[]> laptopSpecifications) {
        laptopSpecificationService.saveToFile(laptopSpecifications);
    }

    @PostMapping("/database")
    void saveToDatabase(@RequestBody List<String[]> laptopSpecifications) {
        laptopSpecificationService.saveToDatabase(laptopSpecifications);
    }

    @PostMapping("/xml")
    void saveToXml(@RequestBody List<String[]> laptopSpecifications) throws JAXBException {
        laptopSpecificationService.saveToXml(laptopSpecifications);
    }

}
