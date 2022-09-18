package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.NC5.TilingTypeNC5_43;

public class TilingTypeNC5_43b
   extends TilingTypeNC5_43
{
   public TilingTypeNC5_43b(){
      super( "NC5-43b: Split paralellogram", SymmetryType.pmg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{180,100,100,100};
      paramDef = new int[]{ 70, 40, 60, 60};
      paramName = new String[]{ "Angle", "Relative length", "X", "Y" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 6,3, 0,3,6, 0},

            {0, 0,3, 0,0,3, 1},
            {0, 6,3, 2,3,6, 1},
      };
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(0)-tiles[3].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[3].getY(0);
   }
}
