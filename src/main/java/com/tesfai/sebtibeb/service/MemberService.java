package com.tesfai.sebtibeb.service;

import java.util.List;

import com.tesfai.sebtibeb.entity.Member;
import com.tesfai.sebtibeb.exception.MemberNotFoundException;

public interface MemberService {
	
	public Member saveMember(Member member);

	public List<Member> displayMembers();

	public Member editMember(Integer id) throws MemberNotFoundException;

	public void deleteMember(Integer id); 

}
