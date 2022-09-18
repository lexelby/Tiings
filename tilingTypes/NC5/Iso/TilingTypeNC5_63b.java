package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.NC5.TilingTypeNC5_63;

public class TilingTypeNC5_63b
   extends TilingTypeNC5_63
{
   public TilingTypeNC5_63b(){
      super( "NC5-63b", 5, SymmetryType.pg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 40, 25, 30};
      paramName = new String[]{ "Aspect", "Point X", "Point Y" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,4, 0,0,2, 1},
      };
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = (tiles[1].getX(0)+tiles[1].getX(4))/2-tiles[0].getX(0);
      offsets[1] = (tiles[1].getY(0)+tiles[1].getY(4))/2-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(4)-tiles[0].getY(0);
   }
}
