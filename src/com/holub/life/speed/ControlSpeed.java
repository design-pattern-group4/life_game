package com.holub.life.speed;

import com.holub.life.Clock;
import com.holub.ui.MenuSite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//speed menu separated
public class ControlSpeed {
    private static ControlSpeed controlSpeed = new ControlSpeed();
    Speed speed;
    String[] stringArray = {"QuiteSlow","Agonizing","Slow","Medium","Fast","VeryFast"};
    List<Speed> speedList = new ArrayList<Speed>();

    //instance only one
    public static ControlSpeed getInstance() {
        return controlSpeed;
    }

    //default is Agonizing
    private ControlSpeed() {
        speed = new Agonizing(); //default
        speedList.add(new QuiteSlow()); //0
        speedList.add(new Agonizing()); //1 --
        speedList.add(new Slow());      //2
        speedList.add(new Medium());    //3 --
        speedList.add(new Fast());      //4 --
        speedList.add(new VeryFast());  //5

    }
    public void setSpeed(Speed speed){
        this.speed = speed;
    }
    public Speed getSpeed(){return speed;}

    public void MenusLine(){
        for(Speed version : speedList) {
            MenuSite.addLine(this,"Go", version.getName(), modifier);
        }
    }
    ActionListener modifier =
            new ActionListener()
            {	public void actionPerformed(ActionEvent e)
            {
                String name = ((JMenuItem)e.getSource()).getName();

                int cnt = Arrays.asList(stringArray).indexOf(name);
                //System.out.println( "************22****"+cnt+"/////////"+name );
                if(cnt>-1){
                    setSpeed(speedList.get(cnt));
                    Clock.instance().startTicking(speed.getSpeed());
                }
                else { //Halt
                    setSpeed(speedList.get(cnt));
                    Clock.instance().startTicking(0);
                }
            }
            };

}
