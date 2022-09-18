package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_49d
   extends TilingType
{
   public TilingTypeN4_49d(){
      super( "N4-49d: g split rectangle", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 60, 66};
      paramName = new String[]{ "Aspect", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 4,2, 0,2,4, 0},
            {1, 0,1, 2,0,1, 1},

            {1, 2,3, 1,3,4, 0},
            {0, 0,1, 4,0,1, 1},
            {0, 4,2, 5,2,4, 1},
            {1, 0,1, 6,0,1, 0},
      };
      info = "A=90\nB=90\n(C+D=180)";
      labels = new int[]{0,1,2,-1,3};
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.5 * getParam(paramValues,0)/100.;  // base
      double h = 2 * (1.5 - w);
      double h1 = h * getParam(paramValues,1)/100.;  // side1
      double h2 = h - h1;  // side2

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, w, 0);
      baseTile.setPoint(2, w, h2);
      baseTile.setPoint(3, w/2, h/2);
      baseTile.setPoint(4, 0, h1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[1].getX(4);
      offsets[1] = tiles[1].getY(2)-tiles[1].getY(4);
      offsets[2] = tiles[3].getX(3)-tiles[7].getX(4);
      offsets[3] = tiles[3].getY(3)-tiles[7].getY(4);
   }
}
