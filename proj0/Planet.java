/**
 * Created by acer on 2016/7/11.
 */
public class Planet {
    double xxPos, yyPos, xxVel, yyVel, mass;
    String imgFileName;

    final double G = 6.67*Math.pow(10, -11);

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet P){
        this(P.xxPos, P.yyPos, P.xxVel, P.yyVel, P.mass, P.imgFileName);
    }

    public double calcDistance(Planet A){
        double dx = this.xxPos - A.xxPos;
        double dy = this.yyPos - A.yyPos;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public double calcForceExertedBy(Planet A){
        double d = calcDistance(A);
        return G*mass*A.mass/(d*d);
    }

    public double calcForceExertedByX(Planet A){
        double d = calcDistance(A);
        double dx = A.xxPos - xxPos;
        double F = calcForceExertedBy(A);

        return F*dx/d;
    }

    public double calcForceExertedByY(Planet A){
        double d = calcDistance(A);
        double dy = A.yyPos - yyPos;
        double F = calcForceExertedBy(A);

        return F*dy/d;
    }

    public double calcNetForceExertedByX(Planet[] A){
        int i = 0;
        double NetFX = 0;
        while(i < A.length){
            if(!this.equals(A[i]))
                NetFX = NetFX + calcForceExertedByX(A[i]);
            i = i + 1;
        }

        return NetFX;
    }

    public double calcNetForceExertedByY(Planet[] A){
        int i = 0;
        double NetFY = 0;
        while(i < A.length){
            if(!this.equals(A[i]))
                NetFY = NetFY + calcForceExertedByY(A[i]);
            i = i + 1;
        }

        return NetFY;
    }

    public void update(double t, double FX, double FY ){
        xxVel = xxVel + t*(FX/mass);
        yyVel = yyVel + t*(FY/mass);

        xxPos = xxPos + t*xxVel;
        yyPos = yyPos + t*yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"./images/"+imgFileName);
    }


}
