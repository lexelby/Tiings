package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_241
   extends TilingType
{
   public TilingTypeNC5_241(){
      super( "NC5-241", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 3,4, 0,3,2, 0},
            {1, 2,3, 1,0,4, 0},
            {1, 2,1, 2,1,2, 0},
            {0, 0,4, 3,2,3, 0},
            {2, 3,2, 4,3,4, 0},

            {2, 0,4, 4,3,2, 1},
            {0, 3,4, 6,3,2, 1},
            {1, 2,3, 7,0,4, 1},
            {1, 2,1, 8,1,2, 1},
            {0, 0,4, 9,2,3, 1},
            {2, 3,2,10,3,4, 1},
      };
      info = "a=c=d=2e\nA=120\nB=30\nC=210\nD=30\n(E=150)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .4;
      double h = ln * Math.sqrt(3);

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,   h,  0);
      baseTile.setPoint(2,   0, ln);
      baseTile.setPoint(3, -ln, h+ln);
      baseTile.setPoint(4, -ln,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(3)-tiles[5].getX(0);
      offsets[1] = tiles[6].getY(3)-tiles[5].getY(0);
      offsets[2] = tiles[11].getX(0)-tiles[0].getX(3);
      offsets[3] = tiles[11].getY(0)-tiles[0].getY(3);
   }
}
