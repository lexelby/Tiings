package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_272
   extends TilingType
{
   public TilingTypeNC5_272(){
      super( "NC5-272", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {2, 0,0, 0,0,0, 0},
            {0, 1,0, 0,0,1, 0},
            {1, 1,0, 1,3,4, 0},
            {1, 4,0, 2,0,4, 0},
            {0, 3,4, 3,1,0, 0},
            {2, 0,1, 4,1,0, 0},
      };
      info = "b=c+e\ne=c+d\nB+D=180\nC+D=360\n(A+B+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = .6;
      double lnd = lnb * getParam(paramValues, 1)/100;
      double lnc = (lnb-lnd)/2;
      double lne = lnc+lnd;
      double b = getParam(paramValues, 0);

      double c1 = Math.cos(b*DEG2RAD);
      double s1 = Math.sin(b*DEG2RAD);
      double c2 = Math.cos(2*b*DEG2RAD);
      double s2 = Math.sin(2*b*DEG2RAD);
      
      double x2 = lnb - lnc * c1;
      double y2 =       lnc * s1;
      double x3 = x2  - lnd * c2;
      double y3 = y2  + lnd * s2;
      double x4 = x3  - lne * c1;
      double y4 = y3  + lne * s1;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, lnb,  0);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[5].getX(2)-tiles[0].getX(3);
      offsets[3] = tiles[5].getY(2)-tiles[0].getY(3);
   }
}
