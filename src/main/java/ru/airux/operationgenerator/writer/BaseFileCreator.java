package ru.airux.operationgenerator.writer;

import ru.airux.operationgenerator.ElementType;
import ru.airux.operationgenerator.Operation;

import java.io.File;
import java.io.IOException;

public class BaseFileCreator implements FileCreator {
    private final String fileSeparator;
    private final String directoryName;

    public BaseFileCreator(String fileSeparator, String directoryName) {
        this.fileSeparator = fileSeparator;

        this.directoryName = directoryName;
    }

    @Override
    public File create(Operation operation, ElementType elementType) {
        try {
            File file = new File(getFilepath(operation, elementType));
            file.getParentFile().mkdirs();
            file.createNewFile();

            return file;
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException("Cannot create file");
        }
    }

    private String getFilepath(Operation operation, ElementType type) {
        switch (type) {
            case INTERFACE:
                return getDirectory(operation) + operation.getInterfaceName() + ".php";
            case REQUEST_DTO:
                return getDirectory(operation) + "Dto" + fileSeparator + operation.getRequestClass() + ".php";
            case RESPONSE_DTO:
                return getDirectory(operation) + "Dto" + fileSeparator + operation.getResponseClass() + ".php";
            default:
                throw new RuntimeException("Cannot resolve filepath unsupported type " + type.toString());
        }
    }

    private String getDirectory(Operation operation) {
        return directoryName + fileSeparator + operation.getComponent().getDirectory() + fileSeparator + operation.getName() + fileSeparator;
    }
}
