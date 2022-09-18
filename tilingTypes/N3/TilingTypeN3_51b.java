package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_51b
   extends TilingType
{
   public TilingTypeN3_51b(){
      super( "N3-51b", 4, SymmetryType.pmg );
      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 3,2, 0,2,3, 0},
            {2, 0,3, 1,0,3, 1},
            {1, 0,3, 0,3,0, 0},
            {0, 3,2, 3,2,3, 0},
            {2, 0,3, 4,0,3, 1},

            {1, 1,0, 2,0,1, 1},
            {0, 3,2, 6,2,3, 1},
            {2, 0,3, 7,0,3, 0},
            {1, 0,3, 6,3,0, 1},
            {0, 3,2, 9,2,3, 1},
            {2, 0,3,10,0,3, 0},      
      };
      info = "A=90\n(B+C=90)";
      labels = new int[]{0,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2*getParam(paramValues,0)/100.;
      double ln1 = 2-ln2;
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, ln1/2, 0);
      baseTile.setPoint(2, ln1, 0);
      baseTile.setPoint(3,   0, ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(3)-tiles[2].getX(2);
      offsets[1] = tiles[5].getY(3)-tiles[2].getY(2);
      offsets[2] = tiles[0].getX(0)-tiles[8].getX(1);
      offsets[3] = tiles[0].getY(0)-tiles[8].getY(1);
   }
}
