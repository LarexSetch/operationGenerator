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
            case CONTROLLER:
                return getControllerDirectory(operation) + operation.getName() + ".php";
            case INTERFACE:
                return getOperationDirectory(operation) + operation.getName() + "Interface.php";
            case REQUEST_DTO:
                return getDtoDirectory(operation) + operation.getName() + "Request.php";
            case RESPONSE_DTO:
                return getDtoDirectory(operation) + operation.getName() + "Response.php";
            default:
                throw new RuntimeException("Cannot resolve filepath unsupported type " + type.toString());
        }
    }

    private String getDtoDirectory(Operation operation) {
        return getOperationDirectory(operation) + "Dto" + fileSeparator;
    }

    private String getOperationDirectory(Operation operation) {
        return directoryName + fileSeparator + operation.getComponent().getSourceDirectory() + fileSeparator + "Operation" + fileSeparator + operation.getComponent().getName() + fileSeparator + operation.getName() + fileSeparator;
    }

    private String getControllerDirectory(Operation operation) {
        return directoryName + fileSeparator + operation.getComponent().getSourceDirectory() + fileSeparator + "Controller" + fileSeparator + operation.getComponent().getName() + fileSeparator;
    }
}
