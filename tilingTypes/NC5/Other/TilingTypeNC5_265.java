package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_265
   extends TilingType
{
   public TilingTypeNC5_265(){
      super( "NC5-265", 5, SymmetryType.p6 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {2, 3,2, 0,1,2, 0},
            {2, 3,2, 1,1,2, 0},
            {2, 3,2, 2,1,2, 0},
            {2, 3,2, 3,1,2, 0},
            {2, 3,2, 4,1,2, 0},

            {1, 3,4, 0,0,4, 0},
            {1, 3,4, 1,0,4, 0},
            {1, 3,4, 2,0,4, 0},
            {1, 3,4, 3,0,4, 0},
            {1, 3,4, 4,0,4, 0},
            {1, 3,4, 5,0,4, 0},

            {0, 3,4, 6,0,4, 0},
            {0, 3,4, 7,0,4, 0},
            {0, 3,4, 8,0,4, 0},
            {0, 3,4, 9,0,4, 0},
            {0, 3,4,10,0,4, 0},
            {0, 3,4,11,0,4, 0},

      };
      info = "a=e\nb=c=d\nA=30\nB=240\nC=60\nD=90\n(E=120)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .3;
      double h1 = ln * Math.sqrt(3);
      double h2 = 2*ln / Math.sqrt(3);

      baseTile.setPoint(0,    0,  0);
      baseTile.setPoint(1, 2*ln,  0);
      baseTile.setPoint(2, 3*ln,-h1);
      baseTile.setPoint(3, 4*ln,  0);
      baseTile.setPoint(4, 2*ln, h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(2)-tiles[9].getX(1);
      offsets[1] = tiles[6].getY(2)-tiles[9].getY(1);
      offsets[2] = tiles[7].getX(2)-tiles[10].getX(1);
      offsets[3] = tiles[7].getY(2)-tiles[10].getY(1);
   }
}
