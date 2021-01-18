package com.example.soulmate.patterns.abstract_factory;

public class MacOsFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new MacOsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
