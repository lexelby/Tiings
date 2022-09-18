package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_170
   extends TilingType
{
   public TilingTypeNC5_170(){
      super( "NC5-170", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,0,1, 0},
            {1, 0,2, 1,2,0, 0},
            {0, 0,1, 2,2,1, 0},

            {0, 4,0, 0,2,3, 1},
            {1, 2,1, 4,0,1, 1},
            {1, 0,2, 5,2,0, 1},
            {0, 0,1, 6,2,1, 1},
      };
      info = "a=d\nb=c\nB=90\nC+E=180\nD+E=360\n(A+D=270)";
   }

   public void recalcBase(double[] paramValues) {
      double lnab = 0.8;
      double lnd =  lnab * getParam(paramValues,0)/100 * Math.sqrt(2);

      double ang = 2 * Math.atan2(lnd, 2*lnab+lnd);
      double dx = lnd / 2 * Math.cos(ang);
      double dy = lnd / 2 * Math.sin(ang);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnab, 0);
      baseTile.setPoint(2,  lnab, lnab);
      baseTile.setPoint(3,  lnab/2 + dx, lnab/2 + dy);
      baseTile.setPoint(4,  lnab/2 - dx, lnab/2 - dy);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[4].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(2)-tiles[3].getX(4);
      offsets[3] = tiles[7].getY(2)-tiles[3].getY(4);
   }
}
