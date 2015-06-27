package capprotectors.saveyourcap;

import android.graphics.Rect;

public class Student {

    final float inertia = (float) 3;

    private int lives;
    private int studentWidth;
    private int studentHeight;
    private int studentX; //center
    private int studentY;
    private int studentDestY = studentY;
    private float studentSpeed;
    private boolean newMove = false;
//    private int midPoint;

    public static Rect boundingBox = new Rect(0, 0, 0, 0);

    public Student(int lives, int studentWidth, int studentHeight, int studentX, int studentY) {
        this.lives = lives;
        this.studentWidth = studentWidth;
        this.studentHeight = studentHeight;
        this.studentX = studentX;
        this.studentY = studentY;
    }

    public void update() {
        /*if (studentY != studentDestY) {
            if ((studentY < midPoint && midPoint < studentDestY) || (studentY > midPoint && midPoint > studentDestY)) {
                studentSpeed += Math.signum(studentDestY - studentY)*inertia;
            }
            else {
                studentSpeed -= Math.signum(studentDestY - studentY)*inertia;
            }
        }*/
        if (newMove && studentY != studentDestY) {
            studentSpeed = (studentDestY - studentY) / 50; //TODO
            newMove = false;
        }

//        if (Math.abs(studentDestY-studentY)<2*inertia && studentSpeed > 0 && (studentY+studentSpeed > studentDestY) || (studentSpeed < 0 && studentY+studentSpeed < studentDestY)) {
        if (Math.abs(studentDestY-studentY) < studentSpeed) {
            studentSpeed = 0;
            studentY = studentDestY;
        }
        else {
            studentY += studentSpeed;
        }

        boundingBox.set(studentX-studentWidth/2, studentY-studentHeight/2, studentX+studentWidth/2, studentY+studentHeight/2);
    }

    public void moveTo(int y) {
        int dest = GameScreen.screenHeight*y/4;
        if (y != studentDestY) {
            studentDestY = dest;
            newMove = true;
//            midPoint = (y + studentY) / 2;
        }
    }

    public void moveUp() {
        if (studentDestY > GameScreen.screenHeight*3/8) { // make up for inaccuracies due to integer division
            studentDestY -= GameScreen.screenHeight / 4;
            newMove = true;
        }
        else if (studentDestY < GameScreen.screenHeight/4)
            studentDestY = GameScreen.screenHeight/4;
    }

    public void moveDown() {
        if (studentDestY < GameScreen.screenHeight*5/8) {
            studentDestY += GameScreen.screenHeight / 4;
            newMove = true;
        }
        else if (studentDestY > GameScreen.screenHeight*3/4)
            studentDestY = GameScreen.screenHeight*3/4;
    }

    public void lostALife(){
        lives -= 1;
    }

    public int getLives() {
        return lives;
    }

    public int getX() {
        return studentX;
    }

    public int getY() {
        return studentY;
    }

    public int getWidth() {
        return studentWidth;
    }

    public int getHeight() {
        return studentHeight;
    }
}
