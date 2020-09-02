package org.zerock.review.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;


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

    @OneToMany(mappedBy = "review" ,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private Set<Photo> photos;

    public void addPhoto(Photo photo){
        if(photos == null){
            photos = new HashSet<>();
        }
        photos.add(photo);
    }

    public void deletePhoto(Photo photo){

        photos = photos.stream()
                .filter( p -> !p.getPnum().equals(photo.getPnum()))
                .collect(Collectors.toSet());

    }
}
