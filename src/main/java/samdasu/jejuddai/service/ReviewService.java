package samdasu.jejuddai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samdasu.jejuddai.dto.ReviewDTO;
import samdasu.jejuddai.entity.Review;
import samdasu.jejuddai.repository.ReviewRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // 리뷰 작성
    public boolean insertReview(ReviewDTO reviewDTO) {
        try {
            Review review = Review.builder()
                    .content(reviewDTO.getContent())
                    .grade(reviewDTO.getGrade())
                    .image(reviewDTO.getImage())
                    .updated_at(LocalDateTime.now())
                    .build();
            reviewRepository.save(review);
            return true;
        } catch (Exception e) {
            // 로깅 등 필요한 예외 처리
            return false;
        }
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public boolean updateReview(Long id, ReviewDTO reviewDTO) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            review.setContent(reviewDTO.getContent());
            review.setGrade(reviewDTO.getGrade());
            review.setImage(reviewDTO.getImage());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    public boolean deleteReview(Long id) {
        try {
            reviewRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            // 로깅 등 필요한 예외 처리
            return false;
        }
    }

}
