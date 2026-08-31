package edu.unc.comp210.Encapsulation;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    @Override
    public String toString(){
        return String.format("(%.1f,%.1f)", this.x, this.y);
    }

    public double distanceTo(Point other){
        return Math.sqrt((this.getX()-other.getX())*(this.getX()-other.getX())+
                (this.getY()-other.getY())*(this.getY()-other.getY()));

    }

}
