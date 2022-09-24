package com.bridgelabz.Service;

import com.bridgelabz.DTO.CartDto;
import com.bridgelabz.Exception.CustomException;
import com.bridgelabz.Model.BookEntity;
import com.bridgelabz.Model.Cart;
import com.bridgelabz.Model.User;
import com.bridgelabz.Repository.CartRepository;
import com.bridgelabz.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    public Object addToCart(CartDto cartDto){
        Optional<User> userData = userRepository.findById(cartDto.getUserId());
        Optional<BookEntity> bookData = Optional.ofNullable(bookService.getById(cartDto.getBookId()));
        if(userData.isPresent() && bookData.isPresent()){
            if(bookData.get().getQuantity() >= cartDto.getQuantity() && cartDto.getQuantity() > 0)
            {
                Cart cart = cartRepository.findCartByUserIdAndBookId(cartDto.getQuantity(),userData.get().getUserId());
                if(cart != null){
                    Cart cartDetails = update(cartDto,cart.getCartId());
                    return cartDetails;
                } else {
                    double totalPrice = cartDto.getQuantity()*bookData.get().getPrice();
                    Cart cartDetails = new Cart(bookData.get(),userData.get(), cartDto.getQuantity(), totalPrice);
                    return cartRepository.save(cartDetails);
                }
            }
            throw (new CustomException("Book Out Of Stock"));
        }
        throw (new CustomException("Record not Found"));
    }

    public Cart update(CartDto cartDto, long cartId) {
        User userData = userService.getByUserId(cartDto.getUserId());
        if (cartRepository.findById(cartId).isPresent() && userData != null){
            Cart cart = cartRepository.findById(cartId).get();
            cart.setQuantity(cartDto.quantity);
            cart.setTotalPrice(cart.getQuantity()*cart.getBookEntity().getPrice());
            return cartRepository.save(cart);
        } else throw new CustomException("No Book Found with the given id or you are not admin User...");
    }
    public Cart updateQuantity(long cartId, Integer quantity, double totalPrice) {

        if (cartRepository.findById(cartId).isPresent()){
            Cart cart = cartRepository.findById(cartId).get();
            cart.setQuantity(quantity);
            cart.setTotalPrice(cart.getQuantity() * cart.getBookEntity().getPrice());
            return cartRepository.save(cart);
        } else throw new CustomException("No Book Found with the given id or you are not admin User...");
    }
    public List<Cart> getCartItems(long userId) {
        return cartRepository.findCartByUserId(userId);
    }
    public  Object removeById(long userId){
        Optional<Cart> cart = cartRepository.findById(userId);
        if (cart.isPresent()){
            cartRepository.delete(cart.get());
            return "Record is deleted with user Id: "+userId;
        } throw(new CustomException("Record Not Found"));
    }
    public String emptyCart(){
        cartRepository.deleteAll();
        return "All Cart Items Deleted.";
    }
}
