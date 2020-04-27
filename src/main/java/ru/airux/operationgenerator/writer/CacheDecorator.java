package ru.airux.operationgenerator.writer;

import ru.airux.operationgenerator.ElementType;
import ru.airux.operationgenerator.Operation;

import java.util.Map;

public class CacheDecorator implements CharWriterFactory {
    private final Map<String, CharWriter> cache;
    private final CharWriterFactory inner;

    public CacheDecorator(Map<String, CharWriter> cache, CharWriterFactory inner) {
        this.cache = cache;
        this.inner = inner;
    }

    @Override
    public CharWriter create(ElementType type, Operation operation) {
        if (null == cache.get(resolveKey(type, operation))) {
            cache.put(resolveKey(type, operation), inner.create(type, operation));
        }

        return cache.get(resolveKey(type, operation));
    }

    private String resolveKey(ElementType type, Operation operation) {
        return type.toString() + operation.toString();
    }
}
