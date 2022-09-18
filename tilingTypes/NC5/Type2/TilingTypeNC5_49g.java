package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_49g
   extends TilingType
{
   public TilingTypeNC5_49g(){
      super( "NC5-49g: 60-90-150-30-210", 5, SymmetryType.pg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {3, 0,0, 0,0,0, 0},
            {0, 4,0, 0,2,3, 1},
            {1, 2,4, 1,2,0, 1},
            {2, 2,4, 2,2,0, 1},

            {3, 2,0, 1,2,4, 1},
            {0, 4,0, 4,2,3, 0},
            {1, 2,4, 5,2,0, 0},
            {2, 2,4, 6,2,0, 0},
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
      offsets[0] = tiles[7].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[7].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(2)-tiles[0].getY(0);
   }
}
