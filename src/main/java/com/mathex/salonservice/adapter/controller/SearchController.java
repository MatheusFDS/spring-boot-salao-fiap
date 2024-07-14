package com.mathex.salonservice.adapter.controller;

import com.mathex.salonservice.domain.model.Establishment;
import com.mathex.salonservice.domain.model.Professional;
import com.mathex.salonservice.usecase.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/api/search/establishments")
    public List<Establishment> searchEstablishments(@RequestParam String keyword) {
        return searchService.searchEstablishments(keyword);
    }

    @GetMapping("/api/search/professionals")
    public List<Professional> searchProfessionals(@RequestParam String keyword) {
        return searchService.searchProfessionals(keyword);
    }
}
