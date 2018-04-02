/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author Invité
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface Todos {
    
    Todo[] annotTodo() default {};
    
}
