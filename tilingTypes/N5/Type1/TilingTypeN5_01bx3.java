package tilingTypes.N5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN5_01bx3
   extends TilingType
{
   public TilingTypeN5_01bx3(){
      super( "N5-1bx3: type 1&2 (Dave Smith)", 5, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
         {0, 0,0, 0,0,0, 0},
         {1, 4,0, 0,0,1, 1},
         {2, 0,1, 1,2,3, 0},
         {3, 2,3, 2,4,0, 1},
         {4, 0,4, 3,0,1, 1},
         {5, 0,4, 4,3,4, 1},

         {0, 2,3, 4,0,1, 0},
         {1, 4,0, 6,0,1, 1},
         {2, 0,1, 7,2,3, 0},
         {3, 2,3, 8,4,0, 1},
         {4, 0,4, 9,0,1, 1},
         {5, 0,4,10,3,4, 1},
      };
      info = "a=b=d=2c\nc=e\nA=D\nD=E\nA+B=180\n(2A+C=360)";
   }

   public void recalcBase(double[] paramValues) {
      double w = 0.1;
      double h = w*Math.sqrt(15);

      baseTile.setPoint(0, 0,   0);
      baseTile.setPoint(1, 7*w, -h);
      baseTile.setPoint(2, 8*w, 0);
      baseTile.setPoint(3, 6*w, 2*h);
      baseTile.setPoint(4, 2*w, 2*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[5].getX(1)-tiles[0].getX(4);
      offsets[1] = tiles[5].getY(1)-tiles[0].getY(4);
      offsets[2] = tiles[11].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[11].getY(2)-tiles[0].getY(0);
   }
}
