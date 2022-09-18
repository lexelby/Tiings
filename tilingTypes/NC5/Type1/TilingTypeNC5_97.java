package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_97
   extends TilingType
{
   public TilingTypeNC5_97(){
      super( "NC5-97", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,4, 0},
            {1, 4,3, 1,3,4, 0},
            {0, 0,4, 2,0,1, 0},

            {0, 1,0, 1,2,1, 1},
            {1, 0,1, 4,0,4, 1},
            {1, 4,3, 5,3,4, 1},
            {0, 0,4, 6,0,1, 1},
      };
      info = "a=b\nc=d\ne+d=2a\nB+E=180\nA=90\nB+C=360\n(D+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      final double ln1 = .25;
      final double s = (Math.sqrt(7)-1)/4;
      final double c = s+.5;
      final double ln2 = ln1 * 2*(s+1);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, ln2, 0);
      baseTile.setPoint(2, ln2+s*ln1, c*ln1);
      baseTile.setPoint(3, ln2+(s+1)*ln1, c*ln1);
      baseTile.setPoint(4, 0, ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(2)-tiles[0].getX(1);
      offsets[1] = tiles[5].getY(2)-tiles[0].getY(1);
      offsets[2] = tiles[3].getX(2)-tiles[0].getX(3);
      offsets[3] = tiles[3].getY(2)-tiles[0].getY(3);
   }
}
