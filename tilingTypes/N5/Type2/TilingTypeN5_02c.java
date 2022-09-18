package tilingTypes.N5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_02c
   extends TilingType
   implements IFunction
{
   private double a,b,c,d,e;
   public TilingTypeN5_02c(){
      super( "N5-2c", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,3,4, 0},
            {0, 3,2, 0,2,3, 0},
            {1, 3,4, 1,1,2, 1},
            
            {1, 2,3, 0,0,1, 1},
            {1, 3,4, 4,1,2, 0},
            {0, 2,1, 4,0,1, 1},
            {0, 4,3, 4,4,0, 1},
      };
      info = "a=b=c=d=e\nB+E=180\nD=2E\n(A+C+D=360)";
   }
   public void initialiseImpl(){
      e = Functions.BisectionMethod(this, 0, 180, 0.001);
      b = 180-e;
      d = e*2;
      double diag1 = 2*Math.sin(e/2 * DEG2RAD);
      double diag2 = 2*Math.sin(b/2 * DEG2RAD);
      double x = calcAngle(diag1,diag2,1);
      a = x + 90;
      c = 540-a-b-d-e;
   }   

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double x2 = ln + ln*Math.cos( (180+b) * DEG2RAD);
      double y2 =    - ln*Math.sin( (180+b) * DEG2RAD);
      double x3 = x2 + ln*Math.cos( (b+c) * DEG2RAD);
      double y3 = y2 - ln*Math.sin( (b+c) * DEG2RAD);
      double x4 = x3 + ln*Math.cos( (180+b+c+d) * DEG2RAD);
      double y4 = y3 - ln*Math.sin( (180+b+c+d) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[2].getX(4);
      offsets[1] = tiles[0].getY(0)-tiles[2].getY(4);
      offsets[2] = tiles[6].getX(3)-tiles[3].getX(0);
      offsets[3] = tiles[6].getY(3)-tiles[3].getY(0);
   }

   public double calculate(double e0){
      double b0 = 180-e0;
      double d0 = e0*2;
      double x = 1 - Math.cos(d0*DEG2RAD) - Math.cos(e0*DEG2RAD);
      double y =     Math.sin(d0*DEG2RAD) - Math.sin(e0*DEG2RAD);
      double ln1 =x*x+y*y;
      x = 1 - Math.cos(b0*DEG2RAD);
      y =     Math.sin(b0*DEG2RAD);
      double ln2 =x*x+y*y;
      return ln1-ln2;
   }
}
