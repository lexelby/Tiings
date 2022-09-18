package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_16a
   extends TilingType
{
   public TilingTypeN3_16a(){
      super( "N3-16a", 3, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 60, 60};
      paramName = new String[]{ "Angle", "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 2,1, 0,1,2, 0},
            {0, 2,0, 0,0,2, 0},
            {0, 2,0, 1,0,2, 0},

            {0, 1,2, 0,0,1, 1},
            {1, 2,0, 4,0,2, 1},
            {1, 2,1, 5,1,2, 1},
            {0, 2,0, 6,0,2, 1},
      };
      info = "(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = paramValues[1]/100.;
      double ln2 = (1-ln1)*2;
      double dx = ln2*Math.cos(paramValues[0]* DEG2RAD);
      double dy = ln2*Math.sin(paramValues[0]* DEG2RAD);

      baseTile.setPoint(0,     0,  0);
      baseTile.setPoint(1,   ln1,  0);
      baseTile.setPoint(2,ln1-dx, dy);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(2)-tiles[2].getX(1);
      offsets[1] = tiles[4].getY(2)-tiles[2].getY(1);
      offsets[2] = tiles[3].getX(1)-tiles[7].getX(2);
      offsets[3] = tiles[3].getY(1)-tiles[7].getY(2);
   }
}
