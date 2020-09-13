package kr.co.fastcampus.eatgo.Interfaces;

import kr.co.fastcampus.eatgo.application.RestaurantService;
import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.MenuItemRepository;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    //어노테이션 하지 않고 직접 생성
    //private RestaurantRepository repository = new RestaurantRepository();

    /*
    //repository -> application Layer 로 service 사용
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;
    */

    //필드?
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        //Repository로 코드 이동
        //List<Restaurant> restaurants = new ArrayList<>();

        //restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        //restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));

        //service 사용으로 변경
        //List<Restaurant> restaurants = restaurantRepository.findAll();
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        //List<Restaurant> restaurants = new ArrayList<>();

        //restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        //restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));

        //Repository 한 줄로 위에 세 줄 대체 (findAll 사용할 경우)
        //List<Restaurant> restaurants = repository.findAll();

        /*
        Restaurant restaurant = restaurants.stream()
                .filter(r -> r.getID().equals(id))
                .findFirst()
                .orElse(null); //예외처리 : 없으면 null
        */

        /*
        Restaurant restaurant = restaurantRepository.findByID(id);

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantID(id);
        restaurant.setMenuItems(menuItems);
        //restaurant.addMenuItem(new MenuItem("Kimchi"));
        */

        //application Layer 추가 (레스토랑 기본정보 + 메뉴정보)
        Restaurant restaurant = restaurantService.getRestaurant(id);


        return restaurant;
    }
}
