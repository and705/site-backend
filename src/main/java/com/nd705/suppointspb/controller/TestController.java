package com.nd705.suppointspb.controller;

import com.nd705.suppointspb.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    @GetMapping("/")
    public String greeting() {
        return "Hello, World";
    }

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrincipal principal) {

        return "If you see this, you logged in as user: " + principal.getEmail()
                + " User ID: " + principal.getUserId();
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(@AuthenticationPrincipal UserPrincipal principal) {
        return "If you see this? than you are Admin. User ID: " + principal.getUserId();
    }

    @GetMapping("/client")
    @PreAuthorize("hasRole('CLIENT')")
    public String client(@AuthenticationPrincipal UserPrincipal principal) {
        return "If you see this? than you are Client. User ID: " + principal.getUserId();
    }


}
