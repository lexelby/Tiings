package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_267a
   extends TilingType
{
   public TilingTypeNC5_267a(){
      super( "NC5-267a", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 20};
      paramName = new String[]{ "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {0, 3,2, 0,2,3, 0},
            {2, 0,4, 1,0,1, 0},

            {1, 4,0, 0,0,4, 0},
            {0, 3,2, 3,2,3, 0},
            {2, 0,4, 4,0,1, 0},
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
      offsets[2] = tiles[2].getX(1)-tiles[5].getX(2);
      offsets[3] = tiles[2].getY(1)-tiles[5].getY(2);
   }
}
