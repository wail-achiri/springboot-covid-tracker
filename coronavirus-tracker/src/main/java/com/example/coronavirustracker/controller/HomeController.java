package com.example.coronavirustracker.controller;

import com.example.coronavirustracker.models.LocationStats;
import com.example.coronavirustracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allstats = coronaVirusDataService.getAllStats();

        int totalCasosReportados = allstats.stream().mapToInt(estado -> estado.getTotalUltimosCasos()).sum();
        int totalNuevosCasos = allstats.stream().mapToInt(estado -> estado.getDiferenciaDiaAnterior()).sum();

        model.addAttribute("locationStats",allstats);
        model.addAttribute("totalCasosReportados",totalCasosReportados);
        model.addAttribute("totalNuevosCasos",totalNuevosCasos);
        return "home";
    }
}
