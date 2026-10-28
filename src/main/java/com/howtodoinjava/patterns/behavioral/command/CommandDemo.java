package com.howtodoinjava.patterns.behavioral.command;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

public class CommandDemo {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        CommandHistory history = new CommandHistory();

        history.run(new AddSong(playlist, "Yesterday"));
        history.run(new AddSong(playlist, "Hey Jude"));
        history.run(new AddSong(playlist, "Yesterday"));
        System.out.println("After adding: " + playlist.songs());

        history.run(new RemoveSong(playlist, "Yesterday"));
        System.out.println("After removing first match: " + playlist.songs());
        history.undo();
        System.out.println("After undo: " + playlist.songs());
        history.redo();
        System.out.println("After redo: " + playlist.songs());

        history.undo();
        history.run(new AddSong(playlist, "Help"));
        System.out.println("After new action: " + playlist.songs());
        System.out.println("Redo available: " + history.redo());
    }
}

interface Command {
    void execute();
    void undo();
}

final class Playlist {
    private final List<String> songs = new ArrayList<>();

    int size() { return songs.size(); }
    void add(int index, String song) { songs.add(index, song); }
    int indexOf(String song) { return songs.indexOf(song); }
    String remove(int index) { return songs.remove(index); }
    List<String> songs() { return List.copyOf(songs); }
}

final class AddSong implements Command {
    private final Playlist playlist;
    private final String song;
    private int addedAt;

    AddSong(Playlist playlist, String song) {
        this.playlist = Objects.requireNonNull(playlist);
        this.song = Objects.requireNonNull(song);
    }

    public void execute() {
        addedAt = playlist.size();
        playlist.add(addedAt, song);
    }

    public void undo() {
        playlist.remove(addedAt);
    }
}

final class RemoveSong implements Command {
    private final Playlist playlist;
    private final String song;
    private int removedAt;

    RemoveSong(Playlist playlist, String song) {
        this.playlist = Objects.requireNonNull(playlist);
        this.song = Objects.requireNonNull(song);
    }

    public void execute() {
        removedAt = playlist.indexOf(song);
        if (removedAt >= 0) {
            playlist.remove(removedAt);
        }
    }

    public void undo() {
        if (removedAt >= 0) {
            playlist.add(removedAt, song);
        }
    }
}

final class CommandHistory {
    private final Deque<Command> undo = new ArrayDeque<>();
    private final Deque<Command> redo = new ArrayDeque<>();

    void run(Command command) {
        Objects.requireNonNull(command).execute();
        undo.push(command);
        redo.clear();
    }

    boolean undo() {
        if (undo.isEmpty()) { return false; }
        Command command = undo.peek();
        command.undo();
        undo.pop();
        redo.push(command);
        return true;
    }

    boolean redo() {
        if (redo.isEmpty()) { return false; }
        Command command = redo.peek();
        command.execute();
        redo.pop();
        undo.push(command);
        return true;
    }
}
