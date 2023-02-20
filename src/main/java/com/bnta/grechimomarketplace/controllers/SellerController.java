package com.bnta.grechimomarketplace.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/seller")
public class SellerController {


    // register
    // would use the @PostMapping function to add a new user

    // createProduct (post mapping) --> to create & add a new product to the seller's inventory

    // /seller/list/{id}
    // listProduct (@patchmapping)
    // Changing product listing from false to true
    //Have a @requestparam which will take in true or false depending on whether it is listed or not

    //deleteProduct (@DeleteMapping)

    // /seller/update/{id}
    // updateProduct (@PatchMapping) --> multiple optional requestparams OR requestBody
    // (BUT requestBody would have to allow both updating just one variable or all variables at once)

    // displayOrders (@GetMapping)
    // get all orders
    // use id to get the id for the specific seller who's orders we want to get



    // extension fulfilOrder



}
