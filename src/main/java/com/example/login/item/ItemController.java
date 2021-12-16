package com.example.login.item;

import com.example.login.appuser.AppUser;
import com.example.login.appuser.AppUserRepository;
import com.example.login.dto.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private ItemRepository itemRepository;




    @PostMapping(path = "placeOrder")
    public Item placeOrder(@RequestBody OrderRequest orderRequest, Authentication auth){

        Item item = orderRequest.getItem();
        item.setAppUser((AppUser) auth.getPrincipal());
        return itemRepository.save(item);
    }

    @GetMapping(path = "findAllOrder")
    public List<AppUser> findallOrders() {
        return appUserRepository.findAll();
    }
}
