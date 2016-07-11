/**
 * Created by acer on 2016/7/11.
 */
public class NBody {
    public static double readRadius(String FileName){
        In in = new In(FileName);
        String num = in.readLine();
        double R = in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String FileName){
        In in = new In(FileName);
        String num = in.readLine();
        String R = in.readLine();
        int i = 0;
        Planet[] P = new Planet[5];
        while(i < 5){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            P[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            i = i+1;
        }
        return P;
    }

    public static void main(String[] args){
        if (args.length != 3) {
            System.out.println("Please supply 3 command line arguments.");
            System.out.println("T - double, dt - double, filename - String");
			/* System.exit ends the program early. */
            System.exit(0);
        }
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];


        Planet[] P = readPlanets(filename);
        double R = readRadius(filename);

        String BackGround = "images/starfield.jpg";
        StdDraw.clear();
        StdDraw.setScale(-R,R);
        StdDraw.picture(0,0,BackGround,2*R,2*R);

        StdAudio.play("audio/2001.mid");

        for(int i = 0; i < P.length; i++){
            P[i].draw();
        }
        double t = 0;
        while(t < T){
            double[] xForce = new double[5];
            double[] yForce = new double[5];
            for(int i = 0; i<5; i++){
                xForce[i] = P[i].calcNetForceExertedByX(P);
                yForce[i] = P[i].calcNetForceExertedByY(P);
            }
            for(int i = 0; i<5; i++){
                P[i].update(dt,xForce[i],yForce[i]);
            }
            StdDraw.picture(0,0,BackGround,2*R,2*R);
            for(int i = 0; i < P.length; i++){
                P[i].draw();
            }
            StdDraw.show(10);
            t = t + dt;
        }


        StdOut.printf("%d\n", P.length);
        StdOut.printf("%.2e\n", R);
        for(int i = 0; i< P.length; i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    P[i].xxPos, P[i].yyPos, P[i].xxVel, P[i].yyVel,
                    P[i].mass, P[i].imgFileName);
        }
    }
    }





