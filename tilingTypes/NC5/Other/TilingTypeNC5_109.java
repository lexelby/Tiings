package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_109
   extends TilingType
   implements IFunction
{
   public TilingTypeNC5_109(){
      super( "NC5-109", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,3, 0,0,3, 0},
            {1, 0,1, 1,1,0, 0},
            {0, 0,3, 2,1,3, 0},

            {0, 3,2, 0,2,1, 1},
            {1, 1,3, 4,0,3, 1},
            {1, 0,1, 5,1,0, 1},
            {0, 0,3, 6,1,3, 1},
      };
      info = "d=e\na=c=2d\nA=D\nB=C\nC+E=360\n(2A+B=180)";
   }
   double a,b,d;
   protected void initialiseImpl(){
     double x = Functions.BisectionMethod(this, 25, 26, .0001);
     b = 60-2*x/3;
     d = 90-b/2-x;
     double y = (360-7*x)/3;
     a = 180-x-y;
   }
   public double calculate(double x) {
      double y = (360-7*x)/3;
      return 2*Math.sin(x*DEG2RAD)-Math.sin(y*DEG2RAD);
   }

   public void recalcBase(double[] paramValues) {
      final double ln = .4;
      
      final double x4 =      ln*2*Math.cos(d*DEG2RAD);
      final double y4 =      ln*2*Math.sin(d*DEG2RAD);
      final double x3 = x4 + ln*Math.cos((d+180-a)*DEG2RAD);
      final double y3 = y4 + ln*Math.sin((d+180-a)*DEG2RAD);
      final double x2 = x3 + ln*Math.cos((d-a+b)*DEG2RAD);
      final double y2 = y3 + ln*Math.sin((d-a+b)*DEG2RAD);
      final double x1 = x2 + ln*2*Math.cos((d-180+b)*DEG2RAD);
      final double y1 = y2 + ln*2*Math.sin((d-180+b)*DEG2RAD);
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[0].getX(1);
      offsets[1] = tiles[1].getY(4)-tiles[0].getY(1);
      offsets[2] = tiles[3].getX(2)-tiles[7].getX(3);
      offsets[3] = tiles[3].getY(2)-tiles[7].getY(3);
   }
}
