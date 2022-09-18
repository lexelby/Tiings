package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_92
   extends TilingType
{
   public TilingTypeNC6_92(){
      super( "NC6-92", 6, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0,  0,  0};
      paramMax = new int[]{100,180,180,100,100};
      paramDef = new int[]{ 30, 70, 60, 30, 40};
      paramName = new String[]{ "Aspect", "Angle 1", "Angle 2", "Relative Length 1", "Relative Length 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 4,3, 0,3,4, 0},
            {0, 0,1, 1,1,2, 1},
            {0, 4,3, 2,3,4, 1},
      };
      info = "b=a+c\nA+B=360\nD+E=180\n(C+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.8;
      double lnh = lnt * getParam(paramValues,0)/100;
      double w = lnt-lnh;
      double lna = w/2;
      double lnbf = w/2;
      double lnf = lnbf * getParam(paramValues,4)/100;
      double lnb = lnbf - lnf;

      double r = getParam(paramValues,3)/100;
      
      double a1 = getParam(paramValues,1);
      double a2 = getParam(paramValues,2);

      double c1 = Math.cos(a1*DEG2RAD);
      double s1 = Math.sin(a1*DEG2RAD);
      double c2 = Math.cos(a2*DEG2RAD);
      double s2 = Math.sin(a2*DEG2RAD);
      
      double dx = (lnf-lnb)*s2;
      double dy = lnh - (lnf-lnb)*c2;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, s1*lna, c1*lna);
      baseTile.setPoint(2, s1*lna+s2*lnb, c1*lna-c2*lnb);
      baseTile.setPoint(3, s1*lna+s2*lnb+r*dx, c1*lna-c2*lnb+r*dy);
      baseTile.setPoint(4, -s2*lnf+(1-r)*dx, c2*lnf+(1-r)*dy);
      baseTile.setPoint(5, -s2*lnf, c2*lnf);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(5);
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(5);
   }
}