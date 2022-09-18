package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_83
   extends TilingType
{
   public TilingTypeN4_83(){
      super( "N4-83", 4, SymmetryType.p6 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 33};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,2, 0},
            {2, 3,2, 0,0,1, 0},
            {2, 2,1, 2,1,2, 0},
            {1, 3,2, 2,0,1, 0},
            {0, 2,1, 4,1,2, 0},

            {0, 3,0, 0,3,2, 0},
            {1, 2,1, 6,1,2, 0},
            {2, 3,2, 6,0,1, 0},
            {2, 2,1, 8,1,2, 0},
            {1, 3,2, 8,0,1, 0},
            {0, 2,1,10,1,2, 0},

            {0, 3,0, 6,3,2, 0},
            {1, 2,1,12,1,2, 0},
            {2, 3,2,12,0,1, 0},
            {2, 2,1,14,1,2, 0},
            {1, 3,2,14,0,1, 0},
            {0, 2,1,16,1,2, 0},
      };
      info = "a=c\nb=d\nA+B=180\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .4;
      double ln2 = 3 * ln * getParam(paramValues,0)/100;
      double ln3 = 3 * ln - ln2;
      double s60 = Math.sqrt(.75);

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, ln3,  0);
      baseTile.setPoint(2, ln*.5+ln2, ln*s60);
      baseTile.setPoint(3, ln*.5, ln*s60);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(3)-tiles[11].getX(3);
      offsets[1] = tiles[5].getY(3)-tiles[11].getY(3);
      offsets[2] = tiles[5].getX(3)-tiles[17].getX(3);
      offsets[3] = tiles[5].getY(3)-tiles[17].getY(3);
   }
}
