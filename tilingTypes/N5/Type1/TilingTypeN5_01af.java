package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01af
   extends TilingType
{
   public TilingTypeN5_01af(){
      super( "N5-1af: type 1&2", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,2,3, 0},
            {0, 4,3, 0,3,4, 0},
            {1, 4,3, 2,2,3, 0},

            {0, 1,2, 3,0,1, 1},
            {1, 4,3, 4,2,3, 1},
            {0, 4,3, 4,3,4, 1},
            {1, 4,3, 6,2,3, 1},
      };
      info = "a=d=e\nb=a+c\nA=90\nB=135\nC=90\nD=135\n(E=90)";
   }

   public void recalcBase(double[] paramValues) {
      final double w = .5;
      final double v = w * Math.sqrt(2)/2;
      final double u = w-v;

      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, w+v-u,   0);
      baseTile.setPoint(2, w+v, w-v);
      baseTile.setPoint(3,   w,   w);
      baseTile.setPoint(4,   0,   w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(1);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(1);
      offsets[2] = tiles[6].getX(1)-tiles[1].getX(0);
      offsets[3] = tiles[6].getY(1)-tiles[1].getY(0);
   }
}
