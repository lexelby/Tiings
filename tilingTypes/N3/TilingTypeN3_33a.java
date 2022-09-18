package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_33a
   extends TilingType
{
   public TilingTypeN3_33a(){
      super( "N3-33a", 4, SymmetryType.p2 );
      paramMin = new int[]{-100,  0,  0,  0};
      paramMax = new int[]{ 100,100,100,100};
      paramDef = new int[]{  10, 50, 30, 45};
      paramName = new String[]{ "Skew", "Aspect", "Offset 1", "Offset 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,3,0, 0},
            {2, 1,2, 1,0,1, 1},

            {2, 3,0, 2,0,3, 1},
            {1, 0,1, 3,1,2, 0},
            {0, 3,0, 4,0,3, 0},
      };
      info = "(A+B+C=180)";
      labels = new int[]{0,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 1.5*getParam( paramValues,1)/100.;
      double ln2 = 1.5-ln1;
      double dx = ln1*Math.tan( paramValues[0]*.9 * DEG2RAD);
      double os = ln1*getParam( paramValues,3)/100;

      baseTile.setPoint(0,       0,  0);
      baseTile.setPoint(1,      os,  0);
      baseTile.setPoint(2,     ln1,  0);
      baseTile.setPoint(3,ln1/2+dx,ln2);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[5].getX(0)-tiles[0].getX(0) - offsets[0]*paramValues[2]/100;
      offsets[3] = tiles[5].getY(0)-tiles[0].getY(0) - offsets[1]*paramValues[2]/100;
   }
}
