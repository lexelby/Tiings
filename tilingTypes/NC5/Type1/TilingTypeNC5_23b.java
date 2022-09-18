package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_23b
   extends TilingType
{
   public TilingTypeNC5_23b(){
      super( "NC5-23b", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,0,4, 1},
            {1, 1,0, 0,3,4, 0},
            {0, 0,4, 2,0,4, 1},

            {0, 2,3, 2,4,3, 0},
            {1, 0,4, 4,0,4, 1},
            {1, 1,0, 4,3,4, 0},
            {0, 0,4, 6,0,4, 1},
      };
      info = "b=c=d\n2b=e\nA=90\nB=60\nC=240\nD=120\n(E=30)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double h = ln*Math.sqrt(3)/2;

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,  ln,  0);
      baseTile.setPoint(2,ln/2,  h);
      baseTile.setPoint(3,  ln,2*h);
      baseTile.setPoint(4,   0,4*h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(4)-tiles[0].getX(1);
      offsets[1] = tiles[3].getY(4)-tiles[0].getY(1);
      offsets[2] = tiles[0].getX(4)-tiles[7].getX(2);
      offsets[3] = tiles[0].getY(4)-tiles[7].getY(2);
   }
}
