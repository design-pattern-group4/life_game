package com.holub.ui;

public interface VisitorElement {
    String getMenuName();
    void accept(VisitorInteface visitor);
}
