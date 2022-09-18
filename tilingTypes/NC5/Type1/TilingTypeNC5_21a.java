package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_21a
   extends TilingType
{
   public TilingTypeNC5_21a(){
      super( "NC5-21a", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{180,100,100};
      paramDef = new int[]{ 70, 40, 60};
      paramName = new String[]{ "Angle", "Aspect", "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,0,4, 0},
            {1, 4,1, 1,1,4, 0},
            {0, 4,0, 2,0,4, 0},
      };
      info = "c=e\nB+C=180\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.6;
      double lna = lnt * getParam(paramValues,1)/100;
      double lnb = lnt - lna;
      double a = getParam(paramValues,0);

      double lnd = lnb * getParam(paramValues,2)/100;

      double c = Math.cos(a * DEG2RAD);
      double s = Math.sin(a * DEG2RAD);

      baseTile.setPoint(0,  0, 0 );
      baseTile.setPoint(1,  lnb, 0 );
      baseTile.setPoint(2,  (lna*c + lnb + lnd)/2, lna/2*s );
      baseTile.setPoint(3,  (lna*c + lnb - lnd)/2, lna/2*s );
      baseTile.setPoint(4,  lna*c, lna*s );
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[3].getX(2);
      offsets[1] = tiles[0].getY(1)-tiles[3].getY(2);
      offsets[2] = tiles[0].getX(4)-tiles[3].getX(3);
      offsets[3] = tiles[0].getY(4)-tiles[3].getY(3);
   }
}
