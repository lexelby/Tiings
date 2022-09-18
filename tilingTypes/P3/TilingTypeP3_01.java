package tilingTypes.P3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP3_01
	extends TilingType
{
	public TilingTypeP3_01(){
		super( "P3-1: 30-30-120 triangles", 3, SymmetryType.p6m );
		// params are angle/distance of the other two points relative to first one 
		paramMin = new int[]{};
		paramMax = new int[]{};
		paramDef = new int[]{};
		paramName = new String[]{ };
		
      // desc has: colour,    refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
		description = new int[][]{
		      {0, 0,0, 0,0,0, 0},
            {0, 0,2, 0,1,2, 0},
            {0, 1,2, 0,0,2, 0},
            {0, 0,1, 1,1,0, 0},
            {0, 0,2, 3,1,2, 0},
            {0, 1,2, 3,0,2, 0},
		      };
		
		info = "a=c\nA=30\nB=30\n(C=120)";
		labels = new int[]{0,1,2};
	}

   public void recalcBase(double[] paramValues) {
      baseTile.setPoint(0, 0, 0);
      baseTile.setPoint(1, 1, 0);
      baseTile.setPoint(2,.5, Math.sqrt(3)/6);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[1].getY(1)-tiles[0].getY(0);
   }
}
