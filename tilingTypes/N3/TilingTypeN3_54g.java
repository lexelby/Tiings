package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_54g
   extends TilingType
{
   public TilingTypeN3_54g(){
      super( "N3-54g", 3, SymmetryType.pgg );
      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 2,1, 0,2,1, 1},
            {2, 1,0, 1,1,0, 0},
            {2, 2,0, 1,2,0, 0},
            {0, 1,0, 3,1,0, 1},
            {1, 2,1, 4,2,1, 0},

            {1, 0,1, 3,1,2, 1},
            {0, 2,1, 6,2,1, 0},
            {2, 1,0, 7,1,0, 1},
            {2, 2,0, 7,2,0, 1},
            {0, 1,0, 9,1,0, 0},
            {1, 2,1,10,2,1, 1},
      };
      info = "A=90\nB=30\n(C=60)";
   }

   public void recalcBase(double[] paramValues) {
      double h = .5;
      double w = h*Math.sqrt(3);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(0)-tiles[6].getX(1);
      offsets[1] = tiles[5].getY(0)-tiles[6].getY(1);
      offsets[2] = tiles[0].getX(1)-tiles[11].getX(0);
      offsets[3] = tiles[0].getY(1)-tiles[11].getY(0);
   }
}
