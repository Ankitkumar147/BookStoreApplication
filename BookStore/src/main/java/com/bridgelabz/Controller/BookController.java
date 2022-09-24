package com.bridgelabz.Controller;

import com.bridgelabz.DTO.BookDto;
import com.bridgelabz.DTO.ResponseDto;
import com.bridgelabz.Model.BookEntity;
import com.bridgelabz.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BookStore")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/list")
    public ResponseEntity<ResponseDto> getAllBookList(){
        ResponseDto responseDto = new ResponseDto("List of Books", bookService.getAllList());
        return  new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
    @RequestMapping("/{bookId}")
    public ResponseEntity<ResponseDto>getById(@PathVariable int bookId){
        ResponseDto responseDto = new ResponseDto("Book Id is Found", bookService.getById(bookId));
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @PostMapping("/addBook")
    public ResponseEntity<ResponseDto>addBook(@RequestBody BookDto bookDto){
        BookEntity bookEntity = new BookEntity(bookDto);
        ResponseDto responseDto = new ResponseDto("Book Added Successfully.", bookService.addBook(bookEntity));
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @PutMapping("/search/{name}")
    public ResponseEntity<ResponseDto>bookSearch(@PathVariable String name){
    ResponseDto responseDto = new ResponseDto("Book:-", bookService.bookSearch(name));
    return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseDto>deleteById(@PathVariable int bookId){
        ResponseDto responseDto = new ResponseDto("Book deleted Successfully",bookService.deleteById(bookId));
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<ResponseDto>deleteAll(){
        ResponseDto responseDto= new ResponseDto("All Books Deleted Successfully",bookService.deleteAll(new BookEntity() ));
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }
}
