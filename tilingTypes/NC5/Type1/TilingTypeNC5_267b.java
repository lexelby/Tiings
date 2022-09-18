package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_267b
   extends TilingType
{
   public TilingTypeNC5_267b(){
      super( "NC5-267b", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 20};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 3,2, 0,2,3, 0},
            {1, 0,4, 1,0,1, 0},
            {1, 2,1, 2,1,2, 0},
            {0, 0,1, 3,0,4, 0},
            {2, 2,3, 4,3,2, 0},

            {2, 4,0, 0,0,1, 1},
            {0, 3,2, 6,2,3, 1},
            {1, 0,4, 7,0,1, 1},
            {1, 2,1, 8,1,2, 1},
            {0, 0,1, 9,0,4, 1},
            {2, 2,3,10,3,2, 1},
      };
      info = "a=b\nd=2a\nA=90\nB+C=360\nC+D=180\n(A+D+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lnabc = 1.5;
      double lnb = lnabc * getParam(paramValues, 0)/100;
      double lna = (lnabc - lnb)/3;
      double s = 1/Math.sqrt(10);
      double c = 3*s;
      
      baseTile.setPoint(0,  0,   0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, lna+lnb*c, -lnb*s);
      baseTile.setPoint(3, 3*lna+lnb*c, -lnb*s);
      baseTile.setPoint(4, 0, lna);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[11].getX(0)-tiles[5].getX(4);
      offsets[3] = tiles[11].getY(0)-tiles[5].getY(4);
   }
}
