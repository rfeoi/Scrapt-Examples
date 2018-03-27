package de.felix.test;

import com.rfeoi.scrapt.API.Listener;
import com.rfeoi.scrapt.API.frame.WindowFrame;
import com.rfeoi.scrapt.API.objects.Spirit;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Test {
    public static WindowFrame frame;
    public static void main(String[] args){
        frame = new WindowFrame(new Dimension(1000,1000), "Scrapt fish player example", listener);
        try {
            frame.setBackgroundImage(new File("background.jpg"));
            frame.spirits.put("player", new Spirit(new File("player.png"), 90, 160));
            frame.spirits.put("fish", new Spirit(new File("fish.png"), 160, 90));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.spirits.get("fish").show();
        frame.spirits.get("fish").setLocationX(500);
        frame.spirits.get("fish").setLocationY(500);
        frame.spirits.get("player").show();
        frame.spirits.get("player").setLocationY(840);
        frame.spirits.get("player").setLocationX(900);
        while(true);
    }



    private static void moved(){
        if (frame.touches("player", "fish")){
            frame.spirits.get("fish").hide();
        }
    }
    private static Listener listener = new Listener() {
        @Override
        public void mouseDragged(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            frame.spirits.get("player").setLocationX(frame.getMouseX());
            frame.stopAtWall("player");
            moved();
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }

        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            switch(keyEvent.getKeyCode()){
                case KeyEvent.VK_DOWN:
                    frame.spirits.get("player").changeYby(10);
                    frame.stopAtWall("player");
                    moved();
                    break;
                case KeyEvent.VK_UP:
                    frame.spirits.get("player").changeYby(-10);
                    frame.stopAtWall("player");
                    moved();
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    };
}
