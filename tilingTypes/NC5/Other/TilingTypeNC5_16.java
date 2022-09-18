package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_16
   extends TilingType
{
   public TilingTypeNC5_16(){
      super( "NC5-16", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{ 60};
      paramDef = new int[]{ 30};
      paramName = new String[]{ "AngleC" };


      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,4, 0},
            {0, 0,1, 0,2,3, 1},
            {1, 0,1, 2,0,4, 1},

            {1, 4,0, 3,0,4, 1},
            {0, 0,4, 4,0,1, 1},
            {0, 2,3, 5,0,1, 0},
            {1, 0,1, 6,0,4, 0},
      };
      info = "a=b=d\nc=e\nB+E=360\nB+C+2D=360\n(A+C+D=180)";
   }

   private class Func implements IFunction{
      private double c;
      public Func(double c0){ c = c0; }
      public double calculate(double e){
         double d = 2*c+e;
         double x = e-(180-c)/2;
         double y = 180-d-x;

         double h= Math.tan((90-c/2)*DEG2RAD)/2;
         double dx = 0.5 - Math.sin((c/2-y)*DEG2RAD);
         double dy = h - Math.cos((c/2-y)*DEG2RAD);
         double x_calc = 90 - c/2 - Math.atan2(dy,dx)/DEG2RAD;

         return x-x_calc;
      }
   }

   public void recalcBase(double[] paramValues) {
      double c = paramValues[0];
      double e = Functions.BisectionMethod(new Func(c), 0, 180, 0.001);
      double d = 2*c+e;
      double a = 180-c-e;

      double h= Math.tan((90-c/2)*DEG2RAD)/2;
      double x = e-(180-c)/2;
      double y = 180-d-x;
      double dx = 0.5 - Math.sin((c/2-y)*DEG2RAD);
      double dy = h - Math.cos((c/2-y)*DEG2RAD);
      double ln2 = Math.sqrt(dx*dx+dy*dy);

      double ln1 = 1.5 / (1+ln2);
      ln2*=ln1;

      double x2 = ln1+ ln2 * Math.cos( (180-d) * DEG2RAD);
      double y2 =      ln2 * Math.sin( (180-d) * DEG2RAD);
      double x3 = x2 + ln1 * Math.cos( (-d-e) * DEG2RAD);
      double y3 = y2 + ln1 * Math.sin( (-d-e) * DEG2RAD);
      double x4 = x3 + ln2 * Math.cos( (180-d-e-a) * DEG2RAD);
      double y4 = y3 + ln2 * Math.sin( (180-d-e-a) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(1)-tiles[1].getX(3);
      offsets[1] = tiles[5].getY(1)-tiles[1].getY(3);
      offsets[2] = tiles[2].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(2)-tiles[0].getY(0);
   }
}
