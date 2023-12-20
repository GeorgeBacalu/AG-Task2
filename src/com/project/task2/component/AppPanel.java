package com.project.task2.component;

import com.project.task2.model.Graph;
import com.project.task2.util.GraphUtil;

import javax.swing.*;
import java.io.IOException;

public class AppPanel extends JPanel {
    private final Graph graph = Graph.getInstance();

    public AppPanel() {
        try {
            GraphUtil.buildGraph(graph);
            graph.buildAdjacencyMatrix();
            graph.buildAdjacencyList();
            System.out.println(graph);
        } catch (IOException e) {
            JOptionPane.showInputDialog(null, "Error while building graph!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
