package com.fastcampus.management.controller;

import java.util.List;

import com.fastcampus.management.repository.RentRepo;
import com.fastcampus.management.service.RentService;

public class RentController {
    public static void main(String[] args) {
    	RentRepo rentRepo = new RentRepo();
        RentService rentService = new RentService(rentRepo);

        List<String> codes = rentService.getAllNamesFromRepository();
        for (String book_code : codes) {
            System.out.println("Name: " + book_code);
        }
    }
}
