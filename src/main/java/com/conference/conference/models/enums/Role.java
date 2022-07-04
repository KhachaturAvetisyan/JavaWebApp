package com.conference.conference.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    LISTENER, SPEAKER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
