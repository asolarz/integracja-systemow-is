package core.is;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LaptopSpecificationRepository extends JpaRepository<LaptopSpecificationData, Long> {

    List<LaptopSpecificationData> findAllByOrderByIdAsc();




}
