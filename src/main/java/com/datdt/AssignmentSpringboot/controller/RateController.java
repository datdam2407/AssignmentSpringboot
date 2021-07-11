// package com.datdt.AssignmentSpringboot.controller;

// import java.util.List;

// import com.datdt.AssignmentSpringboot.entity.Rate;
// import com.datdt.AssignmentSpringboot.service.RateService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;


// @RestController
// @RequestMapping("/rate")
// public class RateController  {
//     @Autowired
//     RateService rateService;

//     public RateController(RateService rateService) {
//         this.rateService = rateService;
//     }

//     @GetMapping("/{productID}")
//     public ResponseEntity getByProduct(@PathVariable(value = "id") Long productID){
//         List<Rate> listRate = rateService.findByProductID(productID);
//         if(listRate.size()>0){
//             return ResponseEntity.ok(listRate);
//         }
//         return ResponseEntity.ok("Don't have any rate for this product");
//     }

//     @PostMapping("/user/rating")
//     @PreAuthorize("hasRole('ROLE_CUSTOMER')")
//     public ResponseEntity<?> rating(@RequestBody Rate rate) {
//         String status = rateService.rating(rate);
//         return ResponseEntity.ok(status);
//     }

// }