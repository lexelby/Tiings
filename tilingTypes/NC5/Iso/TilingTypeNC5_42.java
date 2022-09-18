package tilingTypes.NC5.Iso;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_42
   extends TilingType
{
   public TilingTypeNC5_42(){
      super( "NC5-42: Generic Type 2", 5, SymmetryType.pgg );
// TODO: rewrite to allow b>e
      paramMin = new int[]{  0, 45,  0,  0};
      paramMax = new int[]{100,270,100,400};
      paramDef = new int[]{ 40, 90, 35, 65};
      paramName = new String[]{ "Aspect", "Angle", "Relative Length", "Relative Length 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
            {0, 4,0, 1,2,3, 1},
            {0, 2,1, 2,1,2, 1},
      };
      info = "a=d\nA+D=360\n(B+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = paramValues[0]/100.;
      double h = 1-w;
      double diag = Math.sqrt(h*h/4 + w*w);
      double ang = Math.atan2(w,h/2)/DEG2RAD;

      double b = paramValues[1];
      double ln1 = paramValues[2]/100.;
      double ln2 = 1-ln1;
      double fac = calcSide(ln1, ln2, b);
      ln1 *= diag/fac;
      ln2 *= diag/fac;
      double x = paramValues[2]==0 ? 180-b : calcAngle(diag, ln1, ln2);
      if( b>=180) x=-x;
      double y = 180-b-x;

      double c = 180-ang-ang+y-x;
      double d = 360-b;

      double lnr = (ln1+ln2) * paramValues[3]/100.;
      double ln3 = ln1 + lnr;
      double ln4 = calcSide(lnr, h, 180-ang-x);
      double f =  paramValues[3]==0 ? ang+x : calcAngle( lnr, ln4, h);
      double e = 540-b-c-d-f;
      fac = 2.5 / (ln1+ln3+h);
      ln1 *= fac;
      ln2 *= fac;
      ln3 *= fac;
      ln4 *= fac;

      double x2 = ln3+ ln4 * Math.cos( (180-f) * DEG2RAD);
      double y2 =      ln4 * Math.sin( (180-f) * DEG2RAD);
      double x3 = x2 + ln2 * Math.cos( (-f-e) * DEG2RAD);
      double y3 = y2 + ln2 * Math.sin( (-f-e) * DEG2RAD);
      double x4 = x3 + ln1 * Math.cos( (180-f-e-d) * DEG2RAD);
      double y4 = y3 + ln1 * Math.sin( (180-f-e-d) * DEG2RAD);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln3,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(3)-tiles[1].getX(0);
      offsets[1] = tiles[2].getY(3)-tiles[1].getY(0);
      offsets[2] = tiles[3].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(3)-tiles[0].getY(0);
   }
}
