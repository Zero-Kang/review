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
    private Long photoNum;

    private String fileName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;
}
