package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_49c
   extends TilingType
{
   public TilingTypeN4_49c(){
      super( "N4-49c: m split rectangle", 4, SymmetryType.pmg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 60, 66};
      paramName = new String[]{ "Aspect", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 3,2, 0,2,3, 0},
            {1, 0,1, 2,0,1, 1},

            {1, 2,3, 1,2,3, 0},
            {0, 0,1, 4,0,1, 1},
            {0, 3,2, 5,2,3, 1},
            {1, 0,1, 6,0,1, 0},
      };
      info = "A=90\nB=90\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.5 * getParam(paramValues,0)/100.;  // base
      double h = 2 * (1.5 - w);
      double h1 = h * getParam(paramValues,1)/100.;  // side1
      double h2 = h - h1;  // side2

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, w, 0);
      baseTile.setPoint(2, w, h2);
      baseTile.setPoint(3, 0, h1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[1].getX(3);
      offsets[1] = tiles[1].getY(2)-tiles[1].getY(3);
      offsets[2] = tiles[3].getX(3)-tiles[7].getX(3);
      offsets[3] = tiles[3].getY(3)-tiles[7].getY(3);
   }
}
