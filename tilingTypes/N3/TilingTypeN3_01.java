package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_01
   extends TilingType
{
   public TilingTypeN3_01(){
      super( "N3-1", 3, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,1,2, 0},
            {0, 0,1, 1,2,1, 0},
            {1, 1,0, 2,1,2, 0},

            {0, 2,0, 1,2,0, 1},
            {1, 1,0, 4,1,2, 1},
            {0, 0,1, 5,2,1, 1},
            {1, 1,0, 6,1,2, 1},
      };
      info = "B=90\n(A+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 2 * getParam( paramValues,0)/100.;
      double ln2 = 2- ln1;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1,  0);
      baseTile.setPoint(2,ln1,ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[5].getX(2);
      offsets[1] = tiles[0].getY(2)-tiles[5].getY(2);
      offsets[2] = tiles[2].getX(0)-tiles[7].getX(0);
      offsets[3] = tiles[2].getY(0)-tiles[7].getY(0);
   }
}
