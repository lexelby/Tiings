package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_95b
   extends TilingType
{
   public TilingTypeNC5_95b(){
      super( "NC5-95b", 5, SymmetryType.pgg );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 1,0, 0,4,0, 0},
            {2, 0,4, 1,4,0, 0},
            {2, 0,1, 2,1,0, 0},
            {1, 0,4, 3,4,0, 0},
            {0, 4,0, 4,1,0, 0},

            {0, 0,1, 0,3,4, 1},
            {1, 1,0, 6,4,0, 1},
            {2, 0,4, 7,4,0, 1},
            {2, 0,1, 8,1,0, 1},
            {1, 0,4, 9,4,0, 1},
            {0, 4,0,10,1,0, 1},
      };
      info = "a=d+e\nb=e=2\nA=B\nA=C\nC+D=360\n(2A+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .25;
      final double c = .25;
      final double s = Math.sqrt(1-c*c);
      final double e = ln*3/2;
      final double h = ln * s/c;
      
      baseTile.setPoint(0, 0,     0);
      baseTile.setPoint(1, ln*3,     0);
      baseTile.setPoint(2, ln*3-e*c, e*s);
      baseTile.setPoint(3, ln*7/4, ln*s);
      baseTile.setPoint(4, ln,     h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[6].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[6].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[11].getX(0)-tiles[5].getX(3);
      offsets[3] = tiles[11].getY(0)-tiles[5].getY(3);
   }
}
