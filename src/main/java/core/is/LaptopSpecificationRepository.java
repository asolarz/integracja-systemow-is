package core.is;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface LaptopSpecificationRepository extends JpaRepository<LaptopSpecificationData,Long> {

    List<LaptopSpecificationData> findAllByOrderByIdAsc();
}
