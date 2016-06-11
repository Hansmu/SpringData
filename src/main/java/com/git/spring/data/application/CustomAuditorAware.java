package com.git.spring.data.application;

import org.springframework.data.domain.AuditorAware;

//Type of AuditorAware has to match the type that has been given to the fields on the entity. We had String, so this gets String.
public class CustomAuditorAware implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "Bob Roberts";
    }
}
