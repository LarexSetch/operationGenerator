package ru.airux.operationgenerator;

import lombok.Getter;

@Getter
public class Operation {
    Component component;
    String name;
    String interfaceName;
    String requestClass;
    String responseClass;

    public Operation(Component component, String name, String interfaceName, String requestClass, String responseClass) {
        this.component = component;
        this.name = name;
        this.interfaceName = interfaceName;
        this.requestClass = requestClass;
        this.responseClass = responseClass;
    }
}
