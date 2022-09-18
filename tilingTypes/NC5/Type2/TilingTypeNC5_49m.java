package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_49m
   extends TilingType
{
   public TilingTypeNC5_49m(){
      super( "NC5-49m: 60-90-150-30-210", 5, SymmetryType.pg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {3, 0,0, 0,0,0, 0},
            {0, 0,4, 0,2,3, 0},
            {1, 4,0, 1,3,4, 1},
            {2, 2,0, 2,2,4, 1},

            {3, 4,0, 1,1,2, 1},
            {0, 0,4, 4,2,3, 1},
            {1, 4,0, 5,3,4, 0},
            {2, 2,0, 6,2,4, 0},

            {3, 0,1, 7,4,3, 0},
            {0, 0,4, 8,2,3, 0},
            {1, 4,0, 9,3,4, 1},
            {2, 2,0,10,2,4, 1},

            {3, 4,0, 9,1,2, 1},
            {0, 0,4,12,2,3, 1},
            {1, 4,0,13,3,4, 0},
            {2, 2,0,14,2,4, 0},
      
      };
      info = "a=b=c=d=e\nA=90\nB=150\nC=30\nD=210\n(E=60)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .6;
      double h = ln * Math.sqrt(3)/2;
      baseTile.setPoint(0,   0,    0);
      baseTile.setPoint(1,  ln,    0);
      baseTile.setPoint(2,ln+h, ln/2);
      baseTile.setPoint(3,   h, ln/2);
      baseTile.setPoint(4,   0,   ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(2)-tiles[3].getX(2);
      offsets[1] = tiles[4].getY(2)-tiles[3].getY(2);
      offsets[2] = tiles[12].getX(2)-tiles[3].getX(2);
      offsets[3] = tiles[12].getY(2)-tiles[3].getY(2);
   }
}
