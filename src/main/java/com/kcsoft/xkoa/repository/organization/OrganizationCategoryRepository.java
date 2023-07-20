/*
 * Copyright (c) XUST-KCSOFT 2023 All rights reserved.
 */

package com.kcsoft.xkoa.repository.organization;

import com.kcsoft.xkoa.pojo.organization.OrganizationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationCategoryRepository extends JpaRepository<OrganizationCategory, Long> {
    List<OrganizationCategory> findAll();
}
