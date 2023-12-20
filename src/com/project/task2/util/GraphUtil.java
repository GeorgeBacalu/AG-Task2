package com.project.task2.util;

import com.project.task2.model.Arc;
import com.project.task2.model.Graph;
import com.project.task2.model.Node;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphUtil {

    private GraphUtil() {}

    public static void buildGraph(Graph graph) throws IOException {
        List<List<Integer>> labyrinth = FileUtil.readFromFile();
        int nrRows = labyrinth.size(), nrColumns = labyrinth.getFirst().size();
        AtomicInteger nodeIndex = new AtomicInteger();
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < nrRows; ++i) {
            for (int j = 0; j < nrColumns; ++j) {
                if (labyrinth.get(i).get(j) == 1) {
                    int nodeId = i * nrColumns + j + 1, i1 = i, j1 = j;
                    Node currentNode = nodeMap.computeIfAbsent(nodeId, id -> {
                        graph.getIdIndexMap().put(nodeId, nodeIndex.get());
                        Node newNode = new Node(i1, j1, nodeId, nodeIndex.getAndIncrement());
                        graph.addNode(newNode);
                        return newNode;
                    });
                    addArcIfPossible(i - 1, j, nrColumns, nodeMap, currentNode, graph);
                    addArcIfPossible(i, j - 1, nrColumns, nodeMap, currentNode, graph);
                    addArcIfPossible(i + 1, j, nrColumns, nodeMap, currentNode, graph);
                    addArcIfPossible(i, j + 1, nrColumns, nodeMap, currentNode, graph);
                }
            }
        }
    }

    private static void addArcIfPossible(int i, int j, int nrColumns, Map<Integer, Node> nodeMap, Node currentNode, Graph graph) {
        if (i >= 0 && j >= 0 && i * nrColumns + j < nrColumns * nodeMap.size()) {
            int neighbourNodeId = i * nrColumns + j + 1;
            if (nodeMap.containsKey(neighbourNodeId)) {
                graph.addArc(new Arc(currentNode, nodeMap.get(neighbourNodeId)));
            }
        }
    }
}
