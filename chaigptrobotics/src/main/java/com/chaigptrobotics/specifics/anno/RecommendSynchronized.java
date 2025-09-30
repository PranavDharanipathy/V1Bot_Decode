package com.chaigptrobotics.specifics.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface RecommendSynchronized {

    //Purely tag annotation which the sadly the lint-api cannot be added because the gradle version is too low - I think.
}
