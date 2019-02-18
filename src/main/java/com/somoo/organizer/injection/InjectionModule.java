package com.somoo.organizer.injection;

import com.google.inject.AbstractModule;
import com.somoo.organizer.service.impl.UserRepositoryServiceImpl;
import com.somoo.organizer.service.interfaces.UserRepositoryService;

public class InjectionModule  extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserRepositoryService.class).to(UserRepositoryServiceImpl.class);
    }
}
