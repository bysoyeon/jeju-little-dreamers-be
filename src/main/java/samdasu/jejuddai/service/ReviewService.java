package samdasu.jejuddai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samdasu.jejuddai.entity.menu;
import samdasu.jejuddai.entity.review;
import samdasu.jejuddai.repository.MenuRepository;
import samdasu.jejuddai.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MenuRepository menuRepository;

    public List<menu> getMenuByStoreId(Long storeId){
        return menuRepository.findByStoreId(storeId);
    }
    
    public List<review> getReviewByStoreId(Long storeId){
        return reviewRepository.findByStoreId(storeId);
    }

}
