package tilingTypes.N5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_02d
   extends TilingType
   implements IFunction
{
   private double e,b,c,d;

   public TilingTypeN5_02d(){
      super( "N5-2d: Marjorie Rice [fudged]", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,1,2, 0},
            {2, 3,2, 0,3,4, 0},
            {2, 4,3, 2,3,4, 0},
            {0, 3,4, 3,3,2, 0},
            {1, 4,3, 4,1,2, 0},
      };
      info = "a=b=c=d=e\nB+E=180\n2D+E=360\nC=90\n(A+D=270)\n\nImpossible";
   }
   public void initialiseImpl(){
      e = Functions.BisectionMethod(this, 0, 180, 0.001);
      b = 180-e;
      c = 180-b/2;
      d = 90;
   }   

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double x2 = ln + ln*Math.cos( (180-e) * DEG2RAD);
      double y2 =      ln*Math.sin( (180-e) * DEG2RAD);
      double x3 = x2 + ln*Math.cos( (-e-d) * DEG2RAD);
      double y3 = y2 + ln*Math.sin( (-e-d) * DEG2RAD);
      double x4 = x3 + ln*Math.cos( (180-e-d-c) * DEG2RAD);
      double y4 = y3 + ln*Math.sin( (180-e-d-c) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[4].getX(1)-tiles[0].getX(1);
      offsets[3] = tiles[4].getY(1)-tiles[0].getY(1);
   }


   public double calculate(double e0){
      double y1 = Math.sin( e0 * DEG2RAD) + Math.sin( (-e0-90) * DEG2RAD);
      double y5 = Math.sin( e0/2 * DEG2RAD) + Math.sin( e0*3/2 * DEG2RAD);

      return y1-y5;
   }
}
