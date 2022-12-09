package com.holub.life.speed;

import com.holub.life.Clock;
import com.holub.ui.VisitorElement;
import com.holub.ui.VisitorInterface;
import java.util.ArrayList;

//speed menu separated
public class ControlSpeed {
    private static ControlSpeed controlSpeed = new ControlSpeed();
    Speed speed;

    //instance only one
    public static ControlSpeed getInstance() {
        return controlSpeed;
    }

    //default is Agonizing
    private ControlSpeed() {
        speed = new Agonizing(); //default
    }
    ArrayList<VisitorElement> getSpeeds(){
        ArrayList<VisitorElement>elements = new ArrayList<>();
        elements.add(new Halt());
        elements.add(new Agonizing());
        elements.add(new Slow());
        elements.add(new Medium());
        elements.add(new Fast());
        elements.add(new VeryFast());  //5
        return elements;
    }
    public void addMenus(VisitorInterface visitor){
        for(VisitorElement element:getSpeeds()){
            element.accept(visitor);
        }
    }
    public void setSpeed(Speed speed){
        this.speed = speed;
        Clock.instance().startTicking(speed.getSpeed());
        Clock.instance().startTicking(speed.getSpeed());
    }
    public Speed getSpeed(){return speed;}
}
