package com.mysite.core.services;


import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="Class service configuration")
public @interface ClassServiceConfiguration {

    @AttributeDefinition(
            name = "No. of Students",
            type = AttributeType.INTEGER)
    int noOfStudents() default 10;
    
    @AttributeDefinition(
            name = "Passing Marks",
            type = AttributeType.INTEGER)
    int score() default 40;
}



