package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_211
   extends TilingType
{
   public TilingTypeNC5_211(){
      super( "NC5-211", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0,  0};
      paramMax = new int[]{180,100,100,100};
      paramDef = new int[]{ 70, 40, 80, 70};
      paramName = new String[]{ "Angle", "Relative length 1", "Indent", "Relative length 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,3, 0,3,4, 0},
            {1, 2,1, 1,1,2, 0},
            {0, 4,3, 2,3,4, 0},

            {0, 2,1, 0,1,0, 1},
            {1, 4,3, 4,3,4, 1},
            {1, 2,1, 5,1,2, 1},
            {0, 4,3, 6,3,4, 1},
      };
      info = "c=b+d\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.6;
      double lna = lnt * getParam(paramValues,1)/100;
      double lnb = lnt - lna;
      double a = getParam(paramValues,0);

      double diag = calcSide(lna, lnb, a);
      double mid = diag * getParam(paramValues,3)/100;
      double ang1 = calcAngle(lnb, diag, lna);
      double maxtan1 = ang1>=90 ? lnt*2/diag : Math.tan(ang1 * DEG2RAD);
      double ang2 = 180-ang1-a;
      double maxtan2 = ang2>=90 ? lnt*2/diag : Math.tan(ang2 * DEG2RAD);
      
      double minind = mid/2 * Math.min(maxtan1, maxtan2*(diag*2-mid)/mid );
      double maxind = mid/2 * Math.min(maxtan2, maxtan1*(diag+mid)/(diag-mid) );

      double t = getParam(paramValues,2)/50 - 1;
      double ind = t<0 ? t * maxind : t * minind;
      
      double x4 =       lnb * Math.cos(ang1 * DEG2RAD);
      double y4 =       lnb * Math.sin(ang1 * DEG2RAD);

      baseTile.setPoint(0,  0, 0 );
      baseTile.setPoint(1,  mid/2, ind );
      baseTile.setPoint(2,  (diag+mid)/2, -ind *(diag-mid)/mid );
      baseTile.setPoint(3,  diag, 0 );
      baseTile.setPoint(4,  x4, y4 );
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(1)-tiles[7].getX(2);
      offsets[3] = tiles[3].getY(1)-tiles[7].getY(2);
   }
}
