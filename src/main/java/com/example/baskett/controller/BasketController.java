package com.example.baskett.controller;

import com.example.baskett.model.Basket;
import com.example.baskett.service.BasketService;
import com.example.baskett.service.ClientService;
import com.example.baskett.service.ProductListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(path="/basket", produces="application/json")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
public class BasketController {
    private final BasketService basketService;
    private final ProductListService productListService;
    private final ClientService clientService;

    @GetMapping("/")
    public List<Basket> get (Model model){
        List<Basket> product = basketService.listBasketALL();
        return product;
    }
    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("list",productListService.listProduct());
        return "list";
    }
    //curl -X POST -H "Content-type: application/json" -d "{\"title\" : \"milk\", \"name\" : \"mmm\",\"price\" : \"192\" , \"count\":\"93\" }" "http://localhost:8080/JSON/create"
    @PostMapping  (value = "/create/{count}",consumes = "application/json", produces = "application/json")
    public List<Basket> createBaskett(@RequestBody Basket basket,@PathVariable("count") String count){
        basket.setClient_id(clientService.getClientByAuntification(count));
        basketService.saveBasket(basket);
        List<Basket> product = basketService.listBasketALL();
        return product;
    }
    @PutMapping(value = "/create/{id}/{count}")
    public void updateBasket(@PathVariable Long id,@PathVariable("count") int count){
        basketService.updateItemCount(id,count);

    }
    @DeleteMapping(path = "/delete/{id}")
    public List<Basket>  deleteBy (@PathVariable Long id){
        basketService.deleteBasket(id);
        List<Basket> product = basketService.listBasketALL();
        return product;
    }
    @DeleteMapping(path = "/delete/all")
    public List<Basket>   deleteAllBasket (){
        basketService.deleteAllBasket();
        List<Basket> product = basketService.listBasketALL();
        return product;
    }

    @PostMapping(path = "/list/go")
    public void goList(){
        productListService.getCheck();
        basketService.deleteAllBasket();
    }

}

/*
@RequestMapping(path="/basket", produces="application/json")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
public class BasketController {
    private final BasketService basketService;
    private final ProductListService productListService;
    private final ClientService clientService;

    @GetMapping("/{count}")
    public List<Basket> get (@PathVariable("count") String count){
        Client client = clientService.getClientByAuntification(count);
        List<Basket> product = basketService.listBasketALL(client);
        return product;
    }
    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("list",productListService.listProduct());
        return "list";
    }
    //curl -X POST -H "Content-type: application/json" -d "{\"title\" : \"milk\", \"name\" : \"mmm\",\"price\" : \"192\" , \"count\":\"93\" }" "http://localhost:8080/JSON/create"
    @PostMapping  (value = "/create/{count}",consumes = "application/json", produces = "application/json")
    public List<Basket> createBaskett(@RequestBody Basket basket,@PathVariable("count") String count){
        basket.setClient_id(clientService.getClientByAuntification(count));
        basketService.saveBasket(basket);
        Client client = clientService.getClientByAuntification(count);
        List<Basket> product = basketService.listBasketALL(client);
        return product;
    }
@PutMapping(value = "/create/{id}/{count}")
    public void updateBasket(@PathVariable Long id,@PathVariable("count") int count){
        //basketService.updateItemCount(id,count);

    }

@DeleteMapping(path = "/delete/{id}")
    public List<Basket>  deleteBy (@PathVariable Long id){
        basketService.deleteBasket(id);
        List<Basket> product = basketService.listBasketALL();
        return product;
    }
    @DeleteMapping(path = "/delete/all")
    public List<Basket>   deleteAllBasket (){
        basketService.deleteAllBasket();
        List<Basket> product = basketService.listBasketALL();
        return product;
    }


    @PostMapping(path = "/list/go")
    public void goList(){
        productListService.getCheck();
        basketService.deleteAllBasket();
    }

}
*/
