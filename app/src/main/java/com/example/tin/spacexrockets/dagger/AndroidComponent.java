package com.example.tin.spacexrockets.dagger;

import com.example.tin.spacexrockets.AppClass;
import com.example.tin.spacexrockets.DetailViewModel;
import com.example.tin.spacexrockets.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = {ApiModule.class})
@Singleton
public interface AndroidComponent {

    void inject(AppClass appClass);
    void inject(MainViewModel mainViewModel);
    void inject(DetailViewModel detailViewModel);


}
