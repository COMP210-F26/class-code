package edu.unc.comp210.Encapsulation;


public class PointTriangle {
    private Point a;
    private Point b;
    private Point c;

    public PointTriangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getPerimeter(){
        return a.distanceTo(b) + b.distanceTo(c) + c.distanceTo(a);
    }
    public void transpose(double xDir, double yDir){
        this.a = new Point(this.a.getX() + xDir, a.getY() + yDir);
        this.b = new Point(this.b.getX() + xDir, b.getY() + yDir);
        this.c = new Point(this.c.getX() + xDir, c.getY() + yDir);
    }

    public String toString(){
        return String.format("%s,%s,%s", this.a, this.b,this.c);
    }
}
