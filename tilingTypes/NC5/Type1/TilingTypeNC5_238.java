package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_238
   extends TilingType
{
   public TilingTypeNC5_238(){
      super( "NC5-238", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,4,0, 0},
            {1, 4,1, 1,1,4, 0},
            {0, 0,4, 2,4,0, 0},
            {2, 0,1, 3,2,1, 0},
            {2, 0,4, 4,4,0, 0},
      };
      info = "b=3c\nc=d=e\nB=90\nC=270\nD=90\n(A+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .3;

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,ln*3,  0);
      baseTile.setPoint(2,ln*3, ln);
      baseTile.setPoint(3,ln*4, ln);
      baseTile.setPoint(4,ln*4, ln*2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(1);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(1);
      offsets[2] = tiles[0].getX(2)-tiles[5].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[5].getY(0);
   }
}
