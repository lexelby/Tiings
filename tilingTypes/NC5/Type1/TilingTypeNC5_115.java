package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_115
   extends TilingType
{
   public TilingTypeNC5_115(){
      super( "NC5-115", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 70};
      paramName = new String[]{ "Indent" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,1,2, 0},
            {0, 1,0, 1,1,2, 0},
            {1, 1,0, 2,1,2, 0},

            {0, 3,2, 0,4,3, 1},
            {1, 1,0, 4,1,2, 1},
            {0, 1,0, 5,1,2, 1},
            {1, 1,0, 6,1,2, 1},
      };
      info = "a=d\nb=c\ne=2d\nB=90\nD+E=360\n(A+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.0;

      double dy = (w/4) * ( paramValues[0]/50. -1);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  w,  0);
      baseTile.setPoint(2,  w,  w);
      baseTile.setPoint(3, w*3/4+dy, w*3/4-dy);
      baseTile.setPoint(4, w/4-dy, w/4+dy);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[6].getX(4)-tiles[2].getX(3);
      offsets[3] = tiles[6].getY(4)-tiles[2].getY(3);
   }
}
