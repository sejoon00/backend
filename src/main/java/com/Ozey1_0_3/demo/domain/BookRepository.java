package com.Ozey1_0_3.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

//JPARepository 안에 CRUD다 있음
public interface BookRepository extends JpaRepository<Book, Long> {
}
