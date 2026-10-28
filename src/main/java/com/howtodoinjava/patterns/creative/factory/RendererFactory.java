package com.howtodoinjava.patterns.creative.factory;

import java.util.Objects;

public final class RendererFactory {
    private RendererFactory() { }

    public static Renderer create(PreviewFormat format) {
        Objects.requireNonNull(format, "format is required");
        return switch (format) {
            case TEXT -> new PlainTextRenderer();
            case HTML -> new HtmlRenderer();
        };
    }
}
