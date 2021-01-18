package com.example.soulmate.patterns.abstract_factory;

public class Demo {

    //Создайте таблицу соотношений типов продуктов к вариациям семейств продуктов.
    //
    //Сведите все вариации продуктов к общим интерфейсам.
    //
    //Определите интерфейс абстрактной фабрики. Он должен иметь фабричные методы для создания каждого из типов продуктов.
    //
    //Создайте классы конкретных фабрик, реализовав интерфейс абстрактной фабрики. Этих классов должно быть столько же, сколько и вариаций семейств продуктов.
    //
    //Измените код инициализации программы так, чтобы она создавала определённую фабрику и передавала её в клиентский код.
    //
    //Замените в клиентском коде участки создания продуктов через конструктор вызовами соответствующих методов фабрики.

    private static Application configureApplication() {
        Application app;
        GuiFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")) {
            factory = new MacOsFactory();
            app = new Application(factory);
        } else {
            factory = new WindowsFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application application = configureApplication();
        application.paint();
    }
}
