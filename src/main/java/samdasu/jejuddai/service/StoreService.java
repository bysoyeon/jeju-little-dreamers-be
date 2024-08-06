package samdasu.jejuddai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samdasu.jejuddai.entity.store;
import samdasu.jejuddai.repository.StoreRepository;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public List<store> getStoreByCategoryAndLocation(String category, double lat, double lon, double range){
        double latStart = lat - range;
        double latEnd = lat + range;
        double lonStart = lon - range;
        double lonEnd = lon + range;

        return storeRepository.findByCategoryAndLatitudeBetweenAndLongitudeBetween(category, latStart, latEnd, lonStart, lonEnd);
    }

    public store getStoreDetails(int store_id) {
        return storeRepository
    }
}
