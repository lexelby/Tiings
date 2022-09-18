package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_178
   extends TilingType
{
   public TilingTypeNC5_178(){
      super( "NC5-178", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,0,1, 1},
            {1, 0,3, 1,3,0, 1},
            {0, 0,1, 2,4,0, 0},

            {0, 3,2, 0,0,4, 1},
            {1, 4,0, 4,0,1, 0},
            {1, 0,3, 5,3,0, 0},
            {0, 0,1, 6,4,0, 1},
      };
      info = "a=b=d\nB=E\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnabd = 0.8;
      double be = getParam(paramValues,0);

      double lnc = lnabd * getParam(paramValues,1)/100;
      
      double diag = calcSide(2*lnabd, lnc, be);
      double ang = 180 - be - Math.asin(Math.sin(be*DEG2RAD)/diag*lnabd)/DEG2RAD;
      double a = ang + calcAngle(2*lnabd,diag,lnc);

      double dx = lnc * Math.cos(be * DEG2RAD);
      double dy = lnc * Math.sin(be * DEG2RAD);
      double x4 = lnabd * Math.cos(a * DEG2RAD);
      double y4 = lnabd * Math.sin(a * DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, lnabd, 0);
      baseTile.setPoint(2, lnabd-dx, dy);
      baseTile.setPoint(3, lnabd*2-dx, dy);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[4].getX(4)-tiles[0].getX(2);
      offsets[1] = tiles[4].getY(4)-tiles[0].getY(2);
      offsets[2] = tiles[7].getX(4)-tiles[3].getX(2);
      offsets[3] = tiles[7].getY(4)-tiles[3].getY(2);
   }
}
