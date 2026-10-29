package com.howtodoinjava.patterns.creative.factory;

import java.util.Objects;

public abstract class PreviewService {
    public final String preview(String text) {
        Objects.requireNonNull(text, "text is required");
        if (text.isBlank()) {
            throw new IllegalArgumentException("text must not be blank");
        }
        Renderer renderer = createRenderer();
        return renderer.render(text);
    }

    protected abstract Renderer createRenderer();
}
