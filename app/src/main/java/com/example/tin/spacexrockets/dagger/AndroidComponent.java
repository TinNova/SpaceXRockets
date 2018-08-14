package com.example.tin.spacexrockets.dagger;

import com.example.tin.spacexrockets.AppClass;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = {ApiModule.class})
@Singleton
public interface AndroidComponent {

    void inject(AppClass appClass);

}
