package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_57f
   extends TilingType
{
   public TilingTypeN4_57f(){
      super( "N4-57f", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{ "Side ratio" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,2, 0,2,3, 0},
            {1, 1,0, 0,1,2, 0},
            {1, 1,0, 1,1,2, 0},

            {1, 2,3, 3,3,0, 1},
            {0, 1,2, 4,1,0, 1},
            {0, 3,2, 5,2,3, 1},
            {1, 1,0, 6,1,2, 1},
      };
      info = "b=a+c\nA=90\nB=90\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.25;
      double w = h;

      double h1 = h * getParam(paramValues,0)/100;
      double h2 = h - h1;

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2, w, h1);
      baseTile.setPoint(3, 0, h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(3)-tiles[3].getX(2);
      offsets[1] = tiles[4].getY(3)-tiles[3].getY(2);
      offsets[2] = tiles[2].getX(3)-tiles[7].getX(2);
      offsets[3] = tiles[2].getY(3)-tiles[7].getY(2);
   }
}
