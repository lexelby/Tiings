package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_01al
   extends TilingType
{
   public TilingTypeN5_01al(){
      super( "N5-1al", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 60};
      paramName = new String[]{ "Relative Length" };
      
      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,1,0, 0},
            {1, 0,1, 1,1,0, 0},
            {0, 1,0, 2,4,0, 0},
            
            {0, 3,2, 0,0,4, 1},
            {1, 4,0, 4,1,0, 1},
            {1, 0,1, 5,1,0, 1},
            {0, 1,0, 6,4,0, 1},
      };
      info = "a=d=e\nb=a+c\nA+B=180\nA=E\n(C+D-B=180)";
   }
   
   private class Func implements IFunction{
      private double ln;
      public Func( double ln0 ){ln = ln0;}
      public double calculate(double a) {
         double x = (2-ln)*Math.cos(a*DEG2RAD)+Math.cos((a+a-180)*DEG2RAD) - ln;
         double y = (2-ln)*Math.sin(a*DEG2RAD)+Math.sin((a+a-180)*DEG2RAD);
         return x*x+y*y-1;
      }
   }

   public void recalcBase(double[] paramValues) {
      double f = paramValues[0]/100.;
      double ln3 = 1;
      double ln1 = ln3 * (1+f*f)/2;
      double ln2 = ln3 - ln1;
      
      double a = Functions.BisectionMethod(new Func(ln3/ln1), 90, 180, 0.0001);

      double x2 = ln3 + ln2 * Math.cos(a * DEG2RAD);
      double y2 =       ln2 * Math.sin(a * DEG2RAD);
      double x4 =       ln1 * Math.cos(a * DEG2RAD);
      double y4 =       ln1 * Math.sin(a * DEG2RAD);
      double x3 = x4 +  ln1 * Math.cos((a+a-180) * DEG2RAD);
      double y3 = y4 +  ln1 * Math.sin((a+a-180) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln3,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[4].getX(4);
      offsets[1] = tiles[0].getY(2)-tiles[4].getY(4);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(3);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(3);
   }
}
