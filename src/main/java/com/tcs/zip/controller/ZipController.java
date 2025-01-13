package com.tcs.zip.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.zip.service.ZipService;

@RestController
public class ZipController {

	@Autowired
    private ZipService zipService;

    @GetMapping("/getPlace/{postalCode}")
    public String getPlace(@PathVariable String postalCode) {
        return zipService.getPlaceNameFromPostalCode(postalCode);
    }
}

