package org.zerock.review.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.review.entity.Photo;
import org.zerock.review.entity.Review;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewAndPhotoTests {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Test
    public void insertEach(){
        Review review = Review.builder().title("Test").content("Content").build();

        //Review객체를 먼저 저장 Review의 rnum번호를 얻기 위해
        reviewRepository.save(review);


        IntStream.rangeClosed(1,3).forEach(i -> {
            Photo photo = Photo.builder().fileName("test1.jpg").review(review).build();

            photoRepository.save(photo);
        });
    }

    @Test
    public void insertWithParent() {
        Review review = Review.builder().title("Test").content("Content").build();

        IntStream.rangeClosed(1, 3).forEach(i -> {
            Photo photo = Photo.builder().fileName("test1.jpg").review(review).build();

            review.addPhoto(photo);
        });

        reviewRepository.save(review);
    }

    @Transactional
    @Test
    public void testLazyLoad() {
        
        //존재하는 번호로 테스트할 것 
        Optional<Review> result = reviewRepository.findById(2L);

        Review review = result.get();
        
        System.out.println(review);

        System.out.println("----------------------");

        //Collection 조회
        System.out.println(review.getPhotos());
        
    }

}
