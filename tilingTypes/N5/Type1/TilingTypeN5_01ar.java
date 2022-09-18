package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01ar
   extends TilingType
{
   public TilingTypeN5_01ar(){
      super( "N5-1ar", 5, SymmetryType.p2 );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 10};
      paramName = new String[]{ "Relative length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,4, 0,0,4, 0},
            {1, 1,0, 1,0,1, 0},
            {0, 0,4, 2,3,4, 0},
      };
      info = "a=e\nb=2a+c\nA=90\nB=90\nE=90\n(C+D=270)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 1.;
      double h1 = w * getParam(paramValues,0)/100.;
      double h2 = (w-h1)/2;
      
      baseTile.setPoint(0,   0,   0);
      baseTile.setPoint(1,   w,   0);
      baseTile.setPoint(2,   w,  h1);
      baseTile.setPoint(3,  h2,  h2);
      baseTile.setPoint(4,   0,  h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[3].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[3].getY(3);
      offsets[2] = tiles[0].getX(1)-tiles[0].getX(3);
      offsets[3] = tiles[0].getY(1)-tiles[0].getY(3);
   }
}
