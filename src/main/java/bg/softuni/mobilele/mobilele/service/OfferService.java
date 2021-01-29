package bg.softuni.mobilele.mobilele.service;

import bg.softuni.mobilele.mobilele.model.view.OfferSummaryViewModel;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OfferService {

    List<OfferSummaryViewModel> getAllOffers();
}
