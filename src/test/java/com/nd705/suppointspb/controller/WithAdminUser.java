package com.nd705.suppointspb.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(authorities = "ROLE_ADMIN")
public @interface WithAdminUser {

}
