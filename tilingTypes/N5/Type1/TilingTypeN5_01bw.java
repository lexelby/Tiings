package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bw
   extends TilingType
{
   public TilingTypeN5_01bw(){
      super( "N5-1bw: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 3,2, 0,1,2, 0},
            {2, 4,3, 1,3,4, 0},
            {2, 2,3, 2,3,2, 0},
            {0, 3,4, 3,4,3, 0},
            {1, 1,2, 4,3,2, 0},

            {1, 4,0, 0,2,3, 1},
            {0, 3,2, 6,1,2, 1},
            {2, 4,3, 7,3,4, 1},
            {2, 2,3, 8,3,2, 1},
            {0, 3,4, 9,4,3, 1},
            {1, 1,2,10,3,2, 1},
      };
      info = "a=c=d\nb+e=2a\nB=C\nC=D\nA+B=180\n(2B+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double c = 0.25;
      double s = Math.sqrt(1-c*c);
      double s2 = 2*c*s;
      double c2 = Math.sqrt(1-s2*s2);

      double lnd = .8;
      double lna = lnd/2;
      double lnbce = (lna+lnd)/2;

      baseTile.setPoint(0, 0,   0);
      baseTile.setPoint(1, lnd, 0);
      baseTile.setPoint(2, lnd+lnbce*c, lnbce*s);
      baseTile.setPoint(3, lnd+lnbce*c-lnbce*c2, lnbce*s+lnbce*s2);
      baseTile.setPoint(4, lnbce*c, lnbce*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[6].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[11].getX(3)-tiles[5].getX(0);
      offsets[3] = tiles[11].getY(3)-tiles[5].getY(0);
   }
}
