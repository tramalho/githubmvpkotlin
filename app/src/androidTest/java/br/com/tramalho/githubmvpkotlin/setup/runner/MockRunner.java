package br.com.tramalho.githubmvpkotlin.setup.runner;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import br.com.tramalho.githubmvpkotlin.setup.infraestructure.CustomMockApplication;

public class MockRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(
            ClassLoader cl, String className, Context context)
            throws InstantiationException,
            IllegalAccessException,
            ClassNotFoundException {
        return super.newApplication(
                cl, CustomMockApplication.class.getName(), context);
    }
}