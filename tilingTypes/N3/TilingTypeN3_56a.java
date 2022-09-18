package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_56a
   extends TilingType
{
   public TilingTypeN3_56a(){
      super( "N3-56a", 3, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 55};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
            {1, 0,1, 1,0,1, 1},
            {1, 1,2, 2,2,1, 1},
            {0, 0,1, 3,0,1, 0},
            {2, 1,2, 4,2,1, 0},

            {2, 0,1, 1,2,0, 1},
            {0, 2,1, 6,1,2, 1},
            {1, 0,1, 7,0,1, 0},
            {1, 1,2, 8,2,1, 0},
            {0, 0,1, 9,0,1, 1},
            {2, 1,2,10,2,1, 1},
      };
      info = "A=90\n(B+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1.5;
      double ln1 = ln * getParam( paramValues,0)/100;
      double ln2 = ln - ln1;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1,  0);
      baseTile.setPoint(2,  0,ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[6].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[11].getX(0)-tiles[5].getX(1);
      offsets[3] = tiles[11].getY(0)-tiles[5].getY(1);
   }
}
