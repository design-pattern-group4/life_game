package com.holub;

import com.holub.ui.VisitorInteface;
import com.holub.ui.VisitorElement;

public class ExampleMenu implements VisitorElement {

    @Override
    public String getMenuName() {
        return "예시 메뉴 입니다";
    }

    @Override
    public void accept(VisitorInteface visitor) {
        visitor.visit(this);
    }
}
