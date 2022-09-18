package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_160
   extends TilingType
{
   public TilingTypeNC5_160(){
      super( "NC5-160", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{"Indent"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,4, 0},
            {0, 3,2, 1,4,0, 0},
            {1, 0,1, 2,0,4, 0},

      };
      info = "a=b\nd=2a\nA=90\nB=D\nB+C=360\n(D+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lnab = 0.5;
      double lnd = lnab*2;

      double dx = lnab * getParam(paramValues, 0)/100;
      double dy = dx * lnab / (lnab + lnd);

      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, lnab, 0);
      baseTile.setPoint(2, lnab-dx, dy);
      baseTile.setPoint(3, lnab-dx+lnd, dy);
      baseTile.setPoint(4, 0, lnab);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[2].getX(4);
      offsets[1] = tiles[0].getY(3)-tiles[2].getY(4);
      offsets[2] = tiles[3].getX(3)-tiles[1].getX(2);
      offsets[3] = tiles[3].getY(3)-tiles[1].getY(2);
   }
}
