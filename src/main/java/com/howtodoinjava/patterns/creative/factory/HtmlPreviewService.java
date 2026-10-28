package com.howtodoinjava.patterns.creative.factory;

public final class HtmlPreviewService extends PreviewService {
    @Override
    protected Renderer createRenderer() {
        return new HtmlRenderer();
    }
}
