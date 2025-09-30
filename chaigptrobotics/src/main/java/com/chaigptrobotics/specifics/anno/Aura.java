package com.chaigptrobotics.specifics.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Aura {

    String aura_level() default "I have aura";

    String[] keys() default {"zeta", "gamma", "delta", "theta", "beta", "alpha", "omega", "giga", "tera", "mu", "sigma"};
    String[] messages() default {};

}
