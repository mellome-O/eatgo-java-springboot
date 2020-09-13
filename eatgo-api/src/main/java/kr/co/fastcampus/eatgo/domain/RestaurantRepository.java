package kr.co.fastcampus.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RestaurantRepository {

    List<Restaurant> findAll();
    Restaurant findByID(Long id);
}
