package core.is;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaptopSpecificationRepository extends JpaRepository<LaptopSpecificationData, Long> {

    List<LaptopSpecificationData> findAllByOrderByIdAsc();

    List<LaptopSpecificationData> findAllByScreen_ScreenType(String type);

    int countAllByName(String name);

    default List<LaptopSpecificationData> findAllByScreen(String type) {
        return findAllByScreen_ScreenType(type);
    }


}
