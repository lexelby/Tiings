package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_120
   extends TilingType
{
   public TilingTypeNC5_120(){
      super( "NC5-120", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,4, 0,2,4, 0},
            {0, 0,2, 1,2,4, 1},
            {1, 1,4, 2,2,4, 1},

            {0, 4,0, 0,0,4, 0},
            {1, 1,4, 4,2,4, 0},
            {0, 0,2, 5,2,4, 1},
            {1, 1,4, 6,2,4, 1},
      };
      info = "a=c=e\nb=d\nA=B\nA+D=360\n(B+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;
      double lna = lntotal * getParam(paramValues, 0)/100;
      double lnb = lntotal - lna;

      double c = (lnb - Math.sqrt(lnb*lnb+4*lna*lna))/4/lna;
      double s = Math.sqrt(1-c*c);
      
      double w = lnb - 2*lna*c;
      double e = 2 * Math.asin(lna/2/w) / DEG2RAD;
      double a = Math.acos(c)/DEG2RAD;
      
      final double x4 =      lna * c;
      final double y4 =      lna * s;
      final double x3 = x4 + lna*Math.cos((a-180+e)*DEG2RAD);
      final double y3 = y4 + lna*Math.sin((a-180+e)*DEG2RAD);
      final double x1 = lnb;
      final double y1 = 0;
      final double x2 = x1 - lna * c;
      final double y2 = y1 + lna * s;
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(3)-tiles[0].getX(1);
      offsets[1] = tiles[3].getY(3)-tiles[0].getY(1);
      offsets[2] = tiles[1].getX(2)-tiles[5].getX(1);
      offsets[3] = tiles[1].getY(2)-tiles[5].getY(1);
   }
}
