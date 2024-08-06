package samdasu.jejuddai.controller;

import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import samdasu.jejuddai.entity.menu;
import samdasu.jejuddai.entity.review;
import samdasu.jejuddai.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/menus")
    public List<menu> getMenusByStoreId(@RequestParam Long storeId) {
        return reviewService.getMenuByStoreId(storeId);
    }

    @GetMapping
    public List<review> getReviewsByStoreId(@RequestParam Long storeId) {
        return reviewService.getReviewByStoreId(storeId);
    }
}

