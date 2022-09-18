package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_40a
   extends TilingType
{
   public TilingTypeN3_40a(){
      super( "N3-40a", 3, SymmetryType.p2 );
      // params are angle/distance of the other two points relative to first one
      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 20};
      paramName = new String[]{ "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,2, 0},
            {2, 0,2, 1,0,2, 1},
            {2, 2,1, 2,1,2, 1},
            {1, 0,2, 3,0,2, 0},
            {0, 2,1, 4,1,2, 0},
            {3, 2,0, 5,0,2, 0},
            {3, 2,1, 6,1,2, 0},
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
      double os = getParam(paramValues,1)/100.;
      offsets[0] = tiles[7].getX(0)-tiles[0].getX(2);
      offsets[1] = tiles[7].getY(0)-tiles[0].getY(2);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(0) + os * offsets[0];
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(0) + os * offsets[1];
   }
}
