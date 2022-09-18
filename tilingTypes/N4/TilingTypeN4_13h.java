package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_13h
   extends TilingType
{
   public TilingTypeN4_13h(){
      super( "N4-13h", 4, SymmetryType.pmg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 60};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,3, 1},
            {2, 1,0, 0,0,1, 0},
            {0, 2,3, 0,3,2, 0},
            {1, 0,3, 3,0,3, 1},
            {2, 1,0, 3,0,1, 0},

            {1, 0,1, 1,0,1, 0},
            {0, 0,3, 6,0,3, 1},
            {2, 1,0, 7,0,1, 1},
            {0, 2,3, 7,3,2, 1},
            {1, 0,3, 9,0,3, 0},
            {2, 1,0, 9,0,1, 1},
      };
      info = "c=d\nA+D=180\nC+2D=360\n(B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = paramValues[0]/100.;
      double ln2 = 1-ln1;
      
      baseTile.setPoint(0,    0,     0);
      baseTile.setPoint(1,2*ln1, 2*ln2);
      baseTile.setPoint(2,  ln1, 3*ln2);
      baseTile.setPoint(3,    0, 2*ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(0)-tiles[10].getX(0);
      offsets[1] = tiles[4].getY(0)-tiles[10].getY(0);

      offsets[2] = tiles[1].getX(1)-tiles[2].getX(2);
      offsets[3] = tiles[1].getY(1)-tiles[2].getY(2);
   }
}
