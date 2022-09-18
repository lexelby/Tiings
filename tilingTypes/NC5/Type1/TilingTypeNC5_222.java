package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_222
   extends TilingType
   implements IFunction
{
   private double a,b,c;
   public TilingTypeNC5_222(){
      super( "NC5-222", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,0,1, 0},
            {2, 1,0, 1,0,1, 0},
            {2, 2,0, 2,0,2, 0},
            {1, 0,1, 3,1,0, 0},
            {0, 0,1, 4,2,1, 0},

            {0, 1,2, 0,4,0, 1},
            {1, 2,1, 6,0,1, 1},
            {2, 1,0, 7,0,1, 1},
            {2, 2,0, 8,0,2, 1},
            {1, 0,1, 9,1,0, 1},
            {0, 0,1,10,2,1, 1},
      };
      info = "b=2a\nc=d=e=a\nA+2B+E=360\nD+E=360\n(A+B+C=180)";
   }
   public void initialiseImpl(){
      b = Functions.BisectionMethod(this, 100, 110, 0.0001);
      a = 360 - 3*b;
      c = 180 - a - b;
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double x2 = 2*ln + ln*Math.cos( (180-b) * DEG2RAD);
      double y2 =        ln*Math.sin( (180-b) * DEG2RAD);
      double x3 = x2   + ln*Math.cos( (-b-c) * DEG2RAD);
      double y3 = y2   + ln*Math.sin( (-b-c) * DEG2RAD);
      double x4 = x2 - x3;
      double y4 = y2 - y3;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, 2*ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(4)-tiles[0].getX(1);
      offsets[1] = tiles[6].getY(4)-tiles[0].getY(1);
      offsets[2] = tiles[11].getX(2)-tiles[1].getX(3);
      offsets[3] = tiles[11].getY(2)-tiles[1].getY(3);
   }

   public double calculate(double angb){
      double h = calcSide(1, 2, angb);
      double anga = calcAngle(2,h,1); 
      return 2 * anga + 3*angb -360;
   }
}
