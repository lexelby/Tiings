package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_132
   extends TilingType
{
   public TilingTypeNC5_132(){
      super( "NC5-132", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Relative Length"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,1, 0,1,2, 0},
            {1, 0,3, 0,4,2, 1},
            {1, 1,0, 0,0,4, 1},

            {0, 0,1, 2,2,1, 1},
            {0, 2,1, 4,1,2, 1},
            {1, 0,3, 4,4,2, 0},
            {1, 1,0, 4,0,4, 0},
      };
      info = "a=d=e\nb=a+c\nA+E=180\nD+E=360\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lntotal = 1.5;
      double lncde = lntotal * getParam(paramValues,0)/200;
      double lnb = lntotal - lncde;
      double h = Math.sqrt(lnb*lnb-lncde*lncde);
      double dx = lncde/lnb * lncde;
      double dy = lncde/lnb * h;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,lncde+lnb,  0);
      baseTile.setPoint(2,lncde+2*dx,2*dy);
      baseTile.setPoint(3,lncde+dx,dy);
      baseTile.setPoint(4,dx,dy);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(2)-tiles[0].getX(0);
      offsets[1] = tiles[6].getY(2)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(3)-tiles[0].getX(1);
      offsets[3] = tiles[3].getY(3)-tiles[0].getY(1);
   }
}
