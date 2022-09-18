package tilingTypes.N5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_02f
   extends TilingType
{
   public TilingTypeN5_02f(){
      super( "N5-2f", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,1, 1},
            {1, 4,0, 1,2,1, 1},
            {0, 0,1, 2,0,1, 0},

            {1, 3,2, 0,2,3, 0},
            {0, 0,1, 4,0,1, 1},
            {1, 4,0, 5,2,1, 1},
            {0, 0,1, 6,0,1, 0},
      };
      info = "2a=c=e\nC+E=180\n2B+E=360\nA=90\n(B+D=270)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 1.5 * getParam(paramValues, 0) / 100.;
      double ln2 = 1.5 - ln1;
      double a = Functions.BisectionMethod(new Func(ln2/ln1), 90, 119.999, 0.0001);
      double b = 90+a/2;
      double c = 180-a;

      double y4 = ln1/2;
      double x3 =      ln1*Math.cos( (a-90) * DEG2RAD);
      double y3 = y4 + ln1*Math.sin( (a-90) * DEG2RAD);
      double x2 = x3 + ln2*Math.cos( (a+90+b) * DEG2RAD);
      double y2 = y3 + ln2*Math.sin( (a+90+b) * DEG2RAD);
      double x1 = x2 + ln1*Math.cos( (a-90+b+c) * DEG2RAD);
      double y1 = y2 + ln1*Math.sin( (a-90+b+c) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4,  0, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(2)-tiles[1].getX(3);
      offsets[1] = tiles[2].getY(2)-tiles[1].getY(3);
      offsets[2] = tiles[2].getX(3)-tiles[5].getX(3);
      offsets[3] = tiles[2].getY(3)-tiles[5].getY(3);
   }

   private class Func
      implements IFunction
   {
      double ln;
      public Func(double ln0){ ln = ln0; }
      public double calculate(double a){
         double b = 90+a/2;
         double c = 180-a;
         double dy = .5 + Math.sin((a-90)*DEG2RAD) + ln * Math.sin((a-90+b-180)*DEG2RAD) + Math.sin((a-90+b+c)*DEG2RAD);
         return dy;
      }
   }
}
