package com.example.demo.service;

import com.example.demo.models.Ad;
import com.example.demo.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {

    private final AdRepository adRepository;

    @Autowired
    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public Ad findById(Long id) {
        return adRepository.getOne(id);
    }

    public List<Ad> findAll() {
        return adRepository.findAll();
    }

    public Ad saveAd(Ad ad) {
        return adRepository.save(ad);
    }

    public void deleteById(Long id) {
        adRepository.deleteById(id);
    }
}
