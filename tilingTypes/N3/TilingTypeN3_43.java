package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_43
   extends TilingType
{
   public TilingTypeN3_43(){
      super( "N3-43", 3, SymmetryType.pmg );
      // params are angle/distance of the other two points relative to first one
      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,2, 0},
            {2, 2,0, 1,0,2, 0},
            {2, 2,1, 2,1,2, 0},
            {1, 2,0, 3,0,2, 0},
            {0, 2,1, 4,1,2, 0},
            {3, 0,2, 5,0,2, 1},
            {3, 2,1, 6,1,2, 1},

            {0, 0,1, 0,0,1, 1},
            {1, 2,1, 8,1,2, 1},
            {2, 2,0, 9,0,2, 1},
            {2, 2,1,10,1,2, 1},
            {1, 2,0,11,0,2, 1},
            {0, 2,1,12,1,2, 1},
            {3, 0,2,13,0,2, 0},
            {3, 2,1,14,1,2, 0},
      };
      info = "A=90\n(B+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2*getParam(paramValues,0)/100.;
      double ln1 = 2-ln2;
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, ln1, 0);
      baseTile.setPoint(2,   0, ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[7].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[8].getX(2);
      offsets[3] = tiles[0].getY(2)-tiles[8].getY(2);
   }
}
