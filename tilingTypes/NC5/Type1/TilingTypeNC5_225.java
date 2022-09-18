package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_225
   extends TilingType
   implements IFunction
{
   private double b;
   public TilingTypeNC5_225(){
      super( "NC5-225", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {2, 1,2, 0,1,0, 0},
            {1, 1,0, 1,0,1, 0},
            {2, 0,2, 1,2,0, 0},
            {1, 1,0, 3,0,1, 0},
            {0, 1,0, 3,1,2, 0},

            {0, 3,4, 4,2,3, 1},
            {2, 1,2, 6,1,0, 1},
            {1, 1,0, 7,0,1, 1},
            {2, 0,2, 7,2,0, 1},
            {1, 1,0, 9,0,1, 1},
            {0, 1,0, 9,1,2, 1},
      };
      info = "a+b=2c\na=d=e\nB=C\nB=E\nD+E=360\n(A+B+C=180)";
   }
   public void initialiseImpl(){
      b = Functions.BisectionMethod(this, 50, 55, 0.0001);
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      
      double x4 =      ln*Math.cos( (180-b-b) * DEG2RAD);
      double y4 =      ln*Math.sin( (180-b-b) * DEG2RAD);
      double x3 = x4 + ln*Math.cos( -b * DEG2RAD);
      double y3 = y4 + ln*Math.sin( -b * DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln*2,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[4].getX(4);
      offsets[1] = tiles[0].getY(2)-tiles[4].getY(4);
      offsets[2] = tiles[2].getX(2)-tiles[11].getX(3);
      offsets[3] = tiles[2].getY(2)-tiles[11].getY(3);
   }

   public double calculate(double angb){
      return Math.cos(angb/2*DEG2RAD) - 4* Math.cos(3*angb/2*DEG2RAD);
   }
}
