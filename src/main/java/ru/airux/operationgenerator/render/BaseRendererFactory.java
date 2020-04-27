package ru.airux.operationgenerator.render;

public class BaseRendererFactory implements RendererFactory {
    @Override
    public Renderer create(String templateName) {
        return new PhpRenderer(getClass().getClassLoader().getResourceAsStream(templateName));
    }
}
