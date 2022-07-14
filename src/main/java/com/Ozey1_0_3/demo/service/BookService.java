package com.Ozey1_0_3.demo.service;


import com.Ozey1_0_3.demo.domain.Book;
import com.Ozey1_0_3.demo.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//기능을 정의할 수 있고, 트랜잭션을 관리할 수 있음.

@RequiredArgsConstructor
@Service
public class BookService {

    //함수 =>송금() -> 레파지토리에 여러개의 함수 실행 ->commit or rollback


    private final BookRepository bookRepository;

    @Transactional// 서비스 함수가 종료될 때 commit할지 rollback할지 트랜잭션 관리하겠다.
    public Book 저장하기(Book book){
        return bookRepository.save(book);
    }


    @Transactional(readOnly = true)
    public Book 한건가져오기(Long id)
    {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id를 확인해주세요"));
    }

    @Transactional(readOnly = true)
    public List<Book> 모두가져오기()
    {
        return bookRepository.findAll();
    }

    @Transactional
    public Book 수정하기(Long id,Book book){
        //더티채팅 update치기
        Book bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id를 확인해주세요"));

        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());

        return bookEntity;
    }//함수 종료 => 트랜잭션 종료 => 영속화 되어있는 데이터를 DB로 갱신

    public String 삭제하기(Long id){
        bookRepository.deleteById(id);
        return "ok";
    }
}