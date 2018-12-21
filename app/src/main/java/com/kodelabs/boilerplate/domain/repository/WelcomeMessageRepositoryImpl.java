package com.kodelabs.boilerplate.domain.repository;

public class WelcomeMessageRepositoryImpl implements MessageRepository {

    @Override
    public String getWelcomeMessage() {
        String msg = "Welcome, friend!"; // let's be friendly

        // let's simulate some network/database lag
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return msg;
    }
}
