package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ba
   extends TilingType
{
   public TilingTypeN5_01ba(){
      super( "N5-1ba", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{120};
      paramDef = new int[]{100};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 1,0, 0,0,1, 0},
            {0, 1,0, 0,2,3, 0},
            {0, 1,0, 1,2,3, 0},
      };
      info = "b=d=a+c\nB=D\nC=E\nA+B=180\n(D+2E=360)";
   }
   
  
   public void recalcBase(double[] paramValues) {
      double ce = getParam(paramValues,0);
      double a = 180-ce;
      double bd = 180-ce/2;

      //  f * sin(b) + 1 * sin(a+b-180) = 1 * sin(c) + (1-f) * sin(c+d-180)
      double s1 = Math.sin(bd * DEG2RAD);
      double s2 = Math.sin((a+bd-180) * DEG2RAD);
      double s3 = Math.sin(ce * DEG2RAD);
      double s4 = Math.sin((ce+bd-180) * DEG2RAD);
      //  f * s1 + s2 = s3 + (1-f) * s4
      //  f * (s1 + s4) = s3 -s2 + s4
      double f = (s3-s2+s4) / (s1+s4);
     
      double lna = f;
      double lnd = 1-f;
      double lnce = 1;
      
      //scale
      f = 1.7 / (lna + lnce);
      lna *= f;
      lnd *= f;
      lnce *= f;
      
      double x4 =       lna*Math.cos(a * DEG2RAD);
      double y4 =       lna*Math.sin(a * DEG2RAD);
      double x2 = lnce+ lnd*Math.cos(a * DEG2RAD);
      double y2 =       lnd*Math.sin(a * DEG2RAD);
      double x3 = x2 +  lnce*Math.cos((a+180-bd) * DEG2RAD);
      double y3 = y2 +  lnce*Math.sin((a+180-bd) * DEG2RAD);
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lnce,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(4)-tiles[3].getX(3);
      offsets[1] = tiles[2].getY(4)-tiles[3].getY(3);
      offsets[2] = tiles[0].getX(4)-tiles[2].getX(3);
      offsets[3] = tiles[0].getY(4)-tiles[2].getY(3);
   }
}
