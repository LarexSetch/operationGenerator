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
                            .replace("{package}", operation.getComponent().getPackageName())
                            .replace("{operationName}", operation.getName())
                            .replace("{requestClassName}", operation.getRequestClass())
                            .replace("{responseClassName}", operation.getResponseClass())
                            .replace("{interfaceName}", operation.getInterfaceName());
        } catch (IOException exception) {
            exception.printStackTrace();

            throw new RuntimeException("Cannot render");
        }
    }
}
