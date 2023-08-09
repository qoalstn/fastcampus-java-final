package com.fastcampus.management.service;
import java.util.List;

import com.fastcampus.management.repository.RentRepo;

public class RentService {

    private final RentRepo rentRepo;

    public RentService(RentRepo rentRepo) {
        this.rentRepo = rentRepo;
    }

    public List<String> getAllNamesFromRepository() {
        return rentRepo.getAllNames();
    }
}
