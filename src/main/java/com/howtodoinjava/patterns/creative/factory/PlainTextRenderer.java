package com.howtodoinjava.patterns.creative.factory;

import java.util.Objects;

public final class PlainTextRenderer implements Renderer {
    @Override
    public String render(String text) {
        return Objects.requireNonNull(text, "text is required");
    }
}
