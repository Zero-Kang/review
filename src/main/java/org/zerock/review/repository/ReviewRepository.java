package org.zerock.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.review.entity.Review;

public interface ReviewRepository  extends JpaRepository<Review, Long> {


}
