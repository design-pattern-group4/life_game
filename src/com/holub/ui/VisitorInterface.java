package com.holub.ui;

import com.holub.life.speed.*;

public interface VisitorInterface {
    void visit(Fast speed);

    void visit(Halt speed);

    void visit(Medium speed);

    void visit(Agonizing speed);

    void visit(QuiteSlow speed);

    void visit(Slow speed);

    void visit(VeryFast speed);
}
