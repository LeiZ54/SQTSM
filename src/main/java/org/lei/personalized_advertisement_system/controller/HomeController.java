package org.lei.personalized_advertisement_system.controller;

import org.lei.personalized_advertisement_system.DTO.AdDTO;
import org.lei.personalized_advertisement_system.DTO.HomePageDTO;
import org.lei.personalized_advertisement_system.DTO.ProductDTO;
import org.lei.personalized_advertisement_system.service.AdService;
import org.lei.personalized_advertisement_system.service.ProductService;
import org.lei.personalized_advertisement_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class HomeController {

    @Autowired
    private AdService adService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getHomePage(@RequestHeader(value = "Authorization", required = false) String token) {
        List<AdDTO> ads;
        List<ProductDTO> products;

        if (token != null && !token.isBlank()) {
            String username = userService.getCurrentUser().getUsername();
            if (username != null) {
                ads = adService.getRecommendedAds(username);
                products = productService.getRecommendedProducts(username);
                return ResponseEntity.ok(new HomePageDTO(ads, products, "Welcome back, " + username + "!"));
            }
        }

        ads = adService.getPopularAds();
        products = productService.getPopularProducts();
        return ResponseEntity.ok(new HomePageDTO(ads, products, "Explore popular ads and products!"));
    }

    @GetMapping("/search")
    public ResponseEntity<List<AdDTO>> searchAds(@RequestParam String query) {
        List<AdDTO> results = adService.searchAds(query);
        return ResponseEntity.ok(results);
    }

    @PostMapping("/click/{adId}")
    public ResponseEntity<?> recordAdClick(@PathVariable Long adId) {
        adService.recordClick(adId);
        return ResponseEntity.ok("Ad click recorded.");
    }
}

