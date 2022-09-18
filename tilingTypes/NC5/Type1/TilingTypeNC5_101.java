package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_101
   extends TilingType
{
   public TilingTypeNC5_101(){
      super( "NC5-101", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,0,4, 0},
            {1, 4,0, 1,0,4, 0},
            {0, 0,4, 2,3,4, 0},

            {0, 2,3, 0,0,1, 1},
            {1, 3,4, 4,0,4, 1},
            {1, 4,0, 5,0,4, 1},
            {0, 0,4, 6,3,4, 1},
      };
      info = "a=e\nc=d\nb=2c\nD=E\nB+C=360\nA+D=B\n(B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      final double ln1 = .25;
      final double c = (Math.sqrt(5)-1)/2;
      final double s = Math.sqrt(1-c*c);
      final double ln2 = (3+2*c)*ln1;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, 2*ln1, 0);
      baseTile.setPoint(2, (2+c)*ln1, s*ln1);
      baseTile.setPoint(3, (3+c)*ln1, s*ln1);
      baseTile.setPoint(4, (3+c)*ln1-c*ln2, s*ln1+s*ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(0)-tiles[0].getX(2);
      offsets[1] = tiles[4].getY(0)-tiles[0].getY(2);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(2);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(2);
   }
}
