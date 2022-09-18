package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_190a
   extends TilingType
{
   public TilingTypeNC5_190a(){
      super( "NC5-190a", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 70, 70};
      paramName = new String[]{ "Relative Length 1", "Relative Length 2"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,3,2, 0},
            {1, 1,4, 1,4,1, 0},
            {0, 3,2, 2,0,1, 0},

            {0, 1,2, 0,4,0, 1},
            {1, 0,1, 4,3,2, 1},
            {1, 1,4, 5,4,1, 1},
            {0, 3,2, 6,0,1, 1},
      };
      info = "b=d\nc=e\nA=C\nC+D=360\n(A+B+E=180)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lnt = 1.5;
      double lna = lnt * getParam(paramValues,1)/200;
      double lnb = lnt - lna;
      
      double mine = lna/2;
      double maxe = lna * lnb*lnb/(lna*lna+lnb*lnb);
      double lne = mine + (maxe-mine)*getParam(paramValues,0)/100;

      double a = Math.acos((lna*lna-4*lne*lne)/(2*lnb*(lna-2*lne))) / DEG2RAD;

      double diag = calcSide(lna, lnb, a);
      double b1 = calcAngle(lnb, diag, lna);
      double m = 180-2*a-2*b1;
      double dx1 = lna * Math.cos(a * DEG2RAD);
      double dy1 = lna * Math.sin(a * DEG2RAD);
      double dx2 = lnb/2 * Math.cos(m * DEG2RAD);
      double dy2 = lnb/2 * Math.sin(m * DEG2RAD);
      double xm = (lnb+dx1)/2;
      double ym = dy1/2;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lnb, 0);
      baseTile.setPoint(2, xm+dx2, ym+dy2);
      baseTile.setPoint(3, xm-dx2, ym-dy2);
      baseTile.setPoint(4, dx1, dy1);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[4].getX(0)-tiles[3].getX(4);
      offsets[3] = tiles[4].getY(0)-tiles[3].getY(4);
   }
}
