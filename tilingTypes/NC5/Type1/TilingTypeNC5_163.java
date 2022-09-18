package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_163
   extends TilingType
{
   public TilingTypeNC5_163(){
      super( "NC5-163", 5, SymmetryType.pg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 30};
      paramName = new String[]{"Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 4,0, 0,4,3, 0},
            {0, 4,0, 1,4,3, 0},
            {1, 4,0, 2,4,3, 0},
      };
      info = "a=e\nb=c+d\nB=90\nC=270\nE=90\n(A+D=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = .8;
      double lnd = lnb * getParam(paramValues,0)/100;
      double lnc = lnb - lnd;
     
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, lnb, 0);
      baseTile.setPoint(2, lnb, lnc);
      baseTile.setPoint(3, lnb+lnd, lnc);
      baseTile.setPoint(4, lnd, lnb);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(0)-tiles[1].getX(2);
      offsets[1] = tiles[0].getY(0)-tiles[1].getY(2);
      offsets[2] = tiles[1].getX(0)-tiles[3].getX(1);
      offsets[3] = tiles[1].getY(0)-tiles[3].getY(1);
   }
}
