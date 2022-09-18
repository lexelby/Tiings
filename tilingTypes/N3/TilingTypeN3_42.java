package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_42
   extends TilingType
{
   public TilingTypeN3_42(){
      super( "N3-42", 4, SymmetryType.pgg );
      // params are angle/distance of the other two points relative to first one
      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 20};
      paramName = new String[]{ "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,2, 0},
            {0, 0,1, 1,0,1, 1},
            {1, 2,1, 2,1,2, 1},
            {2, 2,0, 1,3,0, 1},
            {2, 2,1, 4,1,2, 1},
            {3, 1,0, 5,0,1, 1},
            {3, 2,1, 6,1,2, 1},

            {1, 3,0, 5,2,0, 0},
            {0, 2,1, 8,1,2, 0},
            {1, 0,1, 9,0,1, 1},
            {0, 2,1,10,1,2, 1},
            {2, 2,0,10,3,0, 0},
            {2, 2,1,12,1,2, 0},
            {3, 1,0,13,0,1, 0},
            {3, 2,1,14,1,2, 0},
      };
      info = "A=90\n(B+C=90)";
      labels = new int[]{0,1,2,-1};
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2*getParam(paramValues,0)/100.;
      double ln1 = 2-ln2;
      double os = 2 * ln2*getParam(paramValues,1)/100.;
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, ln1, 0);
      baseTile.setPoint(2,   0, ln2);
      baseTile.setPoint(3,   0, os);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[13].getX(2)-tiles[3].getX(3);
      offsets[3] = tiles[13].getY(2)-tiles[3].getY(3);
   }
}
