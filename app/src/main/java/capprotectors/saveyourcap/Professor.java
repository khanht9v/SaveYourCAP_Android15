package capprotectors.saveyourcap;

import android.graphics.Rect;

public class Professor {
    private int professorWidth;
    private int professorHeight;
    private int professorX; //center
    private int professorY;
    private float professorSpeed;
    private boolean dead = false;

    public Rect r = new Rect(0, 0, 0, 0);

    public Professor(int professorWidth, int professorHeight, int professorX, int professorY, float professorSpeed) {
        this.professorWidth = professorWidth;
        this.professorHeight = professorHeight;
        this.professorX = professorX;
        this.professorY = professorY;
        this.professorSpeed = professorSpeed;
    }

    public void update() {
        professorX += professorSpeed;
        r.set(professorX-professorWidth/2, professorY-professorHeight/2, professorX+professorWidth/2, professorY+professorHeight/2);
        if (r.intersect(Student.boundingBox)){
            // interactWithStudent();
            die();
        } else if (r.intersect(0, 0, 0, 800)) { // TODO: replace 800 with screenHeight
            die();
        }
    }

    public void die(){
        dead = true;
    }

    public int getX() {
        return professorX;
    }

    public int getY() {
        return professorY;
    }

    public boolean isDead() {
        return dead;
    }
}
