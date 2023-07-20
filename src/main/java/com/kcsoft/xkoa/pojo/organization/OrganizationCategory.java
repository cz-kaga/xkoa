/*
 * Copyright (c) XUST-KCSOFT 2023 All rights reserved.
 */

package com.kcsoft.xkoa.pojo.organization;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "organization_category")
public class OrganizationCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @CreatedDate
    private Date gmtCreate;
    @LastModifiedDate
    private Date gmtModified;
}
