package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_102
   extends TilingType
{
   public TilingTypeNC5_102(){
      super( "NC5-102", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,0,1, 1},
            {1, 4,3, 1,3,4, 1},
            {0, 0,1, 2,2,3, 0},

            {0, 3,2, 0,0,4, 1},
            {1, 2,3, 4,0,1, 0},
            {1, 4,3, 5,3,4, 0},
            {0, 0,1, 6,2,3, 1},
      };
      info = "a=d\nb=2a\ne=2c\nB=D\nC+E=360\nD+E=180\n(A+B=E)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = .4;
      double ln2 = Math.sqrt(6)*ln1/2;
      double c1 = 0.25;
      double s1 = Math.sqrt(1-c1*c1);
      double c2 = Math.sqrt(3./8);
      double s2 = Math.sqrt(1-c2*c2);
      
      baseTile.setPoint(0,   0,    0);
      baseTile.setPoint(1, (2+c1)*ln1, -s1*ln1);
      baseTile.setPoint(2, 2*ln1,  0);
      baseTile.setPoint(3, 2*ln1+ln2*c2, ln2*s2);
      baseTile.setPoint(4, ln2*c2, ln2*s2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(4)-tiles[0].getX(2);
      offsets[1] = tiles[4].getY(4)-tiles[0].getY(2);
      offsets[2] = tiles[7].getX(4)-tiles[3].getX(2);
      offsets[3] = tiles[7].getY(4)-tiles[3].getY(2);
   }
}
