package core.com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface Repo extends JpaRepository<LaptopSpecification,Long> {


}
