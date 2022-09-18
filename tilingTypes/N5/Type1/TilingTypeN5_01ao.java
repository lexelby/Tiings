package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ao
   extends TilingType
{
   public TilingTypeN5_01ao(){
      super( "N5-1ao", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{151};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,4, 1},
            {1, 1,0, 1,2,1, 0},
            {0, 1,0, 2,0,4, 1},

            {1, 4,3, 1,4,0, 1},
            {0, 1,0, 4,0,4, 0},
            {1, 1,0, 5,2,1, 1},
            {0, 1,0, 6,0,4, 0},
      };
      info = "a=b=2e\nD=90\nA+2E=360\nA+B=180\n(C+E=270)";
   }

   public void recalcBase(double[] paramValues) {
      double a = paramValues[0];
      double lna = .9;
      double lnb = lna * .5 / Math.cos(a/2*DEG2RAD);

      double x2 = lna + lnb * Math.cos(a * DEG2RAD);      
      double y2 =       lnb * Math.sin(a * DEG2RAD);
      double x4 =       lna * Math.cos(a * DEG2RAD);      
      double y4 =       lna * Math.sin(a * DEG2RAD);
      double x3 = x4 +  lna/2 * Math.cos(a/2 * DEG2RAD);      
      double y3 = y4 +  lna/2 * Math.sin(a/2 * DEG2RAD);
      
      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, lna,   0);
      baseTile.setPoint(2,  x2,  y2);
      baseTile.setPoint(3,  x3,  y3);
      baseTile.setPoint(4,  x4,  y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[2].getX(2);
      offsets[1] = tiles[0].getY(1)-tiles[2].getY(2);
      offsets[2] = tiles[7].getX(4)-tiles[2].getX(4);
      offsets[3] = tiles[7].getY(4)-tiles[2].getY(4);
   }
}
