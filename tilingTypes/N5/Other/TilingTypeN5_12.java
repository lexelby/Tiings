package tilingTypes.N5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_12
   extends TilingType
{
   public TilingTypeN5_12(){
      super( "N5-12: Marjorie Rice, 1976", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{349};
      paramDef = new int[]{120};
      paramName = new String[]{ "Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,1,2, 1},
            {1, 2,1, 1,1,2, 1},
            {0, 1,2, 2,2,3, 0},

            {0, 4,0, 0,2,3, 1},
            {1, 2,3, 4,1,2, 0},
            {1, 2,1, 5,1,2, 0},
            {0, 1,2, 6,2,3, 1},
      };
      info = "2a=d=c+e\nA=90\n2B+C=360\nC+E=180\n(2D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double lnb = ln*paramValues[0]/100; // side b
      double c = Functions.BisectionMethod(new Func(lnb/ln), 0, 180, 0.001);

      // get angles
      //double e = 180-c;
      //double b=90-c/2;
      double d=90+c/2;

      // get all the lengths
      // lne * cos(e-90)+lne*cos(c/2) = b
      double lne = lnb / ( Math.sin(c*DEG2RAD) + Math.cos(c/2 *DEG2RAD) );
      double lnc = 2*ln-lne;

      double x3 =      lne * Math.cos( (90-c) * DEG2RAD);
      double y3 = ln + lne * Math.sin( (90-c) * DEG2RAD);
      double x2 = x3 + 2*ln * Math.cos( (270-c+d) * DEG2RAD);
      double y2 = y3 + 2*ln * Math.sin( (270-c+d) * DEG2RAD);
      double x1 = x2 + lnc * Math.cos( (90+d) * DEG2RAD);
      double y1 = y2 + lnc * Math.sin( (90+d) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4,  0, ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[4].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(3)-tiles[6].getX(3);
      offsets[3] = tiles[3].getY(3)-tiles[6].getY(3);
   }

   private class Func implements IFunction{
      private double lnb;
      public Func(double lnb0){ lnb=lnb0; }
      public double calculate(double c){
         // get angles
         double e = 180-c;
         //double b=90-c/2;
         //double d=90+c/2;

         // get all the lengths
         // lne * cos(e-90)+lne*cos(c/2) = lnb
         double lne = lnb / ( Math.cos((e-90)*DEG2RAD) + Math.cos(c/2 *DEG2RAD) );
         double lnd = 2;
         double lnc = lnd-lne;

         // get vertical offset
         double t = 1 + lne *Math.sin((e-90)*DEG2RAD) - (lnd+lnc)*Math.sin(c/2 *DEG2RAD);

         return t;
      }
   }
}
