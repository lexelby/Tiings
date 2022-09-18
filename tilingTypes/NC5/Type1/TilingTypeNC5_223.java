package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_223
   extends TilingType
   implements IFunction
{
   private double a,d,e,f;
   public TilingTypeNC5_223(){
      super( "NC5-223", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {2, 1,0, 1,1,2, 0},
            {2, 2,1, 2,1,2, 0},
            {1, 1,2, 3,1,0, 0},
            {0, 0,1, 4,1,0, 0},

            {0, 3,0, 1,2,4, 1},
            {1, 1,0, 6,0,1, 1},
            {2, 1,0, 7,1,2, 1},
            {2, 2,1, 8,1,2, 1},
            {1, 1,2, 9,1,0, 1},
            {0, 0,1,10,1,0, 1},
      };
      info = "b=c\na=d=e\nB=C\nC+E=180\nD+E=360\n(A+B+C=180)";
   }
   public void initialiseImpl(){
      double b = Functions.BisectionMethod(this, 45, 50, 0.0001);
      a = 180 - 2*b;
      e = 180 - b;
      d = 360 - e;
      double y = 2 * Math.sin(a*DEG2RAD) + Math.sin((a+e-180)*DEG2RAD);
      f = y/Math.sin(b*DEG2RAD);
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .3;
      double ln2 = ln1 * f;

      double x4 =        ln1*Math.cos( a * DEG2RAD);
      double y4 =        ln1*Math.sin( a * DEG2RAD);
      double x3 = x4   + ln1*Math.cos( (a+e-180) * DEG2RAD);
      double y3 = y4   + ln1*Math.sin( (a+e-180) * DEG2RAD);
      double x2 = x3   + ln1*Math.cos( (a+e+d) * DEG2RAD);
      double y2 = y3   + ln1*Math.sin( (a+e+d) * DEG2RAD);

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln2,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[9].getX(4)-tiles[5].getX(2);
      offsets[1] = tiles[9].getY(4)-tiles[5].getY(2);
      offsets[2] = tiles[8].getX(4)-tiles[0].getX(2);
      offsets[3] = tiles[8].getY(4)-tiles[0].getY(2);
   }

   public double calculate(double angb){
      double anga = 180 - 2*angb;
      double ange = 180 - angb;
      double y = 2 * Math.sin(anga*DEG2RAD) + Math.sin((anga+ange-180)*DEG2RAD);
      double len2 = y/Math.sin(angb*DEG2RAD);
      double x = 2 * Math.cos(anga*DEG2RAD) + Math.cos((anga+ange-180)*DEG2RAD) + len2 * Math.cos(angb*DEG2RAD);
      return x - len2;
   }
}
