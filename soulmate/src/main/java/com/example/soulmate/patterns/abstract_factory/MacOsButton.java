package com.example.soulmate.patterns.abstract_factory;

public class MacOsButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}
