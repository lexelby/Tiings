package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_33d
   extends TilingType
{
   public TilingTypeN3_33d(){
      super( "N3-33d", 5, SymmetryType.pgg );
      paramMin = new int[]{-100,  0,  0};
      paramMax = new int[]{ 100,100,100};
      paramDef = new int[]{  10, 50, 30};
      paramName = new String[]{ "Skew", "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,4,0, 0},
            {2, 2,0, 1,0,2, 0},
            {2, 0,4, 2,4,0, 0},
            {1, 2,0, 3,0,2, 0},
            {0, 4,0, 4,0,4, 0},

            {0, 1,3, 0,0,1, 1},
            {1, 0,4, 6,4,0, 1},
            {2, 2,0, 7,0,2, 1},
            {2, 0,4, 8,4,0, 1},
            {1, 2,0, 9,0,2, 1},
            {0, 4,0,10,0,4, 1},
      };
      info = "(A+B+C=180)";
      labels = new int[]{0,-1,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 1.5*getParam( paramValues,1)/100.;
      double ln2 = 1.5-ln1;
      double dx = ln1*Math.tan( paramValues[0]*.9 * DEG2RAD);
      double os = ln1*getParam( paramValues,2)/100;

      baseTile.setPoint(0,       0,  0);
      baseTile.setPoint(1,   ln1/2,  0);
      baseTile.setPoint(2,      os,  0);
      baseTile.setPoint(3,     ln1,  0);
      baseTile.setPoint(4,ln1/2+dx,ln2);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(1)-tiles[11].getX(0);
      offsets[3] = tiles[5].getY(1)-tiles[11].getY(0);
   }
}
