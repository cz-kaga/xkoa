/*
 * Copyright (c) XUST-KCSOFT 2023 All rights reserved.
 */

package com.kcsoft.xkoa.controller;

import com.kcsoft.xkoa.controller.dao.OrganizationCategoryAddDao;
import com.kcsoft.xkoa.controller.dao.RegisterDao;
import com.kcsoft.xkoa.pojo.User;
import com.kcsoft.xkoa.pojo.organization.OrganizationCategory;
import com.kcsoft.xkoa.service.AdminOrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.FailedLoginException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/organization")
public class AdminOrganizationController {
    final AdminOrganizationService adminOrganizationService;
    @GetMapping("/category")
    public ResponseEntity<List<OrganizationCategory>> getCategory(){
        List<OrganizationCategory> organizationCategories = adminOrganizationService.getAllOrganizations();
        return new ResponseEntity<>(organizationCategories, HttpStatus.OK);
    }
    @PostMapping("/category/add")
    public ResponseEntity<OrganizationCategory> addCategory(@RequestBody OrganizationCategoryAddDao body){
        OrganizationCategory organizationCategory = adminOrganizationService.addOrganization(body.getName(), body.getDescription());
        return new ResponseEntity<>(organizationCategory, HttpStatus.OK);
    }
}
