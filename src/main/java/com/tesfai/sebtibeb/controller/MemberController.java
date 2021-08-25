package com.tesfai.sebtibeb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tesfai.sebtibeb.entity.Member;
import com.tesfai.sebtibeb.exception.MemberNotFoundException;
import com.tesfai.sebtibeb.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping(value = { "/member/newMember" })
	public String addNewMember(Model model) {
		model.addAttribute("member", new Member());
		return "member/newMember";		
	}
	
	@PostMapping(value = { "/member/newMember" })
	public String saveNewMember(Model model, @Valid @ModelAttribute("member") Member member, BindingResult result) {
		model.addAttribute("member", member);
		if (result.hasErrors()) {
			return "member/newMember";
		}
		memberService.saveMember(member);
		return "redirect:/member/list";
	}
	
	@GetMapping(value = { "/member/list" })
	public String displayMembers(Model model) {	
		List<Member> members = memberService.displayMembers();
		model.addAttribute("members", members);
		model.addAttribute("memberCount", members.size());
		return "member/list";
	}
	
	@GetMapping(value = "/editmember/{id}")
	public String editMember(@PathVariable Integer id, Model model){
		Member member=null;
		try {
			member = memberService.editMember(id);
		} catch (MemberNotFoundException e) {
			model.addAttribute("msg", e.getMessage());
			return "redirect:/exception";
		}
		model.addAttribute("member", member);
		return "member/newMember";
		
	}
	
	@GetMapping(value = "/deletemember/{id}")
	public String deleteMember(@PathVariable Integer id, Model model) {
		memberService.deleteMember(id);
		return "redirect:/member/list";
	}
	
}
