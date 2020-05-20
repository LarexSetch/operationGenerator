package ru.airux.operationgenerator.render;

import org.apache.commons.io.IOUtils;
import ru.airux.operationgenerator.Operation;

import java.io.IOException;
import java.io.InputStream;

public class PhpRenderer implements Renderer {
    private final InputStream stream;

    public PhpRenderer(InputStream inputStream) {
        stream = inputStream;
    }

    @Override
    public String render(Operation operation) {
        try {
            return
                    IOUtils.toString(stream)
                            .replace("{componentName}", operation.getComponent().getName())
                            .replace("{controllerPackage}", getControllerPackage(operation))
                            .replace("{operationPackage}", getOperationPackage(operation))
                            .replace("{operationName}", operation.getName());
        } catch (IOException exception) {
            exception.printStackTrace();

            throw new RuntimeException("Cannot render");
        }
    }

    private String getControllerPackage(Operation operation) {
        return operation.getComponent().getPackagePrefix() + "\\Controller";
    }
    private String getOperationPackage(Operation operation) {
        return operation.getComponent().getPackagePrefix() + "\\Operation\\" + operation.getComponent().getName() + "\\" + operation.getName();
    }
}
