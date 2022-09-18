package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_15
   extends TilingType
{
   public TilingTypeN3_15(){
      super( "N3-15", 5, SymmetryType.pgg );

      paramMin = new int[]{-100,  0,  0};
      paramMax = new int[]{ 100,100,100};
      paramDef = new int[]{  10, 50, 20};
      paramName = new String[]{ "Skew", "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 0,4, 0,4,0, 0},
            {0, 2,3, 1,0,2, 1},
            {1, 0,4, 2,4,0, 1},

            {1, 1,0, 0,0,1, 0},
            {0, 0,4, 4,4,0, 0},
            {0, 2,3, 5,0,2, 1},
            {1, 0,4, 6,4,0, 1},
      };
      info = "(A+B+C=180)";
      labels = new int[]{0,-1,-1,1,2};
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 1.5*(1+paramValues[1])/102.;
      double ln2 = 1.5-ln1;
      double dx = ln1*Math.tan( paramValues[0]*.9 * DEG2RAD);
      double os = ln1 * getParam( paramValues,2)/100.;

      baseTile.setPoint(0,       0,  0);
      baseTile.setPoint(1,      os,  0);
      baseTile.setPoint(2,   ln1/2,  0);
      baseTile.setPoint(3,     ln1,  0);
      baseTile.setPoint(4,ln1/2+dx,ln2);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(1);
   }
}
