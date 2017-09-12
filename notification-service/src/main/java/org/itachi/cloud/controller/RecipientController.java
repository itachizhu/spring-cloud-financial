package org.itachi.cloud.controller;

import org.itachi.cloud.model.Recipient;
import org.itachi.cloud.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 17:05
 */
@RestController
@RequestMapping("/recipients")
public class RecipientController {
    @Autowired
    private RecipientService recipientService;

    @GetMapping("/current")
    public Recipient getCurrentNotificationsSettings(Principal principal) {
        return recipientService.findByAccountName(principal.getName());
    }

    @PutMapping("/current")
    public Recipient saveCurrentNotificationsSettings(Principal principal, @Valid @RequestBody Recipient recipient) {
        return recipientService.save(principal.getName(), recipient);
    }
}
