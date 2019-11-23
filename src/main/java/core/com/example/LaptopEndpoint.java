package core.com.example;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@AllArgsConstructor
public class LaptopEndpoint {
    public static final String NAMESPACE_URI = "example.com";


    private final Repo repo;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "producerLaptopRequest")
    @ResponsePayload
    public LaptopResponse getProducer(@RequestPayload GetProducerLaptopRequest request) {

        LaptopResponse response = new LaptopResponse();
        response.setLaptop(repo.findAll().stream().findFirst().get());
        return response;
    }

}
