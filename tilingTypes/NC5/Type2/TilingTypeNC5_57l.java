package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_57l
   extends TilingType
{
   public TilingTypeNC5_57l(){
      super( "NC5-57l", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,2, 0},
            {2, 3,4, 1,0,1, 1},
            {0, 4,0, 0,0,4, 0},
            {1, 2,1, 3,1,2, 0},
            {2, 3,4, 4,0,1, 1},

            {0, 1,0, 2,4,0, 1},
            {1, 2,1, 6,1,2, 1},
            {2, 3,4, 7,0,1, 0},
            {0, 4,0, 6,0,4, 1},
            {1, 2,1, 9,1,2, 1},
            {2, 3,4,10,0,1, 0},
      };
      info = "a=d=e\nb=c=2a\nA=120\nB=60\nC=60\nD=240\n(E=60)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .35;
      double h = ln * Math.sqrt(3)/2;

      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1, 2*ln,  0);
      baseTile.setPoint(2,   ln,  h*2);
      baseTile.setPoint(3, ln/2,  h);
      baseTile.setPoint(4,-ln/2,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(1)-tiles[5].getX(0);
      offsets[1] = tiles[2].getY(1)-tiles[5].getY(0);
      offsets[2] = tiles[8].getX(4)-tiles[0].getX(1);
      offsets[3] = tiles[8].getY(4)-tiles[0].getY(1);
   }
}
