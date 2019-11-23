package core.com.example;

import core.is.LaptopSpecificationData;
import core.is.LaptopSpecificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.jws.WebMethod;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Endpoint
@AllArgsConstructor
public class LaptopEndpoint {
    public static final String NAMESPACE_URI = "example.com";

    private final LaptopSpecificationRepository laptopSpecificationRepository;

    @WebMethod
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "producers")
    @ResponsePayload
    public ProducerList getProducers() {

        ProducerList producerList = new ProducerList();
        Set<String> producers = laptopSpecificationRepository.findAll()
                .stream().map(laptopSpecificationData -> laptopSpecificationData.getName()).collect(Collectors.toSet());
        producerList.setProducer(new ArrayList<>(producers));
        return producerList;
    }

    @WebMethod
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "screenTypes")
    @ResponsePayload
    public ScreenTypeList getScreenTypes() {

        ScreenTypeList screenTypeList = new ScreenTypeList();
        Set<String> screenTypes = laptopSpecificationRepository.findAll()
                .stream().map(laptopSpecificationData -> laptopSpecificationData.getScreen().getScreenType()).collect(Collectors.toSet());
        screenTypeList.setScreenType(new ArrayList<>(screenTypes));
        return screenTypeList;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProducerLaptopRequest")
    @ResponsePayload
    public ProducerNumber producerNumber(@RequestPayload GetProducerLaptopRequest request) {
        ProducerNumber producerNumber = new ProducerNumber();
        int allByName = laptopSpecificationRepository.countAllByName(request.getProducer());
        producerNumber.setProducerNumber(allByName);
        return producerNumber;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getScreenTypeLaptopRequest")
    @ResponsePayload
    public LaptopResponse producerNumber(@RequestPayload GetScreenTypeLaptopRequest request) {
        LaptopResponse laptopResponse = new LaptopResponse();
        List<LaptopSpecification> collect = laptopSpecificationRepository
                .findAllByScreen(request.getScreenType())
                .stream()
                .map(LaptopSpecificationData::toLaptopSpecification)
                .collect(Collectors.toList());

        laptopResponse.setLaptop(collect);
        return laptopResponse;
    }


}
