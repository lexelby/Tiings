package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_01av
   extends TilingType
{
   public TilingTypeN5_01av(){
      super( "N5-1av", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 3,4, 0,3,4, 1},
            {0, 3,2, 1,2,3, 1},
            {1, 3,4, 2,3,4, 0},
            
            {1, 0,4, 1,0,1, 1},
            {0, 3,4, 4,3,4, 0},
            {0, 3,2, 5,2,3, 0},
            {1, 3,4, 6,3,4, 1},
      };
      info = "a=b\nc=a+d\nA=90\nB+C=180\nB+2E=360\n(D+E=270)";
   }
   
   private class Func implements IFunction
   {
      private double f;
      public Func(double f0){ f=f0; }
      public double calculate(double b) {
         double dx = f + (f+1)*Math.cos((180-b) * DEG2RAD) - (1-f); 
         double dy = (f+1)*Math.sin((180-b) * DEG2RAD) - f;
         double e = Math.atan2(dy,dx)/ DEG2RAD + 90;
         return  e+e+b-360;
      }
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = getParam(paramValues,0)/100.;
      double ln2 = 1 - ln1;
      double b = Functions.BisectionMethod(new Func(ln1), 90, 180, .0001);
      double ln3 = 2*ln1 + ln2;
      double dx = ln3 * Math.cos((180-b) * DEG2RAD);
      double dy = ln3 * Math.sin((180-b) * DEG2RAD);
      
      // scale
      double f = 2 / (dy + ln1+dx);
      dx *= f;
      dy *= f;
      ln1 *= f;
      ln2 *= f;

      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, ln1, 0);
      baseTile.setPoint(2, ln1+dx, dy);
      baseTile.setPoint(3, ln1+dx-ln2, dy);
      baseTile.setPoint(4,   0, ln1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(2);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(2);
      offsets[2] = tiles[3].getX(0)-tiles[6].getX(0);
      offsets[3] = tiles[3].getY(0)-tiles[6].getY(0);
   }
}
