package com.ksa.jodayn.controllers;

import com.ksa.jodayn.services.MagicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("magic")
public class MagicController {

    private final MagicService magicService;

    public MagicController(MagicService magicService) {
        this.magicService = magicService;
    }

    @GetMapping("number/{startNumber}")
    public int number(@PathVariable int startNumber) {
        return magicService.number(startNumber);
    }

}
