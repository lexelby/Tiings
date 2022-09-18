package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_49b
   extends TilingType
{
   public TilingTypeN4_49b(){
      super( "N4-49b: m split rectangle", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 60, 66, 50};
      paramName = new String[]{ "Aspect", "Relative Length", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {1, 0,1, 0,0,1, 1},
            {0, 3,2, 2,2,3, 1},

            {0, 4,0, 0,0,4, 0},
            {1, 3,2, 4,2,3, 0},
            {1, 0,1, 4,0,1, 1},
            {0, 3,2, 6,2,3, 1},
      };
      info = "A=90\nB=90\n(C+D=180)";
      labels = new int[]{0,1,2,3,-1};
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.5 * getParam(paramValues,0)/100.;  // base
      double h = 2 * (1.5 - w);
      double h1 = h * getParam(paramValues,1)/100.;  // side1
      double h2 = h - h1;  // side2
      double os = 2 * h * getParam(paramValues,2)/100.;  // side1

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, w, 0);
      baseTile.setPoint(2, w, h2);
      baseTile.setPoint(3, 0, h1);
      baseTile.setPoint(4, 0, os);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[3].getX(1);
      offsets[1] = tiles[1].getY(1)-tiles[3].getY(1);
      offsets[2] = tiles[7].getX(4)-tiles[3].getX(0);
      offsets[3] = tiles[7].getY(4)-tiles[3].getY(0);
   }
}
