package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_98
   extends TilingType
{
   public TilingTypeNC6_98(){
      super( "NC6-98", 6, SymmetryType.p1 );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{100,180,100,100};
      paramDef = new int[]{ 60, 80, 30, 50};
      paramName = new String[]{ "Aspect", "Angle", "X", "Y" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
      };
      info = "a=c+e\nb=d+f\nA+B=180\nB=F\nC=A\nE=A\n(D+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.8;
      double lnb = lnt * getParam(paramValues,0)/100;
      double lna = lnt-lnb;
      double lnd = lnb * getParam(paramValues,2)/100;
      double lne = lna * getParam(paramValues,3)/100;
      double a = getParam(paramValues,1);
      double s = Math.sin(a*DEG2RAD);
      double c = Math.cos(a*DEG2RAD);
     
      double x5 = lna * c;
      double y5 = lna * s;
      double x4 = x5+lnb-lnd;
      double y4 = y5;
      double x1 = lnb;
      double y1 = 0;
      double x2 = x1 + (lna-lne)*c;
      double y2 = y1 + (lna-lne)*s;
      double x3 = x2 - lnd;
      double y3 = y2;
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,  x1, y1);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
      baseTile.setPoint(5,  x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(4)-tiles[0].getX(1);
      offsets[3] = tiles[0].getY(4)-tiles[0].getY(1);
   }
}