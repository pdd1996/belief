package com.example.belief.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.belief.di.ApplicationContext;
import com.example.belief.di.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

//提供ApplicationContext限定符下的bean定义
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}