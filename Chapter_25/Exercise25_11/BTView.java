/*
Author: Charles Carter
Date: 1/7/2024

Description:  This is the button view class that displays the graphical representation of the binary search tree
in the main BST animation class.   This class is the only class that needed to be modified.   I've marked the places
I've added a variable with [ADDED] and code I've modified with [MODIFIED]

I just needed to add hGap as an additional variable, and make some changes to the displayTree() helper method
to display the BST horizontally instead of vertically.
 */

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;



public class BTView extends Pane {

    private BST<Integer> tree = new BST<>();
    private double radius = 15; // Tree node radius
    private double vGap = 50; // Gap between two levels in a tree
    private double hGap = 50; // Horizontal gap between nodes [ADDED]

    BTView(BST<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree() {
        this.getChildren().clear(); // Clear the pane
        if (tree.getRoot() != null) {
            // Display tree recursively
            displayTree(tree.getRoot(), hGap, getHeight() / 2, vGap);
        }
    }

    /**
     * Display a subtree rooted at position (x, y)
     */
    private void displayTree(BST.TreeNode<Integer> root,
                             double x, double y, double vGap) {
        if (root.left != null) {
            // Draw a line to the left node [MODIFIED]
            getChildren().add(new Line(x, y, x + hGap, y - vGap));
            // Draw the left subtree recursively [MODIFIED]
            displayTree(root.left, x + hGap, y - vGap, vGap / 2);
        }

        if (root.right != null) {
            // Draw a line to the right node [MODIFIED]
            getChildren().add(new Line(x, y, x + hGap, y + vGap));
            // Draw the right subtree recursively [MODIFIED]
            displayTree(root.right, x + hGap, y + vGap, vGap / 2);
        }

        // Display a node
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,
                new Text(x - 4, y + 4, root.element + ""));
    }
}
