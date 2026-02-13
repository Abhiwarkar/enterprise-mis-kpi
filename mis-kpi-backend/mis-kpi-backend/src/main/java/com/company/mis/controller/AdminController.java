package com.company.mis.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/ping")
    public String ping() {
        return "Admin API OK";
    }
}
