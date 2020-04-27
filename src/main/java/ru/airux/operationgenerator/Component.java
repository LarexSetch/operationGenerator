package ru.airux.operationgenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Component {
    String packageName;
    String directory;

    public Component(String packageName, String directory) {
        this.packageName = packageName;
        this.directory = directory;
    }
}
