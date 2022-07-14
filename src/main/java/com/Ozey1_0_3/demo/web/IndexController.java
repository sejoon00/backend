package com.Ozey1_0_3.demo.web;

import com.Ozey1_0_3.demo.domain.Book;
import com.Ozey1_0_3.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class IndexController {


    private final BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book){
        //httpStatus를 같이 보낼수 있음 OK는 200임
        return new ResponseEntity<>(bookService.저장하기(book), HttpStatus.OK);
    }
    @GetMapping("/book")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(bookService.모두가져오기(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.한건가져오기(id), HttpStatus.OK);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Book book){
        return new ResponseEntity<>(bookService.수정하기(id,book), HttpStatus.OK);
    }


    //generic ? 정리하기
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id, @RequestBody Book book){
        return new ResponseEntity<>(bookService.삭제하기(id), HttpStatus.OK);
    }
}
