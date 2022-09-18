package tilingTypes.NC6.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_93a
   extends TilingType
{
   public TilingTypeNC6_93a(){
      super( "NC6-93a", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0,  0,  0,  0};
      paramMax = new int[]{100,180,180,100,100,100};
      paramDef = new int[]{ 30, 70, 60, 40, 30, 40};
      paramName = new String[]{ "Aspect", "Angle 1", "Angle 2", "Relative Length 1", "Relative Length 2", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
      };
      info = "a=e\nA+D=360\nB+C=180\n(E+F=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.8;
      double lnh = lnt * getParam(paramValues,0)/100;
      double w = lnt-lnh;
      double lnac = w * getParam(paramValues,3)/100;
      double lndf = w - lnac;
      double lna = lnac * getParam(paramValues,4)/100;
      double lnc = lnac - lna;
      double lnf = lndf/2;
      double lnd = lndf/2;
      
      double a1 = getParam(paramValues,1);
      double a2 = getParam(paramValues,2);

      double c1 = Math.cos(a1*DEG2RAD);
      double s1 = Math.sin(a1*DEG2RAD);
      double c2 = Math.cos(a2*DEG2RAD);
      double s2 = Math.sin(a2*DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, s1*lna, c1*lna);
      baseTile.setPoint(2, s1*lnc, lnh + c1*lnc);
      baseTile.setPoint(3, 0, lnh );
      baseTile.setPoint(4, -s2*lnd, lnh + c2*lnd);
      baseTile.setPoint(5, -s2*lnf, c2*lnf);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = getParam(paramValues,5)/100;
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(4)-tiles[0].getX(5) + os * offsets[0];
      offsets[3] = tiles[1].getY(4)-tiles[0].getY(5) + os * offsets[1];
   }
}