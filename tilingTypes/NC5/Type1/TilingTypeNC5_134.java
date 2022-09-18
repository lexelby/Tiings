package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_134
   extends TilingType
{
   public TilingTypeNC5_134(){
      super( "NC5-134", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,1,2, 1},
            {1, 3,0, 1,0,3, 1},
            {0, 1,2, 2,3,4, 0},

            {0, 4,0, 0,3,4, 1},
            {1, 3,4, 4,1,2, 0},
            {1, 3,0, 5,0,3, 0},
            {0, 1,2, 6,3,4, 1},
      };
      info = "a=e=2b\nb=d\nC+E=180\nB+C=360\n(A+D+E=180)\n(D=E)";
   }

   public void recalcBase(double[] paramValues) {
      double lnac = .5;
      double lnde = lnac*2;
      double lnb = lnde * getParam(paramValues,0)/100;

      double c = (lnde-lnb)/2/lnde;
      double s = Math.sqrt(1-c*c);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,lnac,  0);
      baseTile.setPoint(2,lnac+c*lnb, -s*lnb);
      baseTile.setPoint(3,2*lnac+c*lnb, -s*lnb);
      baseTile.setPoint(4,2*lnac+c*lnb-c*lnde, -s*lnb+s*lnde);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(0)-tiles[3].getX(4);
      offsets[3] = tiles[7].getY(0)-tiles[3].getY(4);
   }
}
