package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_188
   extends TilingType
{
   public TilingTypeNC5_188(){
      super( "NC5-188", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{ 90,100};
      paramDef = new int[]{ 65, 30};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,4, 0,4,3, 0},
            {1, 3,4, 0,1,0, 0},
            {1, 3,0, 2,0,3, 0},
      };
      info = "b=d\ne=2b\nB=E\nB+C=360\n(A+D+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double lnb = lnt * getParam(paramValues,1)/200;
      double lnd = lnt - lnb;
      double lna = lnd/2;
      double b = getParam(paramValues,0);

      double diag = calcSide(lnd, lnb, b);
      double a1 = calcAngle(lnd, diag,lnb);
      double a2 = Math.asin(Math.sin(b * DEG2RAD)*lnd/diag)/DEG2RAD;
      double a = a1 + a2;
      double d = 180-b-a;

      double dx1 = lnb * Math.cos(b * DEG2RAD);
      double dy1 = lnb * Math.sin(b * DEG2RAD);
      double dx2 = lnd * Math.cos(d * DEG2RAD);
      double dy2 = lnd * Math.sin(d * DEG2RAD);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lna, 0);
      baseTile.setPoint(2, lna-dx1, dy1);
      baseTile.setPoint(3, lnd-dx1, dy1);
      baseTile.setPoint(4, lnd-dx1-dx2, dy1+dy2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(2)-tiles[3].getX(4);
      offsets[3] = tiles[1].getY(2)-tiles[3].getY(4);
   }
}
