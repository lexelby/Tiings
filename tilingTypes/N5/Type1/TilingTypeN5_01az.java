package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01az
   extends TilingType
{
   public TilingTypeN5_01az(){
      super( "N5-1az", 5, SymmetryType.pgg );

      paramMin = new int[]{ 60};
      paramMax = new int[]{120};
      paramDef = new int[]{100};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,1,0, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 1,0, 2,4,0, 0},

            {0, 4,0, 0,1,2, 1},
            {1, 4,0, 4,1,0, 1},
            {1, 1,0, 5,0,1, 1},
            {0, 1,0, 6,4,0, 1},
      };
      info = "a+c=b\na+d=c\nB=C\nD=E\nA+B=180\n(B+2E=360)";
   }
   
  
   public void recalcBase(double[] paramValues) {
      double ae = getParam(paramValues,0);
      double d = 180-ae;
      double bc = 180-ae/2;

      //  f * sin(b) + 1 * sin(a+b-180) = (1-f) * sin(c) + (2-f) * sin(c+d-180)
      double s1 = Math.sin(bc * DEG2RAD);
      double s2 = Math.sin((ae+bc-180) * DEG2RAD);
      double s3 = Math.sin((bc+d-180) * DEG2RAD);
      //  f * s1 + s2 = (1-f) * s1 + (2-f) * s3)
      //  f * (2s1+s3) = s1 - s2 + 2s3
      double f = (s1-s2+2*s3) / (2*s1+s3);
     
      double lna = f;
      double lnc = 1-f;
      double lne = 1;
      double lnd = 2-f;
      
      //scale
      f = 1.7 / (lnd + lne);
      lna *= f;
      lnc *= f;
      lnd *= f;
      lne *= f;
      
      double x4 =       lnc*Math.cos(d * DEG2RAD);
      double y4 =       lnc*Math.sin(d * DEG2RAD);
      double x2 = lnd + lne*Math.cos(d * DEG2RAD);
      double y2 =       lne*Math.sin(d * DEG2RAD);
      double x3 = x2 +  lna*Math.cos((-ae-ae) * DEG2RAD);
      double y3 = y2 +  lna*Math.sin((-ae-ae) * DEG2RAD);
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, lnd,  0);
      baseTile.setPoint(2,  x2, y2);
      baseTile.setPoint(3,  x3, y3);
      baseTile.setPoint(4,  x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[3].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[3].getY(3);
      offsets[2] = tiles[0].getX(4)-tiles[4].getX(1);
      offsets[3] = tiles[0].getY(4)-tiles[4].getY(1);
   }
}
