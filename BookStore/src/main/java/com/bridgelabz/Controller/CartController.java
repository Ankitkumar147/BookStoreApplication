package com.bridgelabz.Controller;

import com.bridgelabz.DTO.CartDto;
import com.bridgelabz.DTO.ResponseDto;
import com.bridgelabz.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping(value={"","/"}, method = RequestMethod.GET)
    public String cartHomePage(){
        return "Cart is Empty.";
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addToCart(@RequestBody CartDto cartDto){
        ResponseDto responseDto = new ResponseDto("Items Added to the Cart.", cartService.addToCart(cartDto));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAll(@RequestParam long userId){
        ResponseDto responseDto = new ResponseDto("Items Present in the Crat Are :-->",cartService.getCartItems(userId));
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @PutMapping ("/update/{cartId}/{quantity}/{totalPrice}")
    public ResponseEntity<ResponseDto> updateQuantity(@PathVariable long cartId, @RequestBody CartDto cartDto){
        System.out.println(cartDto);
        ResponseDto responseDto = new ResponseDto("Updating all the Cart items", cartService.updateQuantity(cartId, cartDto.quantity, cartDto.totalPrice));
        return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);
    }
    @PutMapping("/update/{cartId}")
    public ResponseEntity<ResponseDto>update(@PathVariable long cartId,@RequestBody CartDto cartDto){
        ResponseDto responseDto = new ResponseDto("cart updating/....", cartService.update(cartDto,cartId));
        return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/remove/{cartId}")
    public ResponseEntity<ResponseDto>removeFromCart(@PathVariable long cartId){
        ResponseDto responseDto = new ResponseDto("Removing Items from the cart.",cartService.removeById(cartId));
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @DeleteMapping("/empty")
    public ResponseEntity<ResponseDto>emptyCart(){
        ResponseDto responseDto = new ResponseDto("Deleting all the items from the Cart",cartService.emptyCart());
        return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);
    }
}