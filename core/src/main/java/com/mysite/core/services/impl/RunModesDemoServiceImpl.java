package com.mysite.core.services.impl;

import com.mysite.core.services.RunModeDemoServiceConfig;
import com.mysite.core.services.RunModesDemoService;
import com.mysite.core.services.StudentClassService;
import com.mysite.core.services.StudentClassServiceConfiguration;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = {RunModesDemoService.class })
@Designate(ocd= RunModeDemoServiceConfig.class)

public class RunModesDemoServiceImpl implements RunModesDemoService {

    @Override
    public String getname(String name) {
        return name;
    }

    @Override
    public int rollNo(int roll) {
        return roll;
    }
}
