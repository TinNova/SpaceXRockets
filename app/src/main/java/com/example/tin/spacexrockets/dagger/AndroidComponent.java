package com.example.tin.spacexrockets.dagger;

import com.example.tin.spacexrockets.AppClass;
import com.example.tin.spacexrockets.mvvm.DetailViewModel;
import com.example.tin.spacexrockets.mvvm.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = {ApiModule.class})
@Singleton
public interface AndroidComponent {

    void inject(AppClass appClass);
    void inject(MainViewModel mainViewModel);
    void inject(DetailViewModel detailViewModel);


}
