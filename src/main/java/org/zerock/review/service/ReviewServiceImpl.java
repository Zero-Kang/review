package org.zerock.review.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.review.dto.PageRequestDTO;
import org.zerock.review.dto.PageResultDTO;
import org.zerock.review.dto.ReviewDTO;
import org.zerock.review.entity.Review;
import org.zerock.review.repository.ReviewRepository;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Long register(ReviewDTO reviewDTO) {

        Review review = dtoToEntity(reviewDTO);

        reviewRepository.save(review);

        return review.getRnum();
    }

    @Override
    public PageResultDTO<ReviewDTO, Review> getList(PageRequestDTO pageRequestDTO) {

        log.info(pageRequestDTO);

        Function<Review, ReviewDTO> fn = (en -> entityToDTO(en));

        Pageable pageRequest = pageRequestDTO.getPageable(Sort.by("rnum").descending());

        Page<Review> result = reviewRepository.getList((PageRequest) pageRequest);

        return new PageResultDTO<>(result, fn);

    }

}
