package ru.airux.operationgenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Component {
    String name;
    String sourceDirectory;
    String packagePrefix;

    public Component(String name, String sourceDirectory, String packagePrefix) {
        this.name = name;
        this.sourceDirectory = sourceDirectory;
        this.packagePrefix = packagePrefix;
    }
}
