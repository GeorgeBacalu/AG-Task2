package com.project.task2.model;

public class Arc {
    private Node start;
    private Node end;

    public Arc(Node start, Node end) {
        this.start = start;
        this.end = end;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Arc{start=[id=" + start.getId() + ", index=" + start.getIndex() + "], endValue=[id=" + end.getId() + ", index=" + end.getIndex() + "]" + '}';
    }
}
