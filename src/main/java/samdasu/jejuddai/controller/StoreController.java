package samdasu.jejuddai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import samdasu.jejuddai.entity.store;
import samdasu.jejuddai.service.StoreService;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/search")
    public List<store> getStoresByCategoryAndLocation(
        @RequestParam String category,
        @RequestParam double latitude,
        @RequestParam double longitude,
        @RequestParam double range) {
        return storeService.getStoreByCategoryAndLocation(category, latitude, longitude, range);
    }

    @GetMapping("/details")
    public store getStoreDetails(
        @RequestParam int store_id
    ) {
        return storeService.getStoreDetails(store_id);
    }
    //TODO: 수정해야함.
}
