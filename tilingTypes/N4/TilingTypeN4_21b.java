package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_21b
   extends TilingType
{
   public TilingTypeN4_21b(){
      super( "N4-21b", 4, SymmetryType.cmm );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 70};
      paramName = new String[]{ "Aspect", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 3,2, 2,2,3, 0},

            {0, 0,1, 0,0,1, 1},
            {1, 3,2, 4,2,3, 1},
            {1, 1,0, 5,0,1, 1},
            {0, 3,2, 6,2,3, 1},
      };
      info = "A=90\nB=90\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 2*getParam( paramValues,0)/100.;
      double ln2 = 2-ln1;

      double ln3 = ln2*getParam( paramValues,1)/100.;
      ln2 -= ln3;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1,  0);
      baseTile.setPoint(2,ln1,ln2);
      baseTile.setPoint(3,  0,ln3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(0)-tiles[3].getX(0);
      offsets[1] = tiles[7].getY(0)-tiles[3].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(0)-tiles[0].getY(0);
   }
}
