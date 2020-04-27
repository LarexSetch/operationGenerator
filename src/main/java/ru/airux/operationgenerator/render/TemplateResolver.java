package ru.airux.operationgenerator.render;

import ru.airux.operationgenerator.ElementType;

public interface TemplateResolver {
    String resolve(ElementType templateType);
}
