package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_64
   extends TilingType
{
   public TilingTypeNC5_64(){
      super( "NC5-64", 5, SymmetryType.pg );

      paramMin = new int[]{   0};
      paramMax = new int[]{ 100};
      paramDef = new int[]{  68};
      paramName = new String[]{ "Aspect"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,2, 0,2,4, 1},
            {0, 1,0, 1,2,3, 1},
            {1, 0,2, 2,2,4, 0},
      };
      info = "a=b=d\nc=e\nB+D=360\nA+D=180\n(A+C+E=180)";
   }

   private class Func implements IFunction{
      private double ln, an;
      public Func(double ln0, double an0) { ln = ln0; an = an0; }
      public double calculate(double x) {
         double ln2 = calcSide(ln, 1, x);
         double y = calcAngle(ln2, 1, ln);
         return x+x+y-an;
      }
   }
   public void recalcBase(double[] paramValues) {
      double h = 2 * getParam( paramValues,0)/100.;
      double w = 2-h + Math.sqrt(3);
      h *= .6;
      w *= .6;
      double ln = Math.sqrt(h*h/4+w*w);
      double r = Math.atan2(w, h/2)/DEG2RAD;
      double x = Functions.BisectionMethod(new Func(h/ln,r), 0.00001, 90, 0.001);

      double dx = h * Math.cos((90-r+x) * DEG2RAD);
      double dy = h * Math.sin((90-r+x) * DEG2RAD);
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, dx, dy);
      baseTile.setPoint(2,  w, h/2);
      baseTile.setPoint(3, w-dx, h/2+dy);
      baseTile.setPoint(4,  0,   h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[3].getX(0);
      offsets[1] = tiles[1].getY(4)-tiles[3].getY(0);
      offsets[2] = tiles[3].getX(2)-tiles[0].getX(1);
      offsets[3] = tiles[3].getY(2)-tiles[0].getY(1);
   }
}
