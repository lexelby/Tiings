package tilingTypes.P3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP3_03
	extends TilingType
{
	public TilingTypeP3_03(){
		super( "P3-3&5: Triangle Zig-zag", 3, SymmetryType.pgg );
		// params are angle/distance of the other two points relative to first one 
		paramMin = new int[]{  0,  0};
		paramMax = new int[]{180,100};
		paramDef = new int[]{ 72, 60};
		paramName = new String[]{ "Angle", "Relative Length" };
		
      // desc has: colour,    refcorner, tile2Ix, tile2refcorner,    corner2, tile2corner2,  mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,2, 0,2,0, 0},
            {0, 0,1, 0,1,2, 1},
            {0, 0,2, 2,2,0, 1},
      };
      info = "(A+B+C=180)";
	}


   public void recalcBase(double[] paramValues) {
      double ln1 = 2. * (paramValues[1]+1.)/102.;
      double ln2 = 2. -ln1;
      double s2 = Math.sin( paramValues[0] * DEG2RAD);
      double c2 = Math.cos( paramValues[0] * DEG2RAD);
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, ln1, 0);
      baseTile.setPoint(2, ln1 + ln2 * c2, ln2 * s2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(1)-tiles[0].getX(2);
      offsets[1] = tiles[3].getY(1)-tiles[0].getY(2);
      offsets[2] = tiles[3].getX(0)-tiles[1].getX(1);
      offsets[3] = tiles[3].getY(0)-tiles[1].getY(1);
   }
}
