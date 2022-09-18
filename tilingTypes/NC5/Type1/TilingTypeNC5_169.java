package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_169
   extends TilingType
{
   public TilingTypeNC5_169(){
      super( "NC5-169", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,2,3, 0},
            {0, 0,1, 0,1,0, 0},
            {1, 0,4, 2,2,3, 0},
      };
      info = "a=d\nb=a+c\nA=B\nA=E\nB+C=360\n(D+2E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = 1.2;
      double lnd =  lnb * getParam(paramValues,0)/300;

      double lnac = lnd + lnb*(3 + 5*lnb/(lnd-2*lnb));
      double lne = lnac + lnd;

      double c = (lnac - lnd) / lnb /2;
      double s = Math.sqrt(1-c*c);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lne, 0);
      baseTile.setPoint(2,  lne-lnd*c, lnd*s);
      baseTile.setPoint(3,  lne-lnd*c+lnac, lnd*s);
      baseTile.setPoint(4,  lnac*c, lnac*s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[3].getX(2);
      offsets[1] = tiles[1].getY(1)-tiles[3].getY(2);
      offsets[2] = tiles[0].getX(3)-tiles[2].getX(4);
      offsets[3] = tiles[0].getY(3)-tiles[2].getY(4);
   }
}
