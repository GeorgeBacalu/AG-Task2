package com.project.task2.model;

public class Node {
    private int x;
    private int y;
    private int id;
    private int index;

    public Node(int x, int y, int id, int index) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.index = index;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Node{[id=" + id + ", index=" + index + "], x=" + x + ", y=" + y + '}';
    }
}
