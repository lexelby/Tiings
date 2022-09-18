package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_139
   extends TilingType
{
   public TilingTypeNC5_139(){
      super( "NC5-139", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,0, 0,2,3, 0},
            {1, 3,2, 0,3,4, 0},
            {1, 4,0, 2,0,4, 0},
      };
      info = "d=e\nb=2d\nB=E\nD=90\nB+C=360\n(A+E=90)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = .5;
      double w = 2 * lnb * getParam(paramValues,0)/100;
      double t = (lnb+w)/lnb;
      double h = lnb*(3-t)/(t+1/t);

      baseTile.setPoint(0,  0, 0);
      baseTile.setPoint(1,  lnb*2, 0);
      baseTile.setPoint(2,  lnb*2 - h/t, h);
      baseTile.setPoint(3,  lnb*3 - h/t, h);
      baseTile.setPoint(4,  lnb*3 - h/t, h+lnb);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(4)-tiles[2].getX(1);
      offsets[1] = tiles[2].getY(4)-tiles[2].getY(1);
      offsets[2] = tiles[3].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(4)-tiles[0].getY(0);
   }
}
