package refactoring_guru.behavioral.memento.example.commands;

import refactoring_guru.behavioral.memento.example.editor.Editor;
import refactoring_guru.behavioral.memento.example.shapes.Shape;

import java.awt.*;

public class ColorCommand implements Command {
    private final Editor editor;
    private final Color color;

    public ColorCommand(Editor editor, Color color) {
        this.editor = editor;
        this.color = color;
    }

    @Override
    public String getName() {
        return "Colorize: " + color.toString();
    }

    @Override
    public void execute() {
        for (Shape child : editor.getShapes().getSelected()) {
            child.setColor(color);
        }
    }
}
