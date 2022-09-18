package tilingTypes.NC5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

abstract public class TilingTypeNC5_63
   extends TilingType
{
   protected TilingTypeNC5_63(String n, int c, SymmetryType t){
      super( n,c,t );
      info = "b=d\nc=e\nB+D=360\n(A+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = 2. * paramValues[0]/100;   // base length
      double lnh = 2 - lnb; // height
      double lnx1 = lnh * paramValues[1]/100; // x of point
      double lny1 =(1-lnx1/lnh)*lnb* (50-paramValues[2])/100;

      double x1 = lnh - lnx1;
      double y1 = lny1;
      double x2 = lnh;
      double y2 = lnb/2;
      double x3 = lnx1;
      double y3 = lnb/2 + lny1;
      double x4 = 0;
      double y4 = lnb;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
}
