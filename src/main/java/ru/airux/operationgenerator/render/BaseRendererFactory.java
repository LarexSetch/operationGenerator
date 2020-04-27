package ru.airux.operationgenerator.render;

import ru.airux.operationgenerator.ElementType;

public class BaseRendererFactory implements RendererFactory {
    private final TemplateResolver templateResolver;

    public BaseRendererFactory(TemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
    }

    @Override
    public Renderer create(ElementType elementType) {
        return new PhpRenderer(getClass().getClassLoader().getResourceAsStream(templateResolver.resolve(elementType)));
    }
}
