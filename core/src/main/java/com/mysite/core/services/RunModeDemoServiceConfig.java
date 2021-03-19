package com.mysite.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="Run mode configuration")
public @interface RunModeDemoServiceConfig {

    @AttributeDefinition(
            name = "Name",
            type = AttributeType.INTEGER)
    String getName() default "Harshu";

    @AttributeDefinition(
            name = "Roll No",
            type = AttributeType.INTEGER)
    int rollNo() default 1;

}