package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_57j
   extends TilingType
{
   public TilingTypeNC5_57j(){
      super( "NC5-57j", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,2, 0},
            {2, 2,1, 1,0,1, 0},
            {0, 3,4, 2,0,4, 0},
            {1, 2,1, 3,1,2, 0},
            {2, 2,1, 4,0,1, 0},

            {0, 0,1, 1,4,0, 1},
            {1, 2,1, 6,1,2, 1},
            {2, 2,1, 7,0,1, 1},
            {0, 3,4, 8,0,4, 1},
            {1, 2,1, 9,1,2, 1},
            {2, 2,1,10,0,1, 1},
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
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[4].getX(4)-tiles[1].getX(4);
      offsets[3] = tiles[4].getY(4)-tiles[1].getY(4);
   }
}
