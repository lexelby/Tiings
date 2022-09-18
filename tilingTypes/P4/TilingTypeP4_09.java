package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_09
	extends TilingType
{
	public TilingTypeP4_09(){
		super( "P4-9&11&13&16&36&39: Split Zig-zag", 4, SymmetryType.pgg );
 
		paramMin = new int[]{  0,  0,  0};
		paramMax = new int[]{180,100,100};
		paramDef = new int[]{ 80, 60, 40};
		paramName = new String[]{ "Angle", "Relative Length" , "Relative Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 2,3, 0,3,2, 0},
            {0, 0,1, 0,1,2, 1},
            {0, 2,3, 2,3,2, 1},
            };
      info = "A+B=180\n(C+D=180)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 2*getParam( paramValues,1)/100.;
      double ln2 = 2 -ln1;
      double f = getParam( paramValues,2)/100.;
      double s2 = Math.sin( paramValues[0] * DEG2RAD);
      double c2 = Math.cos( paramValues[0] * DEG2RAD);

      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, ln1, 0);
      baseTile.setPoint(2, ln1 + (1-f)*ln2 * c2,     (1-f)*ln2 * s2 );
      baseTile.setPoint(3,   f*ln2 * c2, f*ln2 * s2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(0)-tiles[3].getX(1);
      offsets[1] = tiles[1].getY(0)-tiles[3].getY(1);
      offsets[2] = tiles[2].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(1)-tiles[0].getY(0);
   }
}
