package samdasu.jejuddai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import samdasu.jejuddai.entity.menu;
import samdasu.jejuddai.entity.review;
import samdasu.jejuddai.entity.store;
import samdasu.jejuddai.service.StoreService;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    // 위치 기반 스토어 정보 전달
    @GetMapping("/search")
    public List<store> getStoresByCategoryAndLocation(
        @RequestParam String category,
        @RequestParam double latitude,
        @RequestParam double longitude,
        @RequestParam double range) {
        return storeService.getStoreByCategoryAndLocation(category, latitude, longitude, range);
    }

    // 스토어 메뉴 정보 전달
    @GetMapping("/menu")
    public List<menu> getMenusByStoreId(@RequestParam Long storeId) {
        return storeService.getMenuByStoreId(storeId);
    }

    // 스토어 리뷰 정보 전달
    @GetMapping("/review")
    public List<review> getReviewsByStoreId(@RequestParam Long storeId) {
        return storeService.getReviewByStoreId(storeId);
    }
    //TODO: 수정해야함.
}
