package com.fastcampus.management.controller;

import java.util.List;

import com.fastcampus.management.repository.RentRepo;
import com.fastcampus.management.service.RentService;

import model.Rent;

public class RentController {
    public static void main(String[] args) {
    	RentRepo rentRepo = new RentRepo();
        RentService rentService = new RentService(rentRepo);

        List<Rent> codes = rentService.getAllRent();
//        for (String rentList : codes) {
//            System.out.println("Name: " + book_code);
//        }
    }
}
