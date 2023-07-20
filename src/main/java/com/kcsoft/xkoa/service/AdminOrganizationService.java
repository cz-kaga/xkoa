/*
 * Copyright (c) XUST-KCSOFT 2023 All rights reserved.
 */

package com.kcsoft.xkoa.service;

import com.kcsoft.xkoa.pojo.organization.OrganizationCategory;
import com.kcsoft.xkoa.repository.organization.OrganizationCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminOrganizationService {
    final OrganizationCategoryRepository organizationCategoryRepository;
    public List<OrganizationCategory> getAllOrganizations(){
        return organizationCategoryRepository.findAll();
    }
    public OrganizationCategory addOrganization(String name, String description){
        OrganizationCategory category = OrganizationCategory.builder()
                .name(name)
                .description(description)
                .build();
        return organizationCategoryRepository.save(category);
    }
}
