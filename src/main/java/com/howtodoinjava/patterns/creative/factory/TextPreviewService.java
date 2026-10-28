package com.howtodoinjava.patterns.creative.factory;

public final class TextPreviewService extends PreviewService {
    @Override
    protected Renderer createRenderer() {
        return new PlainTextRenderer();
    }
}
