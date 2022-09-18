package tilingTypes.NC5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_165
   extends TilingType
{
   public TilingTypeNC5_165(){
      super( "NC5-165", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 60};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,1, 0,2,3, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 2,3, 2,2,1, 0},
      };
      info = "a=e\nd=c+e\nC=E\nA+B=180\nD+E=360\n(A=2E)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.0;
      double lnc = lnt * getParam(paramValues, 0)/100 * 2/(Math.sqrt(5)+3);
      double lna = lnt - lnc;
      double lnb = lna+lnc;

      double c1 = 4*lnc;
      double c2 = 2*(lna-lnc);
      double c3 = -lna-2*lnc;
      double c = (-c2+Math.sqrt(c2*c2-4*c1*c3))/2/c1;
      double d = Math.acos(c)/DEG2RAD;

      double x4 =      lnc * Math.cos(2*d*DEG2RAD);
      double y4 =      lnc * Math.sin(2*d*DEG2RAD);
      double x3 = x4 + lnc * Math.cos((180+3*d)*DEG2RAD);
      double y3 = y4 + lnc * Math.sin((180+3*d)*DEG2RAD);
      double x2 = x3 + lnb * Math.cos(d*DEG2RAD);
      double y2 = y3 + lnb * Math.sin(d*DEG2RAD);
      double x1 = x2 + lna * Math.cos((2*d-180)*DEG2RAD);
      double y1 = y2 + lna * Math.sin((2*d-180)*DEG2RAD);
      
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[3].getX(2);
      offsets[3] = tiles[0].getY(1)-tiles[3].getY(2);
   }
}
