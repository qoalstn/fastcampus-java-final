package com.fastcampus.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fastcampus.management.service.MemberService;
import com.fastcampus.management.service.RentService;

import model.Rent;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private final MemberService memberService;
	private final RentService rentService;
	
	@Autowired
	public HomeController (MemberService memberService, RentService rentService) {
		this.memberService = memberService;
		this.rentService = rentService;
	}
	
	// 등록화면
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String registInit(Model model) {

		int newMember = memberService.getNewCustNo();
		System.out.println("new ::: "+ newMember);
		model.addAttribute("no", newMember);
		return "regist";
	}
	
	// 고객등록 로직 
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public String regist(String name, String phone, String email, String grade, Model model) {
		System.out.println("input :: " + name);
		memberService.saveMember(name,phone,email,email);
		System.out.println("등록완료");
		return "regist";
	}
    
	// 고객 조회/수정
	@RequestMapping(value="/cust", method=RequestMethod.GET)
	public String getCust() {
		System.out.println("cust");

		return "cust";
	}
	
	// 고객 대여 리스트
	@RequestMapping(value="/rent", method=RequestMethod.GET)
	public String rentList(Model model) {
		System.out.println("rent");
		List<Rent> rentList = rentService.getAllRent();
		System.out.println("rent list : "+ rentList);
		
		model.addAttribute("rentList",rentList);
		
		return "rent";
	}
	
	// 대여 금액 조회 
	@RequestMapping(value="/price", method=RequestMethod.GET)
	public String regist(String custNo) {
		System.out.println("price");
		return "price";
	}
	
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	

	
}
