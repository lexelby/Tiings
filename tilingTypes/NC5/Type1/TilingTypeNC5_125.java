package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_125
   extends TilingType
{
   public TilingTypeNC5_125(){
      super( "NC5-125", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,4, 1},
            {1, 4,0, 0,3,4, 1},
            {0, 0,4, 2,1,0, 0},

            {0, 2,1, 0,1,0, 1},
            {1, 1,0, 4,0,4, 0},
            {1, 4,0, 4,3,4, 0},
            {0, 0,4, 6,1,0, 1},
      };
      info = "a=b\nd=e\nc=a+e\nD+E=360\nA+E=180\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;
      double lnbase = lntotal * getParam(paramValues, 0)/200;
      double lnb = lntotal - lnbase;
      double lnc = (lnb-lnbase)/2;
      double lna = lnbase + lnc;
      double lnh = Math.sqrt(lnb*lnb-lnbase*lnbase/4);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, lna-lnbase/2, lnh);
      baseTile.setPoint(3, lnbase/2*lna/lnb + lnc, lnh*lna/lnb);
      baseTile.setPoint(4, lnbase/2*lna/lnb, lnh*lna/lnb);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[4].getX(1);
      offsets[1] = tiles[0].getY(2)-tiles[4].getY(1);
      offsets[2] = tiles[7].getX(2)-tiles[3].getX(1);
      offsets[3] = tiles[7].getY(2)-tiles[3].getY(1);
   }
}
