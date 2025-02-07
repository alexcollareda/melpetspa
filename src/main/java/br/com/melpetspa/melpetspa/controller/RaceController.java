package br.com.melpetspa.melpetspa.controller;

import br.com.melpetspa.melpetspa.dto.RaceDTO;
import br.com.melpetspa.melpetspa.entity.enums.SpeciesEnum;
import br.com.melpetspa.melpetspa.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/races")
public class RaceController {

    @Autowired
    private RaceService raceService;

    @GetMapping("/list/{species}")
    public List<RaceDTO> getRaceBySpecies(@PathVariable("species") SpeciesEnum speciesEnum) {
        return raceService.getRaceBySpecies(speciesEnum);
    }
}