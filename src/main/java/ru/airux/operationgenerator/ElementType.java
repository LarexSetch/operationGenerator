package ru.airux.operationgenerator;

public enum ElementType {
    REQUEST_DTO,
    RESPONSE_DTO,
    INTERFACE;

    public static ElementType[] toArray() {
        return new ElementType[]{ElementType.REQUEST_DTO, ElementType.RESPONSE_DTO, ElementType.INTERFACE};
    }
}
