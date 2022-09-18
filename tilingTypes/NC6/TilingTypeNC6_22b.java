package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC6_22b
   extends TilingType
{
   public TilingTypeNC6_22b(){
      super( "NC6-22b", 6, SymmetryType.p2 );

      paramMin = new int[]{ 60};
      paramMax = new int[]{111};
      paramDef = new int[]{ 85};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
         {0, 0,0, 0,0,0, 0},
         {1, 1,0, 0,1,2, 0},
         {2, 5,4, 1,1,2, 0},
         {0, 5,4, 0,4,5, 0},
         {1, 1,0, 3,1,2, 0},
         {2, 5,4, 4,1,2, 0},

      };
      info = "a=d=e\nb=c=f\nB=D\nC=F\nE+F=360\n(A+2D+F=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lna = 1.0;
      double b = getParam(paramValues,0);
      
      new Func(85).calculate(67.49);
      
      double c = Functions.BisectionMethod(new Func(b), 45, 90, 0.0001);
      double lnc = calclnc(b,c);
      
      double x1 = lna;
      double y1 = 0;
      double x2 = x1 + lna * Math.cos( (180-b) * DEG2RAD );
      double y2 = y1 + lna * Math.sin( (180-b) * DEG2RAD );
      double x3 = x2 + lnc * Math.cos( (-b-c) * DEG2RAD );
      double y3 = y2 + lnc * Math.sin( (-b-c) * DEG2RAD );
      double x4 = x3 + lnc * Math.cos( (180-b-b-c) * DEG2RAD );
      double y4 = y3 + lnc * Math.sin( (180-b-b-c) * DEG2RAD );
      double x5 = x4 + lna * Math.cos( (-b-b) * DEG2RAD );
      double y5 = y4 + lna * Math.sin( (-b-b) * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(2)-tiles[5].getX(1);
      offsets[1] = tiles[2].getY(2)-tiles[5].getY(1);
      offsets[2] = tiles[5].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[5].getY(1)-tiles[0].getY(0);
   }
   public double calclnc(double b, double c){
      double a = 360-2*b-c;
      // b=d
      // c=f=360-e
      double dy1 = Math.sin(b*DEG2RAD) -  Math.sin((a-180+c)*DEG2RAD);
      double dy2 = 2*Math.sin(a*DEG2RAD) +  Math.sin((b+c)*DEG2RAD);
      double lnc = dy1/dy2;
      return lnc;     
   }
   private class Func implements IFunction{
      private double b;
      Func( double b0){ b = b0;}
      public double calculate(double c) {
         double lnc = calclnc(b,c);
         double a = 360-2*b-c;
         double dx1 = 1-Math.cos(b*DEG2RAD) -  Math.cos((a-180+c)*DEG2RAD);
         double dx2 = 2*Math.cos(a*DEG2RAD) -  Math.cos((b+c)*DEG2RAD);
         return dx1-dx2*lnc;
      }
   }   
}