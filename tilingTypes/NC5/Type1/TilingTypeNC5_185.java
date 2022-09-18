package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_185
   extends TilingType
{
   public TilingTypeNC5_185(){
      super( "NC5-185", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 80, 40};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 4,1, 1,1,4, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 2,3, 1,0,4, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 4,1, 5,1,4, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "a=d\nc=e\n2B+E=C\nC+D=360\n(A+B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lnt = 1.8;
      double a = getParam(paramValues,0);
      double lnad = lnt * getParam(paramValues,1)/100;
      double cs = Math.cos(a*DEG2RAD);
      double max = a==90 ? lnt : lnt / (2*Math.abs(cs)+1);
      max = Math.min(lnt, max) - 1e-8;
      lnad = Math.min(lnad, max);
      double lnb = lnt - lnad;
      
      double diag = calcSide(lnad, lnb, a);
      double b2 = calcAngle(diag,lnb,lnad);
      double b3 = b2 + 180 - a;
      double alpha = Math.atan2(Math.sin(b3*DEG2RAD),diag/lnad-Math.cos(b3*DEG2RAD))/DEG2RAD;
      double b = b2 + alpha;
      double c = b+180-a;
      double lnce =calcSide(diag, lnad, 180-alpha-c )/2;

      double x4 = lnad * cs;
      double y4 = lnad * Math.sin(a * DEG2RAD);
      double dx = lnce * Math.cos(b * DEG2RAD);
      double dy = lnce * Math.sin(b * DEG2RAD);

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lnb, 0);
      baseTile.setPoint(2, lnb -dx, dy);
      baseTile.setPoint(3, x4 + dx, y4 - dy);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[3].getX(4);
      offsets[1] = tiles[0].getY(0)-tiles[3].getY(4);
      offsets[2] = tiles[7].getX(3)-tiles[0].getX(1);
      offsets[3] = tiles[7].getY(3)-tiles[0].getY(1);
   }
}
