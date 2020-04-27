package ru.airux.operationgenerator.render;

import ru.airux.operationgenerator.ElementType;

public class BaseTemplateResolver implements TemplateResolver {
    @Override
    public String resolve(ElementType type) {
        switch (type) {
            case CONTROLLER:
                return "templates/Controller.php";
            case INTERFACE:
                return "templates/Operation.php";
            case REQUEST_DTO:
                return "templates/RequestDto.php";
            case RESPONSE_DTO:
                return "templates/ResponseDto.php";
            default:
                throw new RuntimeException("Unsupported element type " + type.toString());
        }
    }
}
