package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_74
   extends TilingType
{
   public TilingTypeNC5_74(){
      super( "NC5-74", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 73};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 1,2, 0,1,2, 1},
            {1, 3,2, 1,0,1, 1},
            {0, 1,2, 2,1,2, 0},
            
            {1, 1,0, 0,0,1, 0},
            {0, 1,2, 4,1,2, 1},
            {1, 3,2, 5,0,1, 1},
            {0, 1,2, 6,1,2, 0},
      };
      info = "a=e\na+b=2d\nA+D=360\nC=90\nA=2E\n(A+2B=180)";
   }
   
   private class Func implements IFunction{
      double ln;
      public Func(double ln0){ ln = ln0; }
      public double calculate(double d) {
         double e = 360-d-d;
         double c = d+d;
         double b = 90-d;
         double dx1 = (2*ln-1)*Math.sin(b*DEG2RAD) + Math.sin((b+c-180)*DEG2RAD);
         double dx2 = ln + Math.sin((e-90)*DEG2RAD);
         return dx1-dx2;
      }
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = getParam(paramValues,0)/100. / (1+Math.sqrt(5));
      double ln2 = 1-ln1;
      double d = Functions.BisectionMethod(new Func(ln2/ln1), 30, 70, 0.001);
      double e = 360-d-d;
      double c = d+d;
      
      double x4 = ln1 * Math.cos(c*DEG2RAD);
      double y4 = ln1 * Math.sin(c*DEG2RAD);
      double x3 = x4 + ln1 * Math.cos((c+d-180)*DEG2RAD);
      double y3 = y4 + ln1 * Math.sin((c+d-180)*DEG2RAD);
      double x2 = x3 + ln2 * Math.cos((c+d+e)*DEG2RAD);
      double y2 = y3 + ln2 * Math.sin((c+d+e)*DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln2*2-ln1, 0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(3);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(3);
      offsets[2] = tiles[1].getX(3)-tiles[5].getX(4);
      offsets[3] = tiles[1].getY(3)-tiles[5].getY(4);
   }
}
