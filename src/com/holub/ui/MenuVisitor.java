package com.holub.ui;

import com.holub.life.speed.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuVisitor implements VisitorInterface {

    @Override
    public void visit(Fast speed) {
        MenuSite.addLine(this, "Speed", speed.getMenuName(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 각 메뉴의 인스턴스 불러와서 필요한 동작 수행
                ControlSpeed.getInstance().setSpeed(speed);
            }
        });
    }

    @Override
    public void visit(Halt speed) {
        MenuSite.addLine(this, "Speed", speed.getMenuName(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 각 메뉴의 인스턴스 불러와서 필요한 동작 수행
                ControlSpeed.getInstance().setSpeed(speed);
            }
        });
    }

    @Override
    public void visit(Medium speed) {
        MenuSite.addLine(this, "Speed", speed.getMenuName(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 각 메뉴의 인스턴스 불러와서 필요한 동작 수행
                ControlSpeed.getInstance().setSpeed(speed);
            }
        });
    }

    @Override
    public void visit(Agonizing speed) {
        MenuSite.addLine(this, "Speed", speed.getMenuName(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 각 메뉴의 인스턴스 불러와서 필요한 동작 수행
                ControlSpeed.getInstance().setSpeed(speed);
            }
        });
    }

    @Override
    public void visit(QuiteSlow speed) {
        MenuSite.addLine(this, "Speed", speed.getMenuName(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 각 메뉴의 인스턴스 불러와서 필요한 동작 수행
                ControlSpeed.getInstance().setSpeed(speed);
            }
        });
    }

    @Override
    public void visit(Slow speed) {
        MenuSite.addLine(this, "Speed", speed.getMenuName(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 각 메뉴의 인스턴스 불러와서 필요한 동작 수행
                ControlSpeed.getInstance().setSpeed(speed);
            }
        });
    }

    @Override
    public void visit(VeryFast speed) {
        MenuSite.addLine(this, "Speed", speed.getMenuName(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 각 메뉴의 인스턴스 불러와서 필요한 동작 수행
                ControlSpeed.getInstance().setSpeed(speed);
            }
        });
    }
}
