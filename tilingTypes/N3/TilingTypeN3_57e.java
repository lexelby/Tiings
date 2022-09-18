package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_57e
   extends TilingType
{
   public TilingTypeN3_57e(){
      super( "N3-57e", 4, SymmetryType.pgg );
      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 3,0, 0,1,3, 1},
            {2, 1,0, 1,1,0, 0},
            {2, 1,3, 2,3,1, 0},
            {0, 1,0, 3,1,0, 1},
            {1, 1,3, 4,3,0, 0},

            {1, 0,3, 4,2,3, 1},
            {0, 3,0, 6,1,3, 0},
            {2, 1,0, 7,1,0, 1},
            {2, 1,3, 8,3,1, 1},
            {0, 1,0, 9,1,0, 0},
            {1, 1,3,10,3,0, 1},
      };
      info = "A=90\nB=30\n(C=60)";
      labels = new int[]{0,1,-1,2};
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;
      double w = h*Math.sqrt(3);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  w*3/4,  h/4);
      baseTile.setPoint(3,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(0)-tiles[7].getX(2);
      offsets[1] = tiles[5].getY(0)-tiles[7].getY(2);
      offsets[2] = tiles[5].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[5].getY(1)-tiles[0].getY(0);
   }
}
