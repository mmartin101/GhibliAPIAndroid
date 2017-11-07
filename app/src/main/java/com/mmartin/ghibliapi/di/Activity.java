package com.mmartin.ghibliapi.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Scope;

/**
 * Created by mmartin on 10/7/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface Activity {

}
