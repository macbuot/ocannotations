package oc.annotation;

import oc.classes.TypeCryptage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Crypted {
    TypeCryptage type() default TypeCryptage.MD5;
}
