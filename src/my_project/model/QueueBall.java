package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class QueueBall extends GraphicalObject {

    private ViewController viewController;
    private QueueBall previousQueueBall;
    private boolean arrived;
    private boolean deleted;

    public QueueBall(double x, double y, QueueBall previousQueueBall, ViewController viewController){
        this.x = x;
        this.y = y;
        this.previousQueueBall = previousQueueBall;
        this.viewController = viewController;
        arrived = false;
        deleted = false;
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawCircle(x,y,20);
    }

    @Override
    public void update(double dt){
        if(!arrived){
            if(previousQueueBall == null || x> previousQueueBall.getX()+50) x -= 100*dt;
            if (x<100) arrived = true;
        }
        if(deleted){
            x -= 100*dt;
            if(x<-25) viewController.removeDrawable(this);
        }
    }

    public boolean isArrived(){
        return arrived;
    }

    public void setDeleted(){
        if(arrived) deleted = true;
    }
}
