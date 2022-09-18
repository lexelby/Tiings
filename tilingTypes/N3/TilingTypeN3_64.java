package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_64
   extends TilingType
{
   public TilingTypeN3_64(){
      super( "N3-64", 3, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,2, 0,2,1, 0},
            {2, 1,2, 1,0,2, 0},
            {3, 1,2, 0,1,0, 0},
            {0, 2,0, 0,0,2, 0},
            {1, 1,2, 4,2,1, 0},
            {2, 1,2, 5,0,2, 0},
            {3, 1,2, 4,1,0, 0},
      };
      info = "a=2b=c\n(A+B+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = 0.7;
      
      double w = ln*0.5;
      double h = w * Math.sqrt(15);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2,  w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(2)-tiles[6].getX(0);
      offsets[1] = tiles[2].getY(2)-tiles[6].getY(0);
      offsets[2] = tiles[0].getX(1)-tiles[7].getX(0);
      offsets[3] = tiles[0].getY(1)-tiles[7].getY(0);
   }
}
