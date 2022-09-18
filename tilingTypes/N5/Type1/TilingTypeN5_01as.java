package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01as
   extends TilingType
{
   public TilingTypeN5_01as(){
      super( "N5-1as", 5, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 75};
      paramName = new String[]{ "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 2,3, 0,1,2, 1},
            {1, 1,2, 1,2,1, 1},
            {0, 1,2, 2,2,3, 0},

            {0, 3,2, 0,0,4, 1},
            {1, 2,3, 4,1,2, 0},
            {1, 1,2, 5,2,1, 0},
            {0, 1,2, 6,2,3, 1},
      };
      info = "a=e\nc=d\nE=90\nC+D=180\n2B+C=360\n(A+B=270)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = getParam(paramValues,0)/100.;
      double lna = 2-lnb;
      double h = Math.sqrt(lna*lna*2-lnb*lnb);
      // DBC = BDE = BDA+45
      // tan BDA = lnb/h = t
      // tan (DBC) = tan(BDA+45) = (tan(BDA)+tan(45)) / (1 - tan(BDA)tan(45))
      //   = (t + 1) / (1-t) = (lnb+h)/(h-lnb)
      double dx = h/2 * (lnb+h)/(h-lnb);
      
      // scale
      double f = 2. / (dx+lnb+h);
      lnb *= f;
      dx  *= f;
      h   *= f;
         
      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1, lnb,   0);
      baseTile.setPoint(2, lnb+dx,  h/2);
      baseTile.setPoint(3, lnb,   h);
      baseTile.setPoint(4, lnb/2-h/2,  h/2+lnb/2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[4].getX(0);
      offsets[1] = tiles[0].getY(3)-tiles[4].getY(0);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(3);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(3);
   }
}
