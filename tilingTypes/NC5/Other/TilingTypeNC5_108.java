package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_108
   extends TilingType
{
   public TilingTypeNC5_108(){
      super( "NC5-108", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,4,0, 0},
            {1, 0,4, 1,4,0, 0},
            {0, 4,0, 2,1,0, 0},

            {0, 1,0, 2,3,2, 1},
            {1, 1,0, 4,4,0, 1},
            {1, 0,4, 5,4,0, 1},
            {0, 4,0, 6,1,0, 1},
      };
      info = "c=e\nb=d+c\na=b+c\nA=C\nA+E=180\nB+E=360\n(2C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      final double c = .75;
      final double s = Math.sqrt(1-c*c);
      final double ln = .15;
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, 7*ln, 0);
      baseTile.setPoint(2, (7+c)*ln, -s*ln);
      baseTile.setPoint(3, (8*c+1)*ln, 8*s*ln);
      baseTile.setPoint(4, 8*c*ln, 8*s*ln);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[3].getX(2);
      offsets[1] = tiles[0].getY(3)-tiles[3].getY(2);
      offsets[2] = tiles[3].getX(1)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[7].getY(0);
   }
}
