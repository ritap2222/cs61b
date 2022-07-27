public class NBody {
    /* return radius of universe */
    public static int planetNum;
    public static double radiusUniv;

    public static double readRadius(String universeName) {
        /*reading("this name of the file")*/
        In in = new In(universeName);
        planetNum = in.readInt();
        radiusUniv = in.readDouble();

        return radiusUniv;
    }

    public static Planet[] readPlanets(String universeFile) {
        /*reading("this name of the file")*/
        In in = new In(universeFile);
        planetNum = in.readInt();
        radiusUniv = in.readDouble();

        Planet[] allplanets = new Planet[planetNum];

        int i=0;
        
        while (i < planetNum) {
            allplanets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
            i = i+1;
        }

        return allplanets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double time = 0.0;

        double radiusUniv = readRadius(filename);
        Planet[] planetdata = readPlanets(filename);

        /** Sets up the Scale of universe*/
		StdDraw.setScale(-radiusUniv, radiusUniv);

        /** draw starfield as background */
        StdDraw.picture(0.0, 0.0, "images/starfield.jpg");

        /** draw images of all planets */
        int i = 0;
        while (i < planetNum) {
            planetdata[i].draw();
            i = i + 1;
        }

        /** animation usually use this method */
        StdDraw.enableDoubleBuffering();

        double[] netForceXX = new double[planetNum];
        double[] netForceYY = new double[planetNum];

        
        /** create the animation */
        while (time <= T) {

            /** netForceX and netForceY on every planet */
            int j = 0;
            while (j < planetNum) {
                netForceXX[j] = planetdata[j].calcNetForceExertedByX(planetdata);
                netForceYY[j] = planetdata[j].calcNetForceExertedByY(planetdata);
                j = j + 1;  
            }

            /** update object planet */
            int k = 0;
            while (k < planetNum) {
                planetdata[k].update(dt, netForceXX[k], netForceYY[k]);
                k = k + 1;
            }

            /** the background jpg */
            StdDraw.picture(0.0, 0.0, "images/starfield.jpg");
            
            /** image of every planets */
            int l = 0;
            while (l < planetNum) {
                planetdata[l].draw();
                l = l + 1;
            }

            StdDraw.show();

            StdDraw.pause(10);

            time = time + dt;
        }

        System.out.printf("%d\n", planetNum);
        System.out.printf("%.2e\n", radiusUniv);
        
        int m = 0;
        while (m < planetNum) {
            System.out.printf("%.4e %.4e %.4e %.4e %.4e %s\n", planetdata[m].xxPos, planetdata[m].yyPos, planetdata[m].xxVel, planetdata[m].yyVel, planetdata[m].mass, planetdata[m].imgFileName);
            m = m + 1;
        }


    }
}