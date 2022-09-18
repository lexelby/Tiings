package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_135
   extends TilingType
{
   public TilingTypeNC5_135(){
      super( "NC5-135", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 60};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,4, 0},
            {1, 3,2, 1,2,3, 0},
            {0, 0,4, 2,0,1, 0},

            {0, 3,2, 0,2,1, 1},
            {1, 0,1, 4,0,4, 1},
            {1, 3,2, 5,2,3, 1},
            {0, 0,4, 6,0,1, 1},
      };
      info = "a=b=c+e\nd+e=c\nA=B\nC+D=180\n(A+B+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double lnab = 0.75;
      double lne = lnab * getParam(paramValues, 0)/400;
      double lnc = lnab-lne;

      double a = lnab;
      double b = lnc-lne;
      double c1 = 2*a*b;
      double c2 = -a*(a+b);
      double c3 = a*(a-b);
      double cs = (-c2-Math.sqrt(c2*c2-4*c1*c3))/2/c1;
      double sn = Math.sqrt(1-cs*cs);
      
      double x1 = lnab;
      double y1 = 0;
      double x2 = x1 - lnc * cs;
      double y2 = y1 + lnc * sn;
      double x4 =      lnab * cs;
      double y4 =      lnab * sn;
      double x3 = x4 - lne * cs;
      double y3 = y4 + lne * sn;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(1);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(1);
      offsets[2] = tiles[7].getX(3)-tiles[3].getX(2);
      offsets[3] = tiles[7].getY(3)-tiles[3].getY(2);
   }
}
