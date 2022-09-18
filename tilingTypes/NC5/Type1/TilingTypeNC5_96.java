package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_96
   extends TilingType
{
   public TilingTypeNC5_96(){
      super( "NC5-96", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 0,4, 0,4,0, 0},
            {0, 4,3, 0,2,3, 0},
            {0, 1,2, 2,2,1, 0},

            {1, 1,0, 2,0,4, 1},
            {1, 0,4, 4,4,0, 1},
            {0, 4,3, 4,2,3, 1},
            {0, 1,2, 6,2,1, 1},
      };
      info = "a=b+c\nb=2c\nd=e\nB=E\nD=90\nB+C=360\n(A+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .1;

      baseTile.setPoint(0, 0,        0);
      baseTile.setPoint(1, ln*10,    0);
      baseTile.setPoint(2, ln*7,  ln*4);
      baseTile.setPoint(3, ln*12, ln*4);
      baseTile.setPoint(4, ln*12, ln*9);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[2].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(1)-tiles[0].getX(4);
      offsets[3] = tiles[5].getY(1)-tiles[0].getY(4);
   }
}
