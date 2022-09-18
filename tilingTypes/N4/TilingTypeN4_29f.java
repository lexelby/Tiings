package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_29f
   extends TilingType
{
   public TilingTypeN4_29f(){
      super( "N4-29f", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 58};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 1,0, 0,2,3, 0},
            {0, 0,1, 0,0,1, 1},
            {0, 1,0, 0,1,2, 0},

            {1, 2,3, 3,2,3, 1},
            {1, 2,3, 4,1,0, 1},
            {0, 0,1, 5,0,1, 0},
            {0, 1,0, 5,1,2, 1},
      };
      info = "a=c\nb=d\nA=60\nB=120\nC=60\n(D=120)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .25;
      double h = w*Math.sqrt(3);
      double f = 2*getParam(paramValues,0)/100.;
      double g = 2-f;
    
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,f*h,-f*w);
      baseTile.setPoint(2,h+h,(g-f)*w);
      baseTile.setPoint(3,g*h, g*w);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(3)-tiles[7].getX(3);
      offsets[3] = tiles[1].getY(3)-tiles[7].getY(3);
   }
}
