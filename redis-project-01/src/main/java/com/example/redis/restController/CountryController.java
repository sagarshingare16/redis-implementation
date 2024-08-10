package com.example.redis.restController;

import com.example.redis.model.Country;
import com.example.redis.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/add")
    public ResponseEntity<String> addCountry(@RequestBody Country country) {
        return new ResponseEntity<>(countryService.addCountry(country), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<Country> getCountry(@RequestParam String code) {
        return new ResponseEntity<>(countryService.getCountry(code), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Collection<Object>> getCountries() {
        return new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);
    }
}
