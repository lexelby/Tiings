package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_01am2
   extends TilingType
{
   public TilingTypeN5_01am2(){
      super( "N5-1am2: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 80};
      paramName = new String[]{ "Relative Length" };
      
      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,2,3, 0},
            {1, 2,3, 1,4,0, 1},
            {0, 2,3, 2,1,0, 1},

            {0, 1,0, 0,0,1, 0},
            {1, 1,0, 4,2,3, 0},
            {1, 2,3, 5,4,0, 1},
            {0, 2,3, 6,1,0, 1},
      };
      info = "a=d=b+c\nc=e\nA+B=180\nB=D\n(C+D+E=360)\n(E=120)";
   }
   
   private class Func implements IFunction{
      private double f;
      public Func( double f0 ){f = f0;}
      public double calculate(double c) {
         double d1 = calcSide(f,f,c);
         double d2 = calcSide(1,1-f,180-c);
         return d1-d2;
      }
   }

   public void recalcBase(double[] paramValues) {
      double f = getParam(paramValues,0)/100.;
      double c = Functions.BisectionMethod(new Func(f), 60, 180, 0.0001);
      double ln3 = 1;
      double ln2 = ln3 * f;
      double ln1 = ln3 - ln2;
      

      double x2 = ln2 + ln1 * Math.cos(c * DEG2RAD);
      double y2 =       ln1 * Math.sin(c * DEG2RAD);
      double x4 =       ln3 * Math.cos(c * DEG2RAD);
      double y4 =       ln3 * Math.sin(c * DEG2RAD);
      double x3 = x4 +  ln1 * Math.cos((c-60) * DEG2RAD);
      double y3 = y4 +  ln1 * Math.sin((c-60) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln2,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[2].getX(4);
      offsets[1] = tiles[1].getY(2)-tiles[2].getY(4);
      offsets[2] = tiles[7].getX(1)-tiles[3].getX(0);
      offsets[3] = tiles[7].getY(1)-tiles[3].getY(0);
   }
}
