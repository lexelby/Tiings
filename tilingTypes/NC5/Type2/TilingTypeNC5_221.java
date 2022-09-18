package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_221
   extends TilingType
{
   public TilingTypeNC5_221(){
      super( "NC5-221", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,2,1, 0},
            {2, 3,2, 1,0,4, 1},
            {0, 0,4, 1,3,2, 1},
            {1, 0,1, 3,2,1, 1},
            {2, 3,2, 4,0,4, 0},

            {0, 0,1, 5,1,0, 0},
            {1, 0,1, 6,2,1, 0},
            {2, 3,2, 7,0,4, 1},
            {0, 0,4, 7,3,2, 1},
            {1, 0,1, 9,2,1, 1},
            {2, 3,2,10,0,4, 0},
      };
      info = "c=2a\na=d=e\nB=D\nD+E=180\nC+E=360\n(A+B+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double h = ln * Math.sqrt(3)/2;

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, 2*h,  0);
      baseTile.setPoint(2,   0,  ln);
      baseTile.setPoint(3, -ln/2, ln+h);
      baseTile.setPoint(4, -ln/2, h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(2)-tiles[0].getX(4);
      offsets[1] = tiles[4].getY(2)-tiles[0].getY(4);
      offsets[2] = tiles[1].getX(3)-tiles[8].getX(1);
      offsets[3] = tiles[1].getY(3)-tiles[8].getY(1);
   }
}
