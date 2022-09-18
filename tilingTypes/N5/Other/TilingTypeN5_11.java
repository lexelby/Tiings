package tilingTypes.N5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_11
   extends TilingType
{
   public TilingTypeN5_11(){
      super( "N5-11: Marjorie Rice, 1976", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Tip Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 4,3, 0,2,3, 0},
            {0, 0,1, 2,0,1, 1},

            {0, 4,3, 3,3,4, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 4,3, 4,2,3, 1},
            {0, 0,1, 6,0,1, 0},
      };
      info = "2a+c=d=e\nA=90\n2B+C=360\nC+E=180\n(2D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double f = paramValues[0]/100.;
      double e = Functions.BisectionMethod(new Func(f), 98, 140, 0.001);
      double ln = .75;
      double c = 180-e;
      double b = 180-c/2;
      double d = 270-b;

      // calculate shortest side
      double t = Math.sin((270+e)*DEG2RAD ) + Math.sin( (90+e+d)*DEG2RAD );
      double u = Math.sin( (270+e+d+c)*DEG2RAD );
      //  lnd*t + lna + lnc*u = 0,   lnd = lnc + 2 lna
      //  lnd*t + lna + (lnd - 2 lna)*u = 0
      double lna = -ln*(t + u) / (1-2*u);
      double lnc = ln-2*lna;

      double x3 =       ln * Math.cos( (270+e) * DEG2RAD);
      double y3 = lna+  ln * Math.sin( (270+e) * DEG2RAD);
      double x2 = x3 +  ln * Math.cos( (90+e+d) * DEG2RAD);
      double y2 = y3 +  ln * Math.sin( (90+e+d) * DEG2RAD);
      double x1 = x2 + lnc * Math.cos( (270+e+d+c) * DEG2RAD);
      double y1 = y2 + lnc * Math.sin( (270+e+d+c) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4,  0,lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(3)-tiles[0].getX(4);
      offsets[1] = tiles[7].getY(3)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(3)-tiles[1].getX(3);
      offsets[3] = tiles[3].getY(3)-tiles[1].getY(3);
   }

   private class Func implements IFunction{
      private double lnc;
      public Func(double lnc0){ lnc=lnc0; }
      public double calculate(double e){
         double lnd = 1;  // long sides d and e
         double c = 180-e;
         double b = 180-c/2;
         double d = 270-b;
         // calculate shortest side
         double t = Math.sin((270+e)*DEG2RAD ) + Math.sin( (90+e+d)*DEG2RAD );
         double u = Math.sin( (270+e+d+c)*DEG2RAD );
         //  lnd*t + lna + lnc*u = 0,   lnd = lnc + 2 lna
         //  lnd*t + lna + (lnd - 2 lna)*u = 0
         double lna = -lnd*(t + u) / (1-2*u);
         return lnc - (lnd-2*lna);
      }
   }
}
