package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_121
   extends TilingType
{
   public TilingTypeNC5_121(){
      super( "NC5-121", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 65};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,4,0, 1},
            {1, 4,3, 1,3,4, 1},
            {0, 4,0, 2,0,1, 0},

            {0, 3,4, 1,0,4, 1},
            {1, 0,1, 4,4,0, 0},
            {1, 4,3, 5,3,4, 0},
            {0, 4,0, 6,0,1, 1},
      };
      info = "c=d\na=b=d+e\nB+C=360\nA+B=180\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.1;

      double lnbc = lntotal * getParam(paramValues, 0)/400;
      double lnae = lntotal - lnbc;
      double lnd = lnae - lnbc;

      double c = (lnd/2 + lnbc)/lnd;
      double s = Math.sqrt(1-c*c);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, lnae, 0);
      baseTile.setPoint(2, lnae+lnbc*c, lnbc*s);
      baseTile.setPoint(3, lnae+lnbc*(c+1), lnbc*s);
      baseTile.setPoint(4, lnae*c, lnae*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[4].getX(4);
      offsets[1] = tiles[0].getY(3)-tiles[4].getY(4);
      offsets[2] = tiles[7].getX(3)-tiles[2].getX(0);
      offsets[3] = tiles[7].getY(3)-tiles[2].getY(0);
   }
}
