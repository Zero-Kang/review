package org.zerock.review.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "photos")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rnum;

    private String title;

    private String content;

    @OneToMany(mappedBy = "review" , cascade = CascadeType.ALL)
    private Collection<Photo> photos;

    public void addPhoto(Photo photo){
        if(photos == null){
            photos = new HashSet<>();
        }
        photos.add(photo);
    }
}
