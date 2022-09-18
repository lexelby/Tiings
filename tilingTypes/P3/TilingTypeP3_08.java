package tilingTypes.P3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP3_08
	extends TilingType
{
	public TilingTypeP3_08(){
		super( "P3-8: Drafters", 3, SymmetryType.p6m );
		// params are angle/distance of the other two points relative to first one 
		paramMin = new int[]{};
		paramMax = new int[]{};
		paramDef = new int[]{};
		paramName = new String[]{ };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,1,2, 1},
            {0, 0,1, 1,0,1, 0},
            {0, 1,2, 2,1,2, 1},
            {0, 0,1, 3,0,1, 0},
            {0, 1,2, 4,1,2, 1},
            {0, 0,1, 5,0,1, 0},
            {0, 1,2, 6,1,2, 1},
            {0, 0,1, 7,0,1, 0},
            {0, 1,2, 8,1,2, 1},
            {0, 0,1, 9,0,1, 0},
            {0, 1,2,10,1,2, 1},
            };
      info = "A=60\nB=30\n(C=90)";
   }

   public void recalcBase(double[] paramValues) {
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,   1, 0);
      baseTile.setPoint(2, .25, Math.sqrt(3)/4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[7].getX(0)-tiles[0].getX(0);
      offsets[3] = tiles[7].getY(0)-tiles[0].getY(0);
   }
}
