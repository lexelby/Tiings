package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeNC5_228
   extends TilingType
   implements IFunction
{
   private double b, f;
   public TilingTypeNC5_228(){
      super( "NC5-228", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {2, 0,1, 0,1,0, 0},
            {1, 1,0, 1,1,2, 0},
            {2, 0,2, 1,2,0, 0},
            {1, 1,0, 3,1,2, 0},
            {0, 1,0, 3,0,1, 0},

            {0, 2,3, 4,4,0, 1},
            {2, 0,1, 6,1,0, 1},
            {1, 1,0, 7,1,2, 1},
            {2, 0,2, 7,2,0, 1},
            {1, 1,0, 9,1,2, 1},
            {0, 1,0, 9,0,1, 1},
      };
      info = "a+b=2c\na=d=e\nB=C\nB=D\nD+E=360\n(A+B+C=180)";
   }
   public void initialiseImpl(){
      b = Functions.BisectionMethod(this, 80, 90, 0.0001);
      double diag = calcSide(1, 0.5, b);
      double r = calcAngle(diag, 1, 0.5);
      f = 2*diag * Math.sin((b-r)*DEG2RAD) / Math.sin(b*DEG2RAD);
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .5;
      double ln3 = ln1*f;

      double x4 =      ln1*Math.cos( (180-b-b) * DEG2RAD);
      double y4 =      ln1*Math.sin( (180-b-b) * DEG2RAD);
      double x3 = x4 + ln1*Math.cos( -3*b * DEG2RAD);
      double y3 = y4 + ln1*Math.sin( -3*b * DEG2RAD);
      double x2 = x3 + x4;
      double y2 = y3 + y4;

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, ln3,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[4].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[2].getX(4)-tiles[11].getX(2);
      offsets[3] = tiles[2].getY(4)-tiles[11].getY(2);
   }

   public double calculate(double angb){
      double diag = calcSide(1, 0.5, angb);
      double angr = calcAngle(diag, 1, 0.5);
      double lena = 2*diag * Math.sin((angb-angr)*DEG2RAD) / Math.sin(angb*DEG2RAD);
      double lenb = calcSide(lena, 2*diag, 180-angb*2+angr);
      return 2*lenb-lena-1;
   }
}
