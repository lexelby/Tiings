package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_15
   extends TilingType
{
   public TilingTypeN4_15(){
      super( "N4-15", 4, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,1, 0},
            {1, 0,1, 0,1,2, 1},
            {1, 0,1, 1,1,2, 1},

            {1, 2,3, 1,0,3, 0},
            {0, 1,2, 4,0,1, 1},
            {0, 1,0, 5,0,1, 1},
            {1, 0,1, 6,1,2, 0},
      };
      info = "c=2a=2d\nA=90\nD=90\n(B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double h = ln*(Math.sqrt(3)+1);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  h,  0);
      baseTile.setPoint(2, ln, ln);
      baseTile.setPoint(3,  0, ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(2);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(2);
      offsets[2] = tiles[7].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[7].getY(2)-tiles[0].getY(0);
   }
}
