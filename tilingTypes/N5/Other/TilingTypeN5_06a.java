package tilingTypes.N5.Other;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_06a
   extends TilingType
{
   public TilingTypeN5_06a(){
      super( "N5-6a: Richard B. Kershner, 1968", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{141};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Angle" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
            {1, 2,1, 0,0,1, 0},
            {1, 1,0, 2,0,1, 0},
      };
      info = "a=d=e\nb=c\nB+D=180\n2B=E\n(A+C+E=360)";
   }

   public void recalcBase(double[] paramValues) {
      double a = paramValues[0];
      double c = 2*a;
      double d = 180-a;

      double ln2 = 2 * Math.sin( a/2. * DEG2RAD); // diagonal

      // Given 3 equal sides of length 1 with angles c, d between them, what is fourth side?
      //  First get length of diagonal - base of triangle with angle d between sides of length 1.
      double lna = 2*Math.sin(d/2  * DEG2RAD);
      //  get third side of triangle with angle c-(180-d)/2 = 3a/2 between sides 1 and lna
      double lnb = calcSide(1,lna,3*a/2);

      // get actual length of other sides - scale side of length 1 by factor that makes diagonal match
      double ln3 = ln2/lnb;

      // get other angles
      double s = Math.sin(a*3./2 * DEG2RAD)/lnb*lna;
      double t = a<60 ?  calcAngle(1,lnb,lna) : Math.asin(s)/ DEG2RAD ;
      double b = 90-a/2 + t;

      double x4 =      ln3 * Math.cos( (b) * DEG2RAD);
      double y4 =      ln3 * Math.sin( (b) * DEG2RAD);
      double x3 = x4 + ln3 * Math.cos( (b-180+c) * DEG2RAD);
      double y3 = y4 + ln3 * Math.sin( (b-180+c) * DEG2RAD);
      double x2 = x3 + ln3 * Math.cos( (b+c+d) * DEG2RAD);
      double y2 = y3 + ln3 * Math.sin( (b+c+d) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,  1,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(4)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(4)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[2].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[2].getY(0);
   }
}

