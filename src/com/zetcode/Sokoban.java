package com.zetcode;

import javax.swing.*;
import java.awt.*;

public class Sokoban extends JFrame {

    private final int OFFSET = 30;

    public Sokoban() {

        initUI();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            Sokoban game = new Sokoban();
            game.setVisible(true);
        });
    }

    private void initUI() {

        Board board = new Board();
        add(board);

        setTitle("Sokoban");

        setSize(board.getBoardWidth() + OFFSET,
                board.getBoardHeight() + 2 * OFFSET);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
