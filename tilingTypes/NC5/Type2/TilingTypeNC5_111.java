package tilingTypes.NC5.Type2;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_111
   extends TilingType
{
   public TilingTypeNC5_111(){
      super( "NC5-111", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,3,4, 1},
            {1, 4,0, 1,0,4, 1},
            {0, 3,4, 2,1,2, 0},
            
            {0, 0,4, 0,1,0, 1},
            {1, 1,2, 4,3,4, 0},
            {1, 4,0, 5,0,4, 0},
            {0, 3,4, 6,1,2, 1},
      };
      info = "b=c=e=2d\na=2b\nA=C\nB+C=180\nB+D=360\n(A+C+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double w = .16;
      double h = w * Math.sqrt(15);
      
      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1, 4*w,  0);
      baseTile.setPoint(2, 5*w,  h);
      baseTile.setPoint(3, 3*w,  h);
      baseTile.setPoint(4, 2*w,2*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(4)-tiles[0].getX(2);
      offsets[1] = tiles[0].getY(4)-tiles[0].getY(2);
      offsets[2] = tiles[3].getX(0)-tiles[7].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[7].getY(1);
   }
}
