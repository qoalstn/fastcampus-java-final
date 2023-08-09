package com.fastcampus.management.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcampus.management.repository.RentRepo;

import model.Rent;

@Service
public class RentService {

    private final RentRepo rentRepo;

    @Autowired()
    public RentService(RentRepo rentRepo) {
        this.rentRepo = rentRepo;
    }

    public List<Rent> getAllRent() {
        return rentRepo.getAllRent();
    }
}
