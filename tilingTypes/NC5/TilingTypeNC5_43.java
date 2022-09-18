package tilingTypes.NC5;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

abstract public class TilingTypeNC5_43
   extends TilingType
{
   protected TilingTypeNC5_43(String n, SymmetryType t){
      super( n, 7, t );
      info = "c=e\nC+D=360\n(A+B+E=180)";
      labels = new int[]{0,-1,-1,1,2,3,4};
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.6;
      double lna = lnt * getParam(paramValues,1)/100;
      double lnb = lnt - lna;
      double a = getParam(paramValues,0);

      double x = lnb * getParam(paramValues,2)/100;
      double y = lna * getParam(paramValues,3)/100;
      double c = Math.cos(a * DEG2RAD);
      double s = Math.sin(a * DEG2RAD);
      double os = paramValues.length>4 ? lnb * getParam(paramValues,4)/100 : 0;

      baseTile.setPoint(0,  0, 0 );
      baseTile.setPoint(1,  os, 0 );
      baseTile.setPoint(2,  lnb/2, 0 );
      baseTile.setPoint(3,  lnb, 0 );
      baseTile.setPoint(4,  x + y*c, y*s );
      baseTile.setPoint(5,  lnb-x + (lna-y)*c, (lna-y)*s );
      baseTile.setPoint(6,  lna*c, lna*s );
   }
}
