package tilingTypes.P3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP3_02
	extends TilingType
{
	public TilingTypeP3_02(){
		super( "P3-2&11&13&14: Triangle strips", 3, SymmetryType.p2 );
		paramMin = new int[]{-100,  0,  0};
		paramMax = new int[]{ 100,100,100};
		paramDef = new int[]{  10, 50,  0};
		paramName = new String[]{ "Skew", "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 0,2, 0,2,0, 0},
      };
      info = "(A+B+C=180)";
	}

   public void recalcBase(double[] paramValues) {
      double ln1 = 2*(1+paramValues[1])/102.;
      double ln2 = 2-ln1;
      double os = ln1*Math.tan( paramValues[0]*.9 * DEG2RAD);

      baseTile.setPoint(0,       0,  0);
      baseTile.setPoint(1,     ln1,  0);
      baseTile.setPoint(2,ln1/2+os,ln2);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(0) - offsets[0]*paramValues[2]/100;
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(0) - offsets[1]*paramValues[2]/100;
   }
}
