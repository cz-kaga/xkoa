/*
 * Copyright (c) XUST-KCSOFT 2023 All rights reserved.
 */

package com.kcsoft.xkoa.repository.organization;

import com.kcsoft.xkoa.pojo.organization.OrganizationInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrganizationInfoRepository extends MongoRepository<OrganizationInfo, Long> {
}
