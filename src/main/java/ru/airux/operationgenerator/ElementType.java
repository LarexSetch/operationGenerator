package ru.airux.operationgenerator;

public enum ElementType {
    CONTROLLER,
    REQUEST_DTO,
    RESPONSE_DTO,
    OPERATION,
    INTERFACE;

    public static ElementType[] toArray() {
        return new ElementType[]{ElementType.CONTROLLER, ElementType.REQUEST_DTO, ElementType.RESPONSE_DTO, ElementType.INTERFACE, ElementType.OPERATION};
    }
}
