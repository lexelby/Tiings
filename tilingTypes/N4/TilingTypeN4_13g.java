package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_13g
   extends TilingType
{
   public TilingTypeN4_13g(){
      super( "N4-13g", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 60, 50};
      paramName = new String[]{ "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,0,4, 1},
            {2, 2,0, 0,1,0, 1},

            {0, 3,4, 0,4,3, 0},
            {1, 0,4, 3,0,4, 1},
            {2, 2,0, 3,1,0, 1},
      };
      info = "c=d\nA+D=180\nC+2D=360\n(B+C=180)";
      labels = new int[]{0,-1,1,2,3};
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = paramValues[0]/100.;
      double ln2 = 1-ln1;
      double os = 3*getParam(paramValues,1)/100;
      
      baseTile.setPoint(0,    0,     0);
      baseTile.setPoint(1,os*ln1, os*ln2);
      baseTile.setPoint(2,2*ln1, 2*ln2);
      baseTile.setPoint(3,  ln1, 3*ln2);
      baseTile.setPoint(4,    0, 2*ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(2)-tiles[2].getX(3);
      offsets[1] = tiles[5].getY(2)-tiles[2].getY(3);

      offsets[2] = tiles[4].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[4].getY(2)-tiles[0].getY(0);
   }
}
