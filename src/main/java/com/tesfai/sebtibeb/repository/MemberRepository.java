package com.tesfai.sebtibeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tesfai.sebtibeb.entity.Member;
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}
