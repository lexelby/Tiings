package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_02c
	extends TilingType
{
	public TilingTypeN4_02c(){
		super( "N4-2c", 4, SymmetryType.pmg);

		paramMin = new int[]{};
		paramMax = new int[]{};
		paramDef = new int[]{};
		paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,2,1, 0},
            {2, 1,2, 0,2,3, 1},
            {0, 0,3, 2,0,3, 0},
            {1, 0,1, 3,2,1, 0},
            {2, 1,2, 3,2,3, 1},

            {0, 0,1, 0,0,1, 1},
            {1, 0,1, 6,2,1, 1},
            {2, 1,2, 6,2,3, 0},
            {0, 0,3, 8,0,3, 1},
            {1, 0,1, 9,2,1, 1},
            {2, 1,2, 9,2,3, 0},
      
      };
      info = "b=c=d\nB=90\nC+2D=360\n(2A+C=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .7;
      double b = 90-2* Math.atan( .5) / DEG2RAD;

      double x3 = ln - ln*Math.cos( b * DEG2RAD);
      double y3 = ln - ln*Math.sin( b * DEG2RAD);
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, ln, ln);
      baseTile.setPoint(3, x3, y3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[2].getX(0)-tiles[8].getX(0);
      offsets[1] = tiles[2].getY(0)-tiles[8].getY(0);
      offsets[2] = tiles[1].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(2)-tiles[0].getY(0);
   }
}
