package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GirlFriend {
    @Autowired
    @Qualifier("bikini")
    public Outfit outfit;

    public GirlFriend() {
    }

    // Nếu sử dụng @Autowired
    // public GirlFriend(@Qualifier("bikini") Outfit outfit) {
    public GirlFriend(Outfit outfit) {
        this.outfit = outfit;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    // Nếu sử dụng @Autowired
    // public void setOutfit(@Qualifier("bikini") Outfit outfit) {
    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }
}
