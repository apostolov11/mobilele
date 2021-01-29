package bg.softuni.mobilele.mobilele.repository;

import bg.softuni.mobilele.mobilele.model.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
}
