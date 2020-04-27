package ru.airux.operationgenerator;

import ru.airux.operationgenerator.render.RendererFactory;
import ru.airux.operationgenerator.render.TemplateResolver;
import ru.airux.operationgenerator.writer.CharWriterFactory;

import java.util.Arrays;
import java.util.stream.Stream;

public class BaseOperationCreator implements OperationCreator {
    private final RendererFactory rendererFactory;
    private final TemplateResolver templateResolver;
    private final CharWriterFactory charWriterFactory;

    public BaseOperationCreator(RendererFactory rendererFactory, TemplateResolver templateResolver, CharWriterFactory charWriterFactory) {
        this.rendererFactory = rendererFactory;
        this.templateResolver = templateResolver;
        this.charWriterFactory = charWriterFactory;
    }

    @Override
    public void create(Operation operation) {
        Stream.of(ElementType.toArray())
                .forEach(templateType ->
                        rendererFactory
                                .create(templateResolver.resolve(templateType))
                                .render(operation)

                                .chars()
                                .forEach(c ->
                                        charWriterFactory
                                                .create(templateType, operation)
                                                .write(c)
                                )
                );
    }
}
