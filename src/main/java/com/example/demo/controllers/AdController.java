package com.example.demo.controllers;

import com.example.demo.models.Ad;
import com.example.demo.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdController {

    private final AdService adService;

    @Autowired
    AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping("/ads")
    public String findAll(Model model) {
        List<Ad> ads = adService.findAll();
        model.addAttribute("ads", ads);
        return "ads-list";
    }

    @GetMapping("/ad-add")
    public String createAdForm(Ad ad) {
        return "ad-add";
    }

    @PostMapping("/ad-add")
    public String addAd(Ad ad) {
        adService.saveAd(ad);
        return "redirect:/ads";
    }

    @GetMapping("ad-delete/{id}")
    public String deleteAd(@PathVariable("id") Long id) {
        adService.deleteById(id);
        return "redirect:/ads";
    }

    @GetMapping("/ad-update/{id}")
    public String updateAdForm(@PathVariable("id") Long id, Model model) {
        Ad ad = adService.findById(id);
        model.addAttribute("ad", ad);
        return "ad-update";
    }

    @PostMapping("/ad-update")
    public String updateAd(Ad ad) {
        adService.saveAd(ad);
        return "redirect:/ads";
    }
}
