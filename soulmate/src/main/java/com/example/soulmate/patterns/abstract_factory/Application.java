package com.example.soulmate.patterns.abstract_factory;

public class Application {

    private Button button;
    private Checkbox checkbox;

    public Application(GuiFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
