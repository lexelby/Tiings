package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_180
   extends TilingType
{
   public TilingTypeNC5_180(){
      super( "NC5-180", 5, SymmetryType.pgg );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{ 90,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 4,3, 1,3,4, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 4,0, 0,3,4, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 4,3, 5,3,4, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "a=c+d\ne=a+c\nA=B\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnt = 0.35;
      double b = getParam(paramValues,0);
      double lnc = lnt * getParam(paramValues,1)*2/300;
      double lnb = (lnt - lnc)*2;
      double lne = lnb + lnc; 
      double lnd = lne + lnc;
      
      double c = Math.cos(b * DEG2RAD);
      double s = Math.sin(b * DEG2RAD);
      double s2 = s * lnc*2/ lnd;
      double c2 = Math.sqrt(1-s2*s2);
      double dx = lnd * c2;
      double dy = lnd * s2;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, (lne+lnc+lnb)*c+dx, (lne+lnc-lnb)*s-dy);
      baseTile.setPoint(2, (lne+lnc)*c+dx, (lne+lnc)*s-dy);
      baseTile.setPoint(3, lne*c+dx, lne*s-dy);
      baseTile.setPoint(4, lne*c, lne*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(4)-tiles[3].getX(3);
      offsets[3] = tiles[7].getY(4)-tiles[3].getY(3);
   }
}
