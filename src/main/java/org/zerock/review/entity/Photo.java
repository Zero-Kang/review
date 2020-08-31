package org.zerock.review.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "review")
public class Photo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pnum;

    private String fileName;

    private String uploadPath;

    private String uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;


}
