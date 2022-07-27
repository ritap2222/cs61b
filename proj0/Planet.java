public class Planet {
    public double xxPos;    //current x position
    public double yyPos;    //current y position
    public double xxVel;    //current velocity in the x direction
    public double yyVel;    //current velocity in the x direction
    public double mass;     //mass
    public String imgFileName;  //The name of the file that corresponds to the image of the planet

    
    public double calcXX;   //exert.planet- be exerted.planet
    public double calcYY;   //exert.planet- be exerted.planet
    public double tempDistance; //distance before sqrt
    public double distance; //distance between two planet

    public double force;    //force exerted by planet
    public double forceX;
    public double forceY;

    public Planet[] allplanets = new Planet[10]; //planet array
    public boolean samePlanet;
    public double netForceX;
    public double netForceY;

    public double dt;   //time

    public Planet (double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet (Planet p) {
        p.xxPos = xxPos;
        p.yyPos = yyPos;
        p.xxVel = xxVel;
        p.yyVel = yyVel;
        p.mass = mass;
        p.imgFileName = imgFileName;
    }

    public double calcDistance (Planet calcPlanet) {
        calcXX = calcPlanet.xxPos - this.xxPos;
        calcYY = calcPlanet.yyPos - this.yyPos;
        tempDistance = (calcXX * calcXX) + (calcYY * calcYY);
        distance = Math.sqrt(tempDistance);
        return distance;
    }

    public double calcForceExertedBy (Planet exertPlanet) {
        force = (6.67e-11) * this.mass * exertPlanet.mass / this.calcDistance(exertPlanet) / this.calcDistance(exertPlanet);
        return force;
    }

    public double calcForceExertedByX (Planet exertPlanetX) {
        forceX = this.calcForceExertedBy(exertPlanetX) * (exertPlanetX.xxPos - this.xxPos) / this.calcDistance(exertPlanetX);
        return forceX;
    }

    public double calcForceExertedByY (Planet exertPlanetY) {
        forceY = this.calcForceExertedBy(exertPlanetY) * (exertPlanetY.yyPos - this.yyPos) / this.calcDistance(exertPlanetY);
        return forceY;
    }

    public double calcNetForceExertedByX (Planet[] netForcePX) {
        netForceX = 0.0;
        for (int i = 0;i < netForcePX.length;i++) {
            samePlanet = this.equals(netForcePX[i]);
            if (samePlanet == true) {
                continue;
            } else if (samePlanet != true) {
                netForceX = this.calcForceExertedByX(netForcePX[i]) + netForceX;
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY (Planet[] netForcePY) {
        netForceY = 0.0;
        for (int i = 0;i < netForcePY.length;i++) {
            samePlanet = this.equals(netForcePY[i]);
            if (samePlanet == true) {
                continue;
            } else if (samePlanet != true) {
                netForceY = this.calcForceExertedByY(netForcePY[i]) + netForceY;
            }
        }
        return netForceY;
    }

    public void update (double dt, double fX, double fY) {
        this.xxVel = this.xxVel + dt * (fX / this.mass);
        this.yyVel = this.yyVel + dt * (fY / this.mass);
        this.xxPos =  this.xxPos + dt * this.xxVel; 
        this.yyPos =  this.yyPos + dt * this.yyVel; 
    }

    public void draw () {
        /**draw the picture of the planet on position */
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }


}