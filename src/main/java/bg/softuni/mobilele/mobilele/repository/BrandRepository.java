package bg.softuni.mobilele.mobilele.repository;

import bg.softuni.mobilele.mobilele.model.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
