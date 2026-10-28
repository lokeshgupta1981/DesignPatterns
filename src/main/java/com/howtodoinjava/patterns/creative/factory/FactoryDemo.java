package com.howtodoinjava.patterns.creative.factory;

public class FactoryDemo {
    public static void main(String[] args) {
        String message = "Sale <today> & tomorrow";
        for (PreviewFormat format : PreviewFormat.values()) {
            Renderer renderer = RendererFactory.create(format);
            System.out.println(format + ": " + renderer.render(message));
        }
        PreviewService textService = new TextPreviewService();
        PreviewService htmlService = new HtmlPreviewService();
        System.out.println("Text service: " + textService.preview(message));
        System.out.println("HTML service: " + htmlService.preview(message));

        Renderer first = RendererFactory.create(PreviewFormat.HTML);
        Renderer second = RendererFactory.create(PreviewFormat.HTML);
        System.out.println("Different renderers: " + (first != second));
        try {
            RendererFactory.create(null);
        } catch (NullPointerException exception) {
            System.out.println("Missing format: " + exception.getMessage());
        }
        try {
            htmlService.preview("   ");
        } catch (IllegalArgumentException exception) {
            System.out.println("Blank preview: " + exception.getMessage());
        }
    }
}
