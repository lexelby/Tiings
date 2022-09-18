package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ab2
   extends TilingType
{
   public TilingTypeN5_01ab2(){
      super( "N5-1ab2", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,2,1, 1},
            {0, 0,1, 1,2,1, 1},
            {1, 1,0, 2,2,1, 0},

            {0, 0,4, 3,3,4, 0},
            {1, 1,0, 4,2,1, 1},
            {0, 0,1, 5,2,1, 1},
            {1, 1,0, 6,2,1, 0},
      };
      info = "a=d=e\nb=c+d\nA=90\nB=45\nC=135\nD=135\n(E=135)";
   }

   public void recalcBase(double[] paramValues) {
      double r = Math.sqrt(2);
      double ln1 = (2-r)/2;
      double ln2 = r/2;

      double x4 = 0;
      double y4 = ln1;
      double x3 = ln1*r/2;
      double y3 = ln1 + ln1*r/2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1+ln2,  0);
      baseTile.setPoint(2, x3+ln1, y3);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[6].getX(4);
      offsets[1] = tiles[1].getY(4)-tiles[6].getY(4);
      offsets[2] = tiles[3].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(2)-tiles[0].getY(0);
   }
}
