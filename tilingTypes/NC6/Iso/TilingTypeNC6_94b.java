package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_94b
   extends TilingType
{
   public TilingTypeNC6_94b(){
      super( "NC6-94b", 6, SymmetryType.cmm );

      paramMin = new int[]{  0,  0,  0,  0,  0};
      paramMax = new int[]{100,180,180,100,100};
      paramDef = new int[]{ 30, 70, 60, 40, 30};
      paramName = new String[]{ "Aspect", "Angle 1", "Angle 2", "Relative Length 1", "Relative Length 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 5,4, 0,4,5, 0},

            {0, 2,3, 1,2,3, 1},
            {0, 5,4, 2,4,5, 1},
      };
      info = "a+e=c\nA+B=360\nC+D=180\n(E+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.8;
      double lnh = lnt * getParam(paramValues,0)/100;
      double w = lnt-lnh;
      double lna = w * getParam(paramValues,3)/100;
      double lnbdf = w - lna;
      double lndf = lnbdf /2;
      double lnb = lnbdf /2;
     
      double lnd = lndf * getParam(paramValues,4)/100;
      double lnf = lndf - lnd;
      
      double a1 = getParam(paramValues,1);
      double a2 = getParam(paramValues,2);

      double c1 = Math.cos(a1*DEG2RAD);
      double s1 = Math.sin(a1*DEG2RAD);
      double c2 = Math.cos(a2*DEG2RAD);
      double s2 = Math.sin(a2*DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, s1*lna, c1*lna);
      baseTile.setPoint(2, s1*lna+s2*lnb, c1*lna-c2*lnb);
      baseTile.setPoint(3, s1*lna+s2*lndf, c1*lna-c2*lndf + lnh );
      baseTile.setPoint(4, s1*lna+s2*lnf, c1*lna-c2*lnf + lnh );
      baseTile.setPoint(5, -s2*lnf, c2*lnf);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[3].getX(2);
      offsets[3] = tiles[0].getY(2)-tiles[3].getY(2);
   }
}