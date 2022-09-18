package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_22
   extends TilingType
{
   public TilingTypeN4_22(){
      super( "N4-22", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 40};
      paramName = new String[]{ "Aspect" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 1,2, 0,1,2, 1},
            {0, 0,1, 2,0,1, 0},

            {0, 3,2, 1,3,0, 1},
            {1, 0,1, 4,0,1, 0},
            {1, 1,2, 4,1,2, 0},
            {0, 0,1, 6,0,1, 1},
      };
      info = "2a=d\nA=90\nB=90\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 2*getParam( paramValues,0)/100.;
      double ln2 = 2-ln1;
      ///x=rt3, y=2, d=1
      // x2 + (y-d)^2 = (2d)2
      // x2 + y2-2dy+d2 = 4d2
      // 3d2 + 2dy - (x2+y2) = 0
      // d = -2*y*sqrt(4y2+12(x2+y2))
      double ln3 = (Math.sqrt(ln2*ln2+3*(ln1*ln1+ln2*ln2))-ln2)/3;
    
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1,  0);
      baseTile.setPoint(2,ln1,ln2);
      baseTile.setPoint(3,  0,ln3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[1].getX(3);
      offsets[1] = tiles[0].getY(2)-tiles[1].getY(3);
      offsets[2] = tiles[3].getX(3)-tiles[6].getX(3);
      offsets[3] = tiles[3].getY(3)-tiles[6].getY(3);
   }
}
