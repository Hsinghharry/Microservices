package com.Hotel.HotelService.reposiratory;

import com.Hotel.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelReposiratory extends JpaRepository<Hotel, Long> {
}
