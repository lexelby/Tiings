package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_42
   extends TilingType
{
   public TilingTypeP4_42(){
      super( "P4-42: Cubic rhombus pattern", 4, SymmetryType.p6m );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,1, 0,0,3, 0},
            {0, 0,1, 1,0,3, 0},
            };
      info = "a=b=c=d\nA=120\nB=60\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double h = Math.sqrt(3)/2;
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,   1, 0);
      baseTile.setPoint(2, 0.5, h);
      baseTile.setPoint(3,-0.5, h);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(2)-tiles[0].getX(2);
      offsets[1] = tiles[1].getY(2)-tiles[0].getY(2);
      offsets[2] = tiles[2].getX(2)-tiles[0].getX(2);
      offsets[3] = tiles[2].getY(2)-tiles[0].getY(2);
   }
}
