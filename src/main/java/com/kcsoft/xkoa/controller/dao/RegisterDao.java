/*
 * Copyright (c) XUST-KCSOFT 2023 All rights reserved.
 */

package com.kcsoft.xkoa.controller.dao;

import lombok.Data;

@Data
public class RegisterDao {
    String username;
    String password;
    String phone;
    String email;
}
