package ru.airux.operationgenerator.render;

import ru.airux.operationgenerator.ElementType;

public interface RendererFactory {
    Renderer create(ElementType elementType);
}
