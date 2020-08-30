package org.zerock.review.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "photoCollection")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    @OneToMany
    private Collection<Photo> photoCollection;
}
