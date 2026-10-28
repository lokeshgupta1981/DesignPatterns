package com.howtodoinjava.patterns.creative.factory;

import java.util.Objects;

public final class HtmlRenderer implements Renderer {
    @Override
    public String render(String text) {
        Objects.requireNonNull(text, "text is required");
        String escaped = text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
        return "<p>" + escaped + "</p>";
    }
}
