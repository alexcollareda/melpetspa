package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.BrandVaccineDTO;
import br.com.melpetspa.melpetspa.dto.RaceDTO;
import br.com.melpetspa.melpetspa.entity.enums.SpeciesEnum;
import br.com.melpetspa.melpetspa.service.BrandVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/brandvaccine")
public class BrandVaccineController {

    @Autowired
    private BrandVaccineService brandVaccineService;

    @GetMapping("/list")
    public List<BrandVaccineDTO> getBrandVaccines() {
        return brandVaccineService.getBrandVaccinesAll();
    }
}
