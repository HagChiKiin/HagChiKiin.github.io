package com.example.driver_security.security;


import com.example.driver_security.entity.Driver;
import com.example.driver_security.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private Driver driver;

    public CustomUserDetails(Driver driver) {
        this.driver = driver;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return driver.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return driver.getPassword();
    }

    @Override
    public String getUsername() {
        return driver.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
