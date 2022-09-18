package tilingTypes.N5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_08b
   extends TilingType
   implements IFunction
{
   private double a,b,c,d,e;
   public TilingTypeN5_08b(){
      super( "N5-8b: type 2&8", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {3, 0,0, 0,0,0, 0},
            {0, 3,4, 0,2,3, 1},
            {2, 4,0, 1,4,0, 0},
            {1, 4,3, 2,2,3, 0},
            {3, 0,4, 0,4,0, 0},
            {0, 3,4, 4,2,3, 1},
            {2, 4,0, 5,4,0, 0},
            {1, 4,3, 6,2,3, 0},

            {0, 1,0, 0,1,2, 0},
            {3, 2,3, 8,3,4, 1},
            {2, 4,0, 8,4,0, 1},
            {1, 4,3,10,2,3, 1},
            {3, 0,4, 9,4,0, 1},
            {0, 3,4,12,2,3, 0},
            {2, 4,0,13,4,0, 1},
            {1, 4,3,14,2,3, 1},
      };
      info = "b=c=d=e\n2B+C=360\nD+2E=360\nB+D=180\n(2A+C+D=360)";
   }
   public void initialiseImpl(){
      e = Functions.BisectionMethod(this, 0, 90, .001);
      d = (180+2*e)/3;
      a = 180-d+e;
      b = 360-a-a;
      c = 360-d-d;
   }   


   public void recalcBase(double[] paramValues) {
      double ln = .6;

      double x2 = ln + ln*Math.cos( (-d+180) * DEG2RAD);
      double y2 =      ln*Math.sin( (-d+180) * DEG2RAD);
      double x3 = x2 + ln*Math.cos( (-d-c) * DEG2RAD);
      double y3 = y2 + ln*Math.sin( (-d-c) * DEG2RAD);
      double x4 = x3 + ln*Math.cos( (-d-c-b+180) * DEG2RAD);
      double y4 = y3 + ln*Math.sin( (-d-c-b+180) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[8].getX(3);
      offsets[1] = tiles[1].getY(0)-tiles[8].getY(3);
      offsets[2] = tiles[3].getX(1)-tiles[13].getX(2);
      offsets[3] = tiles[3].getY(1)-tiles[13].getY(2);
   }

   public double calculate(double e0){
      // ~A+D-E=180   ~2A+B=360   ~C+2D=360   ~3D-2E=180
      double d0 = (180+2*e0)/3;
      double a0 = 180-d0+e0;
      double b0 = 360-a0-a0;

      double dy1 = Math.sin( a0 * DEG2RAD) + Math.sin( (180+a0+b0) * DEG2RAD);
      double dy2 = Math.sin( e0 * DEG2RAD) + Math.sin( (180+e0+d0) * DEG2RAD);
      return dy1-dy2;
   }
}
