package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_57d
   extends TilingType
{
   public TilingTypeN3_57d(){
      super( "N3-57d", 4, SymmetryType.pgg );
      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 3,0, 0,2,3, 1},
            {2, 2,0, 1,2,0, 0},
            {2, 2,3, 2,3,2, 0},
            {0, 2,0, 3,2,0, 1},
            {1, 2,3, 4,3,0, 0},

            {1, 1,2, 0,0,1, 1},
            {0, 3,0, 6,2,3, 0},
            {2, 2,0, 7,2,0, 1},
            {2, 2,3, 8,3,2, 1},
            {0, 2,0, 9,2,0, 0},
            {1, 2,3,10,3,0, 1},
      };
      info = "A=90\nB=30\n(C=60)";
      labels = new int[]{0,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;
      double w = h*Math.sqrt(3);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w/2,  0);
      baseTile.setPoint(2,  w,  0);
      baseTile.setPoint(3,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(0)-tiles[11].getX(1);
      offsets[3] = tiles[5].getY(0)-tiles[11].getY(1);
   }
}
