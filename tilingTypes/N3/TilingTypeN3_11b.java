package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_11b
   extends TilingType
{
   public TilingTypeN3_11b(){
      super( "N3-11b", 3, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,2, 0,0,2, 1},
            {1, 2,1, 1,1,2, 1},
            {0, 0,2, 2,0,2, 0},

            {0, 1,0, 0,2,1, 1},
            {1, 0,2, 4,0,2, 0},
            {1, 2,1, 5,1,2, 0},
            {0, 0,2, 6,0,2, 1},
      };
      info = "A=90\n(B+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 1.5 * paramValues[0]/100.;
      double w = 1.5-h;
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(2)-tiles[0].getX(1);
      offsets[1] = tiles[4].getY(2)-tiles[0].getY(1);
      offsets[2] = tiles[7].getX(2)-tiles[3].getX(1);
      offsets[3] = tiles[7].getY(2)-tiles[3].getY(1);
   }
}
