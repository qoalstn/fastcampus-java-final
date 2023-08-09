package com.fastcampus.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.management.repository.MemberRepo;

@Service
public class MemberService {
    private final MemberRepo memberRepo;

    @Autowired()
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public int getNewCustNo() {
        int newMember = memberRepo.getNewCustNo();
        return newMember;
    }
    
    public void saveMember(String cust_name, String phone, String cust_email, String grade) {
    	 memberRepo.saveMember( cust_name,  phone,  cust_email,  grade);
    }
}
