package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_217
   extends TilingType
{
   public TilingTypeNC5_217(){
      super( "NC5-217", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,180,100};
      paramDef = new int[]{ 40,100, 30};
      paramName = new String[]{ "Aspect", "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,2,1, 0},
            {1, 2,1, 1,1,2, 0},
            {0, 2,1, 2,4,0, 0},

            {0, 3,4, 1,0,1, 1},
            {1, 4,0, 4,2,1, 1},
            {1, 2,1, 5,1,2, 1},
            {0, 2,1, 6,4,0, 1},
      };
      info = "b=e\na=c+d\nA+D=360\n(B+C+E=180)\n(A+B=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double lna = lnt * getParam(paramValues,0)/100;
      double lnb = lnt - lna;
      double a = getParam(paramValues,1);

      double lnd = lna * getParam(paramValues,2)/100;
      double lnc = lna - lnd;

      double diag = calcSide(lnb,lnd,a);
      double e = 180 - a - 2*calcAngle(lnb, diag, lnd);

      double c = Math.cos(a * DEG2RAD);
      double s = Math.sin(a * DEG2RAD);

      double dx = lnb*Math.cos((a+e-180)*DEG2RAD); 
      double dy = lnb*Math.sin((a+e-180)*DEG2RAD);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnb, 0);
      baseTile.setPoint(2,  lnb+lnc*c, lnc*s);
      baseTile.setPoint(3,  lna*c+dx, lna*s+dy);
      baseTile.setPoint(4,  lna*c, lna*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[4].getX(0);
      offsets[1] = tiles[1].getY(3)-tiles[4].getY(0);
      offsets[2] = tiles[5].getX(2)-tiles[3].getX(4);
      offsets[3] = tiles[5].getY(2)-tiles[3].getY(4);
   }
}
