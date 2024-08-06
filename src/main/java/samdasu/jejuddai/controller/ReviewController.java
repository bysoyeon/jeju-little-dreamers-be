package samdasu.jejuddai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import samdasu.jejuddai.dto.ReviewDTO;
import samdasu.jejuddai.entity.Review;
import samdasu.jejuddai.service.ReviewService;

import java.util.*;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 리뷰 작성
    @PostMapping("/edit")
    public ResponseEntity<Map<String, Object>> newReview(@RequestBody ReviewDTO reviewDTO) {
        Map<String, Object> response = new HashMap<>();

        boolean newReview = reviewService.insertReview(reviewDTO);

        if (newReview) {
            response.put("status", "SUCCESS");
            response.put("message", "리뷰가 등록 되었습니다.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("status", "ERROR");
            response.put("message", "리뷰 등록에 실패했습니다.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 리뷰 조회
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return review.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    // 리뷰 수정
    // 리뷰 수정
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        Map<String, Object> response = new HashMap<>();

        boolean updated = reviewService.updateReview(id, reviewDTO);

        if (updated) {
            response.put("status", "SUCCESS");
            response.put("message", "리뷰가 수정되었습니다.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("status", "ERROR");
            response.put("message", "리뷰 수정에 실패했습니다.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // 리뷰 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteReview(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        boolean deleted = reviewService.deleteReview(id);

        if (deleted) {
            response.put("status", "SUCCESS");
            response.put("message", "리뷰가 삭제되었습니다.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("status", "ERROR");
            response.put("message", "리뷰 삭제에 실패했습니다.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
