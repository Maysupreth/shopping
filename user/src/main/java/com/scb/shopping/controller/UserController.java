package com.scb.shopping.controller;

import com.scb.shopping.model.User;
import com.scb.shopping.model.UserRequest;
import com.scb.shopping.repositories.UserRepository;
import com.scb.shopping.service.UserService;
import com.sipios.springsearch.anotation.SearchSpec;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    private final UserRepository userRepository;


    @PostMapping(path = "/signUp")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        User user1 = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @Valid @RequestBody User user){
        user.setAddress(user.getAddress());
        User user1 = userService.updateUserById(userId, user);
        return user1 != null ? ResponseEntity.ok(user1) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public Page<User> getProducts(@PageableDefault(size = 5) Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);

        return userPage;
    }

    @GetMapping(path = "/search")
    public Page<User> searchUsers(@PageableDefault(size = 5) Pageable pageable, @SearchSpec Specification<User> specs) {

        Page<User> userPage = userRepository.findAll(Specification.where(specs),pageable);

        return userPage;
    }
    @PostMapping(path = "/search/{page}/{size}")
    public Page<User> searchUsers(@PathVariable int page,@PathVariable int size, @Valid @RequestBody UserRequest user) {

        Pageable pageable1 = PageRequest.of(page, size);
        return null;
    }

    }


//        List<User> users = userService.searchUser(user);
//        if (user != null) {
//            return ResponseEntity.ok(users);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }




//    @GetMapping
//    public Page<ProductDto> getProducts(@PageableDefault(size = 5) Pageable pageable) {
//        Page<Product> productPage = productRepository.findAll(pageable);
//
//        List<ProductDto> productDtos =
//                productPage.map(product -> {
//                    ProductDto productDto = new ProductDto().setPort(environment.getProperty("local.server.port"));
//                    BeanUtils.copyProperties(product, productDto);
//                    return productDto;
//                }).toList();
//
//        return new PageImpl<ProductDto>(productDtos, productPage.getPageable(), productPage.getTotalElements());
//    }

//
//}
