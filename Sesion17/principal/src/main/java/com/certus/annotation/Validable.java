/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.certus.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author jdextre
 */
//Para clases
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validable {
    //Indicar lo que va realizar la anotación
    boolean mayusculas() default false;
}
