package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_14
   extends TilingType
{
   public TilingTypeN3_14(){
      super( "N3-14", 4, SymmetryType.cm );

      paramMin = new int[]{-100,  0};
      paramMax = new int[]{ 100,100};
      paramDef = new int[]{  10, 50};
      paramName = new String[]{ "Skew", "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,3,0, 0},
            {1, 0,2, 1,0,2, 1},
            {0, 0,3, 2,3,0, 1},

            {0, 1,2, 0,0,1, 1},
            {1, 0,3, 4,3,0, 1},
            {1, 0,2, 5,0,2, 0},
            {0, 0,3, 6,3,0, 0},
      };
      info = "(A+B+C=180)";
      labels = new int[]{0,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 1.5*(1+paramValues[1])/102.;
      double ln2 = 1.5-ln1;
      double dx = ln1*Math.tan( paramValues[0]*.9 * DEG2RAD);

      baseTile.setPoint(0,       0,  0);
      baseTile.setPoint(1,   ln1/2,  0);
      baseTile.setPoint(2,     ln1,  0);
      baseTile.setPoint(3,ln1/2+dx,ln2);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(1);
   }
}
