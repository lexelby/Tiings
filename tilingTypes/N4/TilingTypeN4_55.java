package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_55
   extends TilingType
{
   public TilingTypeN4_55(){
      super( "N4-55", 4, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 35};
      paramName = new String[]{ "Aspect", "Side ratio" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 3,2, 1,2,3, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 2,1, 0,3,2, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 3,2, 5,2,3, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "A=90\nB=90\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 2.5 * getParam(paramValues,0)/100;
      double w = 2.5 - h;

      double h1 = h * getParam(paramValues,1)/100;
      double h2 = h - h1;

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2, w, h1);
      baseTile.setPoint(3, 0, h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(3)-tiles[0].getX(2);
      offsets[1] = tiles[4].getY(3)-tiles[0].getY(2);
      offsets[2] = tiles[3].getX(3)-tiles[7].getX(2);
      offsets[3] = tiles[3].getY(3)-tiles[7].getY(2);
   }
}
