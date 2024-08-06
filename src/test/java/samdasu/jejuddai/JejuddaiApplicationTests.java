package samdasu.jejuddai;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;
import samdasu.jejuddai.dto.ReviewDTO;
import samdasu.jejuddai.entity.Review;
import samdasu.jejuddai.entity.Store;
import samdasu.jejuddai.entity.User;
import samdasu.jejuddai.repository.ReviewRepository;
import samdasu.jejuddai.repository.StoreRepository;
import samdasu.jejuddai.repository.UserRepository;
import samdasu.jejuddai.service.ReviewService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class JejuddaiApplicationTests {
	@Mock
	private StoreRepository storeRepository;

	@Mock
	private UserRepository userRepository;

	@Mock
	private ReviewRepository reviewRepository;

	@InjectMocks
	private ReviewService reviewService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void givenValidReviewDTO_whenInsertReview_thenReviewIsSaved() throws IOException {
		// given
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setUser_id(1L);
		reviewDTO.setStore_id("1");
		reviewDTO.setContent("Great!");
		reviewDTO.setGrade(5);

		User user = new User();
		user.setId(1L);

		Store store = new Store();
		store.setId("1");

		when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		when(storeRepository.findById("1")).thenReturn(Optional.of(store));
		when(reviewRepository.save(any(Review.class))).thenReturn(new Review());

		MultipartFile image1 = mock(MultipartFile.class);
		MultipartFile image2 = mock(MultipartFile.class);
		MultipartFile image3 = mock(MultipartFile.class);

		// when
		ReviewDTO result = reviewService.saveReview(reviewDTO, image1, image2, image3);

		// then
		assertNotNull(result);
		verify(reviewRepository, times(1)).save(any(Review.class));
	}

	@Test
	void givenInvalidUserId_whenInsertReview_thenThrowsException() {
		// given
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setUser_id(1L);
		reviewDTO.setStore_id("1");

		when(userRepository.findById(1L)).thenReturn(Optional.empty());

		MultipartFile image1 = mock(MultipartFile.class);
		MultipartFile image2 = mock(MultipartFile.class);
		MultipartFile image3 = mock(MultipartFile.class);

		// when & then
		assertThrows(IllegalArgumentException.class, () -> reviewService.saveReview(reviewDTO, image1, image2, image3));
	}

	@Test
	void givenInvalidStoreId_whenInsertReview_thenThrowsException() {
		// given
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setUser_id(1L);
		reviewDTO.setStore_id("1");

		User user = new User();
		user.setId(1L);

		when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		when(storeRepository.findById("1")).thenReturn(Optional.empty());

		MultipartFile image1 = mock(MultipartFile.class);
		MultipartFile image2 = mock(MultipartFile.class);
		MultipartFile image3 = mock(MultipartFile.class);

		// when & then
		assertThrows(IllegalArgumentException.class, () -> reviewService.saveReview(reviewDTO, image1, image2, image3));
	}

	@Test
	void whenGetAllReviews_thenReturnReviewList() {
		// given
		Review review = new Review();
		when(reviewRepository.findAll()).thenReturn(List.of(review));

		// when
		List<Review> reviews = reviewService.getAllReviews();

		// then
		assertNotNull(reviews);
		assertEquals(1, reviews.size());
		verify(reviewRepository, times(1)).findAll();
	}

	@Test
	void givenValidReviewId_whenGetReviewById_thenReturnReview() {
		// given
		Review review = new Review();
		when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));

		// when
		Optional<ReviewDTO> result = reviewService.getReviewById(1L);

		// then
		assertTrue(result.isPresent());
		verify(reviewRepository, times(1)).findById(1L);
	}

	@Test
	void givenInvalidReviewId_whenGetReviewById_thenReturnEmpty() {
		// given
		when(reviewRepository.findById(1L)).thenReturn(Optional.empty());

		// when
		Optional<ReviewDTO> result = reviewService.getReviewById(1L);

		// then
		assertFalse(result.isPresent());
		verify(reviewRepository, times(1)).findById(1L);
	}

	@Test
	void givenValidReviewDTO_whenUpdateReview_thenReviewIsUpdated() throws IOException {
		// given
		Review review = new Review();
		when(reviewRepository.findById(1L)).thenReturn(Optional.of(review));

		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setContent("Updated content");
		reviewDTO.setGrade(4);

		MultipartFile image1 = mock(MultipartFile.class);
		MultipartFile image2 = mock(MultipartFile.class);
		MultipartFile image3 = mock(MultipartFile.class);

		// when
		ReviewDTO result = reviewService.updateReview(1L, reviewDTO, image1, image2, image3);

		// then
		assertNotNull(result);
		verify(reviewRepository, times(1)).save(review);
	}

	@Test
	void givenInvalidReviewId_whenUpdateReview_thenThrowsException() {
		// given
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setContent("Updated content");
		reviewDTO.setGrade(4);

		MultipartFile image1 = mock(MultipartFile.class);
		MultipartFile image2 = mock(MultipartFile.class);
		MultipartFile image3 = mock(MultipartFile.class);

		when(reviewRepository.findById(1L)).thenReturn(Optional.empty());

		// when & then
		assertThrows(IllegalArgumentException.class, () -> reviewService.updateReview(1L, reviewDTO, image1, image2, image3));
	}

	@Test
	void givenValidReviewId_whenDeleteReview_thenReviewIsDeleted() {
		// given
		doNothing().when(reviewRepository).deleteById(1L);

		// when
		reviewService.deleteReview(1L);

		// then
		verify(reviewRepository, times(1)).deleteById(1L);
	}

	@Test
	void givenInvalidReviewId_whenDeleteReview_thenThrowsException() {
		// given
		doThrow(new IllegalArgumentException()).when(reviewRepository).deleteById(1L);

		// when & then
		assertThrows(IllegalArgumentException.class, () -> reviewService.deleteReview(1L));
	}

}
