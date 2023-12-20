package com.project.task2.model;

import java.util.*;
import java.util.stream.Stream;

public class Graph {
    private static Graph instance = null;
    private final List<Node> nodes;
    private final List<Arc> arcs;
    private final List<List<Integer>> adjacencyMatrix;
    private final Map<Node, List<Node>> adjacencyList;
    private final Map<Integer, Integer> idIndexMap;

    private Graph() {
        this.nodes = new ArrayList<>();
        this.arcs = new ArrayList<>();
        this.adjacencyMatrix = new ArrayList<>();
        this.adjacencyList = new HashMap<>();
        this.idIndexMap = new HashMap<>();
    }

    public static Graph getInstance() {
        if (instance == null) {
            instance = new Graph();
        }
        return instance;
    }

    public Map<Integer, Integer> getIdIndexMap() {
        return idIndexMap;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Graph:\n");
        stringBuilder.append("\nNodes:\n");
        nodes.forEach(node -> stringBuilder.append(node).append("\n"));
        stringBuilder.append("\nArcs:\n");
        arcs.forEach(arc -> stringBuilder.append(arc).append("\n"));
        stringBuilder.append("\nAdjacency Matrix:\n");
        adjacencyMatrix.forEach(row -> stringBuilder.append(row).append("\n"));
        stringBuilder.append("\nAdjacency List:\n");
        for (Map.Entry<Node, List<Node>> nodeEntry : adjacencyList.entrySet()) {
            stringBuilder.append(nodeEntry.getKey().getIndex()).append(": ");
            nodeEntry.getValue().forEach(node -> stringBuilder.append(node.getIndex()).append(" "));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void buildAdjacencyMatrix() {
        adjacencyMatrix.clear();
        adjacencyMatrix.addAll(Stream.generate(() -> new ArrayList<>(Collections.nCopies(nodes.size(), 0))).limit(nodes.size()).toList());
        arcs.forEach(arc -> adjacencyMatrix.get(idIndexMap.get(arc.getStart().getId())).set(idIndexMap.get(arc.getEnd().getId()), 1));
    }

    public void buildAdjacencyList() {
        adjacencyList.clear();
        nodes.forEach(node -> adjacencyList.put(node, new ArrayList<>()));
        arcs.forEach(arc -> adjacencyList.get(arc.getStart()).add(arc.getEnd()));
    }

    public void addNode(Node node) {
        List<Integer> newRow = new ArrayList<>();
        adjacencyMatrix.forEach(row -> newRow.add(0));
        adjacencyMatrix.add(newRow);
        adjacencyMatrix.forEach(row -> row.add(0));
        nodes.add(node);
    }

    public void addArc(Arc arc) {
        arcs.add(arc);
        adjacencyMatrix.get(idIndexMap.get(arc.getStart().getId())).set(idIndexMap.get(arc.getEnd().getId()), 1);
    }
}
