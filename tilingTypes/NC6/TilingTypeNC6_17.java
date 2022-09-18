package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC6_17
   extends TilingType
{
   public TilingTypeNC6_17(){
      super( "NC6-17", 6, SymmetryType.pgg );

      paramMin = new int[]{ 90};
      paramMax = new int[]{240};
      paramDef = new int[]{115};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 4,5, 0,5,4, 0},
            {0, 4,5, 0,0,1, 1},
            {0, 4,5, 1,0,1, 1},

            {1, 2,1, 2,0,1, 1},
            {1, 4,5, 4,5,4, 1},
            {0, 4,5, 4,0,1, 0},
            {0, 4,5, 5,0,1, 0},
      };
      info = "a=b=c=e=f\n2B+F=360\nA+2C=360\nE+F=360\n(A+2D=F)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double f = getParam(paramValues, 0);
      double b = 180-f/2;
      double a = Functions.BisectionMethod(new Func(f), 60+(f-90)/3, 180, 0.0001);
      

      double x5 =      ln * Math.cos( a * DEG2RAD );
      double y5 =      ln * Math.sin( a * DEG2RAD );
      double x4 = x5 + ln * Math.cos( (a-180+f) * DEG2RAD );
      double y4 = y5 + ln * Math.sin( (a-180+f) * DEG2RAD );
      double x3 = x4 + x5;
      double y3 = y4 + y5;
      double x2 = ln + ln * Math.cos( (180-b) * DEG2RAD );
      double y2 =      ln * Math.sin( (180-b) * DEG2RAD );

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
      baseTile.setPoint(5, x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(2)-tiles[7].getX(0);
      offsets[3] = tiles[1].getY(2)-tiles[7].getY(0);
   }
   private class Func implements IFunction{
      private double f;
      Func(double f0){ f = f0; }
      public double calculate(double a) {
         double b = 180-f/2;
         double x = -1 + Math.cos(b*DEG2RAD);
         double y = Math.sin(b*DEG2RAD);
         x += 2*Math.cos((b-180+a)*DEG2RAD);
         y += 2*Math.sin((b-180+a)*DEG2RAD);
         x += Math.cos((b+a+f)*DEG2RAD);
         y += Math.sin((b+a+f)*DEG2RAD);
         double c = Math.atan2(y,-x)/DEG2RAD;
         return 2*c+a-360;
      }
      
   }   
}