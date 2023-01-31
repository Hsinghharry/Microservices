package com.lcwd.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Rating {

    private long ratingId;
    private long userId;
    private long hotelId;
    private long rating;
    private String feedback;

    private Hotel hotel;

}
