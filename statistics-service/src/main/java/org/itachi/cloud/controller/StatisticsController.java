package org.itachi.cloud.controller;

import org.itachi.cloud.model.Account;
import org.itachi.cloud.model.DataPoint;
import org.itachi.cloud.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

/**
 * Created by itachi on 2017/9/12.
 * User: itachi
 * Date: 2017/9/12
 * Time: 15:03
 */
@RestController
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/current")
    public List<DataPoint> getCurrentAccountStatistics(Principal principal) {
        return statisticsService.findByAccountName(principal.getName());
    }

    @PreAuthorize("#oauth2.hasScope('server') or #accountName.equals('demo')")
    @GetMapping("/{accountName}")
    public List<DataPoint> getStatisticsByAccountName(@PathVariable String accountName) {
        return statisticsService.findByAccountName(accountName);
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @PutMapping("/{accountName}")
    public void saveAccountStatistics(@PathVariable String accountName, @Valid @RequestBody Account account) {
        statisticsService.save(accountName, account);
    }
}
