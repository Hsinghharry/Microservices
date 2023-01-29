package com.lcwd.ratingService.RatingService.Reposiratory;

import com.lcwd.ratingService.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingReposiratory extends JpaRepository<Rating ,Long> {

    //custom finder method
    List<Rating> findByUserId(Long userId);
    List<Rating> findByHotelId(Long hotelId);
}
