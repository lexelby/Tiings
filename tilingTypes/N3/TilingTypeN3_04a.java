package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_04a
   extends TilingType
{
   public TilingTypeN3_04a(){
      super( "N3-4a", 3, SymmetryType.cm );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,1,2, 1},
            {1, 0,1, 0,0,2, 0},
            {0, 1,2, 2,1,2, 1},
      };
      info = "c=2b\nA=60\nB=90\n(C=30)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .5;
      double h = Math.sqrt(3)/2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(0);
   }
}
