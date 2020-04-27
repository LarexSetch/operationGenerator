package ru.airux.operationgenerator;

import java.util.ArrayList;
import java.util.List;

public class ConsoleOperationsFactory implements OperationsFactory {
    private final ComponentFactory componentFactory;

    public ConsoleOperationsFactory(ComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
    }

    @Override
    public List<Operation> create(String[] consoleArguments) {
        Component component = componentFactory.create(consoleArguments);
        List<Operation> operations = new ArrayList<>();
        for (int i = 0; i < consoleArguments.length; i++) {
            if ("--operation".equals(consoleArguments[i]) && i + 1 < consoleArguments.length) {
                operations.add(createOperation(component, consoleArguments[i + 1]));
            }
        }

        return operations;
    }

    private Operation createOperation(Component component, String operationName) {
        return
                new Operation(
                        component,
                        operationName,
                        operationName + "Interface",
                        operationName + "Request",
                        operationName + "Response"
                );
    }
}
