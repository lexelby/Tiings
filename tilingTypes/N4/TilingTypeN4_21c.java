package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_21c
   extends TilingType
{
   public TilingTypeN4_21c(){
      super( "N4-21c", 4, SymmetryType.cmm );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 30};
      paramName = new String[]{ "Aspect", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {0, 0,1, 0,0,1, 1},
            {1, 3,2, 2,2,3, 1},

            {0, 0,3, 0,0,3, 1},
            {1, 3,2, 4,2,3, 1},
            {0, 0,1, 4,0,1, 0},
            {1, 3,2, 6,2,3, 0},
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
      offsets[0] = tiles[1].getX(1)-tiles[3].getX(1);
      offsets[1] = tiles[1].getY(1)-tiles[3].getY(1);
      offsets[2] = tiles[0].getX(1)-tiles[5].getX(0);
      offsets[3] = tiles[0].getY(1)-tiles[5].getY(0);
   }
}
