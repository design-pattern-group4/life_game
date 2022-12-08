package com.holub.life;

import com.holub.ui.MenuSite;
import com.holub.ui.MenuVisitor;

import javax.swing.*;
import java.awt.*;

public class SampleLife extends JFrame {
    private static JComponent universe;

    public SampleLife() {
        MenuSite.establish(this);        //{=life.java.establish}

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(Universe.instance(), BorderLayout.CENTER); //{=life.java.install}

        MenuVisitor visitor = new MenuVisitor();

        pack();
        setVisible(true);
    }
}
