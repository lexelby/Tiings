package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;
import tilings.Functions;
import tilings.IFunction;

public class TilingTypeN5_01ad
   extends TilingType
   implements IFunction
{
   double b, ln;
   public TilingTypeN5_01ad(){
      super( "N5-1ad: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,1,2, 1},
            {1, 4,0, 1,1,2, 0},
            {0, 1,2, 2,0,1, 1},

            {0, 4,3, 0,3,4, 0},
            {1, 0,1, 4,1,2, 1},
            {1, 4,0, 5,1,2, 0},
            {0, 1,2, 6,0,1, 1},
      };
      info = "b=c\na=d=e\nB=C\nC=D\nA+B=180\n(C+D+E=360)";
   }
   public void initialiseImpl(){
      b = Functions.BisectionMethod(this, 90, 180, .001);
      ln = Math.sin((270-b-b) * DEG2RAD) - Math.sin((b-90) * DEG2RAD);
   }   

   public void recalcBase(double[] paramValues) {
      double ln1 = .7;
      double ln2 = ln1 * ln;
      
      double x2 = ln1 + ln1 * Math.cos( (180-b) * DEG2RAD );
      double y2 =       ln1 * Math.sin( (180-b) * DEG2RAD );
      double x3 = x2  + ln2 * Math.cos( (-b-b) * DEG2RAD );
      double y3 = y2  + ln2 * Math.sin( (-b-b) * DEG2RAD );
      double x4 =       ln2 * Math.cos( (180-b) * DEG2RAD );
      double y4 =       ln2 * Math.sin( (180-b) * DEG2RAD );

      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, ln1,   0);
      baseTile.setPoint(2,  x2,  y2);
      baseTile.setPoint(3,  x3,  y3);
      baseTile.setPoint(4,  x4,  y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[5].getX(2);
      offsets[1] = tiles[3].getY(0)-tiles[5].getY(2);
      offsets[2] = tiles[2].getX(1)-tiles[1].getX(4);
      offsets[3] = tiles[2].getY(1)-tiles[1].getY(4);
   }

   public double calculate(double b0) {
      double an = 270-b0-b0;
      double dx = Math.cos(an * DEG2RAD) + Math.cos((b0-90) * DEG2RAD);
      double dy = Math.sin(an * DEG2RAD) - Math.sin((b0-90) * DEG2RAD);
      double diag = 2 * dy * Math.cos((b0-90)*DEG2RAD);
      return dx-diag;
   }
}
