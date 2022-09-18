package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_184
   extends TilingType
{
   public TilingTypeNC5_184(){
      super( "NC5-184", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{180,100};
      paramDef = new int[]{ 70, 50};
      paramName = new String[]{ "Angle", "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {1, 2,3, 0,4,3, 0},
            {1, 3,4, 2,4,3, 0},
      };
      info = "b+c=d\nc+d=e\nC=D\nB+C=360\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = 1.0;
      double b = getParam(paramValues,0);
      double c = Math.cos(b * DEG2RAD);
      double s = Math.sin(b * DEG2RAD);
      
      double maxe = b>=60 ? lnb : lnb / (4*c-1);
      double lne = maxe * getParam(paramValues,1)/100;
      double lnd = (lnb - lne)/2;
      double lna = lnd + lne;

      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lnd, 0);
      baseTile.setPoint(2, lnd-c*lne, -s*lne);
      baseTile.setPoint(3, lnd+lna-c*lne, -s*lne);
      baseTile.setPoint(4, lnd+lna-c*(lne+lnb), s*(lnb-lne));
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(3)-tiles[2].getX(0);
      offsets[1] = tiles[2].getY(3)-tiles[2].getY(0);
      offsets[2] = tiles[3].getX(1)-tiles[1].getX(3);
      offsets[3] = tiles[3].getY(1)-tiles[1].getY(3);
   }
}
