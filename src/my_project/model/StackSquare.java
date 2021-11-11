package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
import KAGO_framework.view.DrawTool;

public class StackSquare extends GraphicalObject {

    private ViewController viewController;
    private StackSquare previousSquare;
    private boolean arrived;
    private boolean deleted;

    public StackSquare(double x, double y, StackSquare previousSquare, ViewController viewController){
        this.x = x;
        this.y = y;
        this.previousSquare = previousSquare;
        this.viewController = viewController;
        arrived = false;
        deleted = false;
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawRectangle(x,y,20,20);
    }

    @Override
    public void update(double dt){
        if(!arrived){
            y =+ 25*dt;
        }
    }
}
