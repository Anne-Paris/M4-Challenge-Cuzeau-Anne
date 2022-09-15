package com.example.utilityapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CalculatorController {

    public CalculatorController() {
    }

    @RequestMapping(value = "/calculator/divide", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public double divide(@RequestParam @Valid int value1, @RequestParam @Valid int value2) {

        //If divider is 0, throw an Exception
        if (value2 == 0)
        {
           throw new IllegalArgumentException("Cannot divide by 0");
        }

        return value1 / value2;
    }

    @RequestMapping(value = "/calculator/square/{value}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public int square(@PathVariable @Valid int value) {

        //If the value is larger than the square root (both +/-) of the largest int, then throw an exception
        if (value >= 46340 || value <= -46340) {
            throw new IllegalArgumentException("Value used is too large or smaller than -46340");
        }
        return value * value;
    }
}
