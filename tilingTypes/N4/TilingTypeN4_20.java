package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_20
   extends TilingType
{
   public TilingTypeN4_20(){
      super( "N4-20", 4, SymmetryType.p4g );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 20};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,2,3, 0},
            {0, 0,1, 0,0,3, 0},
            {1, 3,2, 2,2,3, 0},
            {0, 0,1, 2,0,3, 0},
            {1, 3,2, 4,2,3, 0},
            {0, 0,1, 4,0,3, 0},
            {1, 3,2, 6,2,3, 0},
            
            {0, 1,2, 0,1,2, 1},
            {1, 3,2, 8,2,3, 1},
            {0, 0,1, 8,0,3, 1},
            {1, 3,2,10,2,3, 1},
            {0, 0,1,10,0,3, 1},
            {1, 3,2,12,2,3, 1},
            {0, 0,1,12,0,3, 1},
            {1, 3,2,14,2,3, 1},
      };
      info = "a+c=b\nA=90\nB=90\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 1;
      double ln1 = ln*getParam( paramValues,0)/100.;
      double ln2 = ln-ln1;
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, ln,ln1);
      baseTile.setPoint(3,  0,ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[5].getX(0);
      offsets[1] = tiles[1].getY(0)-tiles[5].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(0);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(0);
   }
}
