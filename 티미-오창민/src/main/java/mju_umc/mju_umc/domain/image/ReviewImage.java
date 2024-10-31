package mju_umc.mju_umc.domain.image;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mju_umc.mju_umc.domain.Review;
import mju_umc.mju_umc.domain.base.BaseEntity;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReviewImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String imageURL;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

}
