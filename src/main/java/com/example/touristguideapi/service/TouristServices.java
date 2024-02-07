package com.example.touristguideapi.service;

import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.repository.TouristRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TouristServices {

    private TouristRepository repository;

    public TouristServices() {
        repository = new TouristRepository();
    }

    public List<TouristAttraction> getTouristAttractions() {
        return repository.getTouristAttractionList();
    }

    public TouristAttraction getTouristAttraction(String name) {
        return repository.getTouristAttraction(name);
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) {
        TouristAttraction newTouristAttraction = repository.addTouristAttraction(touristAttraction);
        return newTouristAttraction;
    }

    public TouristAttraction updateTouristAttraction(TouristAttraction touristAttraction) {
        TouristAttraction updatedTouristAttraction = repository.updateTouristAttraction(touristAttraction);
        return updatedTouristAttraction;
    }

    public TouristAttraction deleteTouristAttraction(String name) {
        TouristAttraction deletedTouristAttraction = repository.deleteTouristAttraction(name);
        if (deletedTouristAttraction != null) {
            return deletedTouristAttraction;
        }
        return new TouristAttraction("Fail", "TouristAttraction, not found");
    }


}
