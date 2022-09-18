package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_218
   extends TilingType
   implements IFunction
{
   private double b,c,d;
   public TilingTypeNC5_218(){
      super( "NC5-218", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,0, 0,1,3, 1},
            {2, 3,0, 1,1,3, 0},
            {2, 2,1, 2,1,2, 0},
            {1, 1,3, 3,3,0, 1},
            {0, 1,3, 4,3,0, 0},

            {0, 0,4, 4,0,1, 1},
            {1, 3,0, 6,1,3, 0},
            {2, 3,0, 7,1,3, 1},
            {2, 2,1, 8,1,2, 1},
            {1, 1,3, 9,3,0, 0},
            {0, 1,3,10,3,0, 1},
      };
      info = "a=b=c=d=e\nA+C=180\nC+E=360\n(A+B+D=180)";
   }
   public void initialiseImpl(){
      double r = Functions.BisectionMethod(this, 10, 30, 0.001);
      b = 4*r;
      c = 180-2*r;
      d = 180-6*r;
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double x2 = ln + ln*Math.cos( (180-b) * DEG2RAD);
      double y2 =      ln*Math.sin( (180-b) * DEG2RAD);
      double x3 = x2 + ln*Math.cos( (-b-c) * DEG2RAD);
      double y3 = y2 + ln*Math.sin( (-b-c) * DEG2RAD);
      double x4 = x3 + ln*Math.cos( (180-b-c-d) * DEG2RAD);
      double y4 = y3 + ln*Math.sin( (180-b-c-d) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[11].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[11].getY(3)-tiles[0].getY(0);
   }

   public double calculate(double r){
      return Math.cos(r*DEG2RAD) * Math.cos(3*r*DEG2RAD) - .25;
   }
}
