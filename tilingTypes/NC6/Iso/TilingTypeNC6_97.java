package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_97
   extends TilingType
{
   public TilingTypeNC6_97(){
      super( "NC6-97", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0,  0,  0,  0};
      paramMax = new int[]{100,180,180,100,100,100};
      paramDef = new int[]{ 60,100, 70, 70, 40, 80};
      paramName = new String[]{ "Aspect", "Angle 1", "Angle 2", "Relative Length", "X", "Y" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 5,2, 0,2,5, 0},
      };
      info = "d=f\nD+E=360\n(A+B+C+F=360)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.8;
      double lnb = lnt * getParam(paramValues,0)/100;
      double lnac = lnt-lnb;
      double lna = 2*lnac * getParam(paramValues,3)/100;
      double lnc = 2*lnac - lna;
      
      double a = getParam(paramValues,1);
      double b = getParam(paramValues,2);

      double x = getParam(paramValues,4)/100;
      double y = getParam(paramValues,5)/100;
     
      double x5 = lna * Math.cos(a*DEG2RAD);
      double y5 = lna * Math.sin(a*DEG2RAD);
      double x2 = lnb + lnc * Math.cos(b*DEG2RAD);
      double y2 =       lnc * Math.sin(b*DEG2RAD);
      double px = lnb*x;
      double py = 0;
      double qx = x5*(1-x) + x2*x;
      double qy = y5*(1-x) + y2*x;
      double x3 = px*(1-y) + qx*y;
      double y3 = py*(1-y) + qy*y;
      double x4 = x5 + (x2-x3);
      double y4 = y5 + (y2-y3);
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lnb,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
      baseTile.setPoint(5,  x5, y5);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(1)-tiles[0].getY(0);
   }
}