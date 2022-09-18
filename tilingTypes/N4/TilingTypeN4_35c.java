package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_35c
   extends TilingType
{
   public TilingTypeN4_35c(){
      super( "N4-35c", 4, SymmetryType.pmg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {2, 0,3, 0,0,3, 1},
            {1, 2,3, 1,2,3, 0},
            {1, 1,0, 2,0,1, 0},
            {2, 2,3, 3,2,3, 1},
            {0, 0,3, 4,0,3, 0},
            
            {0, 1,2, 0,1,2, 1},
            {2, 0,3, 6,0,3, 0},
            {1, 2,3, 7,2,3, 1},
            {1, 1,0, 8,0,1, 1},
            {2, 2,3, 9,2,3, 0},
            {0, 0,3,10,0,3, 1},
            
      };
      info = "a+c=d\nA=90\nB=90\nC=60\n(D=120)";
   }

   public void recalcBase(double[] paramValues) {
      double h = 1;
      double h2 = h*3;
      double w = 2*h*Math.sqrt(3);
      
      double f = h+w;
      h /= f;
      h2 /= f;
      w /= f;
      
      baseTile.setPoint(0, 0,  0);
      baseTile.setPoint(1, w,  0);
      baseTile.setPoint(2, w, h2);
      baseTile.setPoint(3, 0,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(1)-tiles[1].getX(1);
      offsets[1] = tiles[7].getY(1)-tiles[1].getY(1);
      offsets[2] = tiles[4].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[4].getY(0)-tiles[0].getY(0);
   }
}
