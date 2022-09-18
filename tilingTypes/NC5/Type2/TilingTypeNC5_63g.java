package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.NC5.TilingTypeNC5_63;

public class TilingTypeNC5_63g
   extends TilingTypeNC5_63
{
   public TilingTypeNC5_63g(){
      super( "NC5-63g", 6, SymmetryType.cm );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 40, 25, 30};
      paramName = new String[]{ "Aspect", "Point X", "Point Y" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,4, 0,0,2, 1},
            {1, 0,4, 1,0,4, 0},
            {0, 2,4, 2,0,2, 1},
      };
      labels = new int[]{0,1,2,3,4,-1};
   }

   public void recalcBase(double[] paramValues) {
      super.recalcBase(paramValues);

      double lnb = baseTile.getPointY(4);
      baseTile.setPoint(5,  0, lnb/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(5)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(5)-tiles[0].getY(0);
   }
}
