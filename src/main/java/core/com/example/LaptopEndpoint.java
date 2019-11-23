package core.com.example;

import com.example.LaptopSpecification;
import core.is.LaptopSpecificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.jws.WebMethod;
import java.util.ArrayList;
import java.util.List;

@Endpoint
@AllArgsConstructor
public class LaptopEndpoint {
    public static final String NAMESPACE_URI = "example.com";

    private final LaptopSpecificationRepository laptopSpecificationRepository;

    @WebMethod
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProducerLaptopRequest")
    @ResponsePayload
    public LaptopResponse getProducer(@RequestPayload GetProducerLaptopRequest request) {

        LaptopResponse laptopResponse = new LaptopResponse();
        String producer = request.name;
        List<LaptopSpecification> response = new ArrayList<>();
        laptopSpecificationRepository
                .findAllByName(producer)
                .stream()
                .forEach(laptopSpecificationData -> response.add(laptopSpecificationData.toLaptopSpecification()));
        laptopResponse.setLaptop(response);
        return laptopResponse;
    }





}
