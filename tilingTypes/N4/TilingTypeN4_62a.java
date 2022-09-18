package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_62a
   extends TilingType
{
   public TilingTypeN4_62a(){
      super( "N4-62a", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{ 60,100};
      paramDef = new int[]{ 30, 20};
      paramName = new String[]{ "Angle", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,0, 0,3,4, 1},
            {1, 4,0, 0,1,0, 0},
            {1, 2,0, 2,0,2, 0},

            {0, 1,0, 3,4,0, 0},
            {0, 4,0, 4,3,4, 1},
            {1, 4,0, 5,1,0, 1},
            {1, 2,0, 6,0,2, 1},
      };
      info = "c+d=a\na+c=b\nA+B=180\n(C+D=180)";
      labels = new int[]{0,-1,1,2,3};
   }
   
   public void recalcBase(double[] paramValues) {
      double ang = getParam(paramValues,0);
      double c = Math.cos(ang * DEG2RAD);
      double s = Math.sin(ang * DEG2RAD);

      double lna = 1.5;
      double lnc = lna/2 / c;
      double lnb = (lna-lnc)/2;
      double lnd = lna-lnb;
      double os = lna * getParam(paramValues,1)/100.;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, os, 0);
      baseTile.setPoint(2, lna, 0);
      baseTile.setPoint(3, lna + lnb*c, lnb*s);
      baseTile.setPoint(4, lnd*c, lnd*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(1)-tiles[7].getX(4);
      offsets[3] = tiles[1].getY(1)-tiles[7].getY(4);
   }
}
