package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_48
   extends TilingType
{
   public TilingTypeN3_48(){
      super( "N3-48", 4, SymmetryType.p2 );
      // params are angle/distance of the other two points relative to first one
      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 40, 20, 40};
      paramName = new String[]{ "Aspect", "Offset 1", "Offset 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {2, 0,3, 1,0,3, 1},
            {3, 3,2, 2,2,3, 1},

            {0, 1,0, 0,0,1, 0},
            {1, 3,2, 4,2,3, 0},
            {2, 0,3, 5,0,3, 1},
            {3, 3,2, 6,2,3, 1},
      };
      info = "A=90\n(B+C=90)";
      labels = new int[]{0,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2*getParam(paramValues,0)/100.;
      double ln1 = 2-ln2;
      double os = 2*ln1*getParam(paramValues,1)/100.;
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,  os, 0);
      baseTile.setPoint(2, ln1, 0);
      baseTile.setPoint(3,   0, ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = getParam(paramValues,2)/100.;
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(0)-tiles[5].getX(0) + os * offsets[0];
      offsets[3] = tiles[2].getY(0)-tiles[5].getY(0) + os * offsets[1];
   }
}
