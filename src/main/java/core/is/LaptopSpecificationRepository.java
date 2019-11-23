package core.is;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface LaptopSpecificationRepository extends JpaRepository<LaptopSpecification,Long> {

    List<LaptopSpecification> findAllByOrderByIdAsc();
}
