package org.zerock.review.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Long rnum;

    private String title;

    private String content;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private ArrayList<PhotoDTO> photos;


}
