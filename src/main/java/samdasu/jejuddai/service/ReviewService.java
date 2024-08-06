package samdasu.jejuddai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import samdasu.jejuddai.dto.ReviewDTO;
import samdasu.jejuddai.entity.Review;
import samdasu.jejuddai.entity.Store;
import samdasu.jejuddai.entity.User;
import samdasu.jejuddai.repository.ReviewRepository;
import samdasu.jejuddai.repository.StoreRepository;
import samdasu.jejuddai.repository.UserRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    // 신규 리뷰 작성 + 이미지
    public ReviewDTO saveReview(ReviewDTO reviewDTO, MultipartFile image1, MultipartFile image2, MultipartFile image3) throws IOException, IOException {
        Long userId = reviewDTO.getUser_id();
        String storeId = reviewDTO.getStore_id();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid store ID"));

        Review review = Review.builder()
                .user(user)
                .store(store)
                .content(reviewDTO.getContent())
                .grade(reviewDTO.getGrade())
                .image1(image1 != null ? image1.getBytes() : null)
                .image2(image2 != null ? image2.getBytes() : null)
                .image3(image3 != null ? image3.getBytes() : null)
                .created_at(LocalDateTime.now())
                .updated_at(LocalDateTime.now())
                .build();

        review = reviewRepository.save(review);

        return ReviewDTO.builder()
                .id(review.getId())
                .user_id(review.getUser().getId())
                .store_id(review.getStore().getId().toString())
                .content(review.getContent())
                .grade(review.getGrade())
                .image1(review.getImage1())
                .image2(review.getImage2())
                .image3(review.getImage3())
                .created_at(review.getCreated_at())
                .updated_at(review.getUpdated_at())
                .build();
    }


    // 리뷰 조회
    public Optional<ReviewDTO> getReviewById(Long id) {
        return reviewRepository.findById(id).map(review -> ReviewDTO.builder()
                .id(review.getId())
                .user_id(review.getUser().getId())
                .store_id(review.getStore().getId())
                .content(review.getContent())
                .grade(review.getGrade())
                .image1(review.getImage1())
                .image2(review.getImage2())
                .image3(review.getImage3())
                .created_at(review.getCreated_at())
                .updated_at(review.getUpdated_at())
                .build());
    }

    // 리뷰 수정
    public ReviewDTO updateReview(Long id, ReviewDTO reviewDTO, MultipartFile image1, MultipartFile image2, MultipartFile image3) throws IOException {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid review ID"));

        review.setContent(reviewDTO.getContent());
        review.setGrade(reviewDTO.getGrade());

        if (image1 != null) {
            review.setImage1(image1.getBytes());
        }
        if (image2 != null) {
            review.setImage2(image2.getBytes());
        }
        if (image3 != null) {
            review.setImage3(image3.getBytes());
        }

        review.setUpdated_at(LocalDateTime.now());

        review = reviewRepository.save(review);

        return ReviewDTO.builder()
                .id(review.getId())
                .user_id(review.getUser().getId())
                .store_id(review.getStore().getId())
                .content(review.getContent())
                .grade(review.getGrade())
                .image1(review.getImage1())
                .image2(review.getImage2())
                .image3(review.getImage3())
                .created_at(review.getCreated_at())
                .updated_at(review.getUpdated_at())
                .build();
    }

    // 리뷰 삭제
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }







}
