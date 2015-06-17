package capprotectors.saveyourcap;

import android.graphics.Rect;

public class Professor {
    private int professorWidth;
    private int professorHeight;
    private int professorX; //center
    private int professorY;
    private float professorSpeed;
    private boolean dead = false;
    
    //Khanh added
    private String grade;
    String[] grades = {"A+","A","A-","B+","B","B-","C+","C","D+","D","F"};
    


    public Rect r = new Rect(0, 0, 0, 0);

    public Professor(int professorWidth, int professorHeight, int professorX, int professorY, float professorSpeed) {
        this.professorWidth = professorWidth;
        this.professorHeight = professorHeight;
        this.professorX = professorX;
        this.professorY = professorY;
        this.professorSpeed = professorSpeed;
        
        //Khanh added
        Random rd = new Random();
        this.grade = grades[rd.nextInt(grades.length)];
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
    
    public String getGrade() {return grade;}

    public int getScore() {
        if (this.grade.equals("A+")) {
            return 10;
        }

        else if (this.grade.equals("A")){
            return 9;
        }

        else if (this.grade.equals("A-")){
            return 8;
        }

        else if (this.grade.equals("B+")){
            return 7;
        }

        else if (this.grade.equals("B")){
            return 6;
        }

        else if (this.grade.equals("B-")){
            return 5;
        }

        else if (this.grade.equals("C+")){
            return 4;
        }

        else if (this.grade.equals("C")){
            return 3;
        }

        else if (this.grade.equals("D+")){
            return -6;
        }

        else if (this.grade.equals("D")){
            return -7;
        }

        else {
            return -10;
        }
    }
}
