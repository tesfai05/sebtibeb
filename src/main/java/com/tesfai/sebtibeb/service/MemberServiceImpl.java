package com.tesfai.sebtibeb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tesfai.sebtibeb.entity.Member;
import com.tesfai.sebtibeb.exception.MemberNotFoundException;
import com.tesfai.sebtibeb.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public Member saveMember(Member member) {

		return memberRepository.save(member);
		
	}

	@Override
	public List<Member> displayMembers() {
		return memberRepository.findAll();
	}

	@Override
	public Member editMember(Integer id) throws MemberNotFoundException {
		return memberRepository.findById(id)
				.orElseThrow(()-> new MemberNotFoundException("No member with id - "+id+" is found."));
	}

	@Override
	public void deleteMember(Integer id) {
		memberRepository.deleteById(id); 
		
	}

}
