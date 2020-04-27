package ru.airux.operationgenerator.render;

public interface RendererFactory {
    Renderer create(String templateName);
}
