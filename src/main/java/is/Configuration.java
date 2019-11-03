package is;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Configuration {

    @Value("${is.text-file}")
    private String textFilename;

    @Value("${is.xml-file}")
    private String xmlFilename;
}
