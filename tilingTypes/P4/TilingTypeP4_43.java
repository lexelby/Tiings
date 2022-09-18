package tilingTypes.P4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP4_43
	extends TilingType
{
	public TilingTypeP4_43(){
		super( "P4-43: General Quadrangle", 4, SymmetryType.p2 );
		// params are angle/distance of the other three points relative to first one
		paramMin = new int[]{  0,  0,  0,  0};
		paramMax = new int[]{360,100,360,100};
		paramDef = new int[]{ 10, 50, 60, 35};
		paramName = new String[]{ "Angle 1", "Distance 1", "Angle 2", "Distance 2" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            };
      info = "(A+B+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln3 = paramValues[1]/40.;
      double ln5 = paramValues[3]/40.;
      double x2 = ln3 * Math.cos( paramValues[0] * DEG2RAD);
      double y2 = ln3 * Math.sin( paramValues[0] * DEG2RAD);
      double x3 = ln5 * Math.cos( (paramValues[0]+paramValues[2]) * DEG2RAD);
      double y3 = ln5 * Math.sin( (paramValues[0]+paramValues[2]) * DEG2RAD);
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1,   1, 0);
      baseTile.setPoint(2,  x2,y2);
      baseTile.setPoint(3,  x3,y3);
   }

   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(3)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(3)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(2)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(2)-tiles[0].getY(0);
   }
}
