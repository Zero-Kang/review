package org.zerock.review.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.review.dto.PageRequestDTO;
import org.zerock.review.dto.PageResultDTO;
import org.zerock.review.dto.ReviewDTO;
import org.zerock.review.entity.Review;
import org.zerock.review.service.ReviewService;

@Controller
@RequestMapping("/review/")
@RequiredArgsConstructor
@Log4j2
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/register")
    public void register(){

        log.info("register get..");

    }

    @PostMapping("/register")
    public String registerPost(ReviewDTO reviewDTO, RedirectAttributes redirectAttributes){

        log.info("register post reviewDTO: " + reviewDTO);

        Long rnum = reviewService.register(reviewDTO);

        redirectAttributes.addFlashAttribute("msg", rnum);

        return "redirect:/review/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){

        log.info("pageRequestDTO: " + pageRequestDTO);

        PageResultDTO<ReviewDTO, Review> result = reviewService.getList(pageRequestDTO);

        model.addAttribute("result", result);

    }

    @GetMapping("/read")
    public void read(Long rnum,
                     @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO,
                     Model model){

        log.info("read rnum:  " + rnum);

        ReviewDTO reviewDTO = reviewService.get(rnum);

        model.addAttribute("dto",reviewDTO );

    }

}











