package com.ndogga.cicoffe.security;

import com.ndogga.cicoffe.configuration.OpenApiConfiguration;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author Nidhal Dogga
 * @since 11/14/2020 1:03 AM
 * Prize & Fun™ All rights reserved.
 */


@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("isAuthenticated()")
@SecurityRequirement(name = OpenApiConfiguration.securitySchemeName)
public @interface Authenticated {}
