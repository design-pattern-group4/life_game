package com.holub.ui;

import com.holub.ExampleMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuVisitor implements VisitorInteface {

    @Override
    public void visit(ExampleMenu exampleMenu) {
        MenuSite.addLine(this, "MenuName", exampleMenu.getMenuName(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 각 메뉴의 인스턴스 불러와서 필요한 동작 수행
            }
        });
    }
}
